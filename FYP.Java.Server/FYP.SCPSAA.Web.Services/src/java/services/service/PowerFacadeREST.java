package services.service;

import api.RequestType;
import api.WebhookFactory;
import dto.Activity_dto;
import dto.PowerLink_dto;
import dto.Power_dto;
import static java.lang.Long.parseLong;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import remote.PowerLink_FacadeRemote;
import remote.Power_FacadeRemote;

@Stateless
@Path("services.power")
public class PowerFacadeREST 
{
    private static Power_FacadeRemote powerFacadeRemote;  
    private static PowerLink_FacadeRemote powerlinkFacadeRemote;
    private JSONArray watts = null;
    private JSONArray time = null;
    
    public PowerFacadeREST() 
    {
        try
        {
            Context initial = new InitialContext();
            powerFacadeRemote = (Power_FacadeRemote) initial.lookup("powerfacade");
            powerlinkFacadeRemote = (PowerLink_FacadeRemote)initial.lookup("powerlinkfacade");
        }
        catch(Exception ex)
        {
            System.out.println("Caught an exception");
            ex.printStackTrace();
        }
    }
    
    @GET
    @Path("create/powerstream")
    @Produces({MediaType.APPLICATION_JSON})
    public String createPower(@QueryParam("activityId") String activityId, @QueryParam("stravaId") String stravaId, @QueryParam("accessToken") String accessToken) 
    {
        try
        {
            WebhookFactory whf = WebhookFactory.getInstance(stravaId,accessToken,activityId); 
            getDataStreamJSONArrays(new JSONArray(whf.createRequest(RequestType.POWER_STREAM)));
            ExecutorService executor = Executors.newCachedThreadPool();
            Iterator it = createHashmapFromJSONArrays().entrySet().iterator();
            while (it.hasNext()) 
            {
                Map.Entry pair = (Map.Entry)it.next();
                Runnable task = new Runnable() 
                {
                    public void run()
                    {
                        powerlinkFacadeRemote.createPowerLink(new PowerLink_dto(parseLong("1"),
                                                 new Activity_dto(parseLong("156272543")),
                                                 new Power_dto(powerFacadeRemote.createPower(new Power_dto(parseLong("1"),
                                                                         new BigDecimal(pair.getValue().toString()),
                                                                         new BigInteger(pair.getKey().toString()))))));
                    }
                };
                executor.submit(task);
                it.remove();
            }
            executor.shutdown();
            return Json.createObjectBuilder().add("message", "successful").build().toString();
        }
        catch(Exception e)
        {
            return Json.createObjectBuilder().add("message", "unsuccessful").build().toString();
        }
    }
    public HashMap<Integer, String> createHashmapFromJSONArrays() throws JSONException
    {
        HashMap<Integer, String> datastream = new HashMap<Integer, String>();
            
        assert(watts.length() == time.length());
        for (int i=0; i<watts.length(); i++) 
        {
            datastream.put(Integer.parseInt(time.get(i).toString()), watts.get(i).toString());
        }
        
        return datastream;
    }
    
    public void getDataStreamJSONArrays(JSONArray values)
    {
            for (int i = 0; i < values.length(); i++) 
            {
                try
                {
                  JSONObject jsonObject = values.getJSONObject(i);
                  
                  if(jsonObject.getString("type").equals("watts"))
                  {
                      watts = jsonObject.getJSONArray("data");
                  }
                  if(jsonObject.getString("type").equals("time"))
                  {
                      time = jsonObject.getJSONArray("data");
                  }
                }
                catch(Exception e){}
            }
    }

    
}
