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
import java.util.List;
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
            if(checkActivityExists(activityId))
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
                            if(!pair.getValue().toString().equals("0"))
                            {
                                powerlinkFacadeRemote.createPowerLink(new PowerLink_dto(parseLong("1"),new Activity_dto(parseLong(activityId)),new Power_dto(powerFacadeRemote.createPower(new Power_dto(parseLong("1"),new BigDecimal(pair.getValue().toString()),new BigInteger(pair.getKey().toString()))))));
                            }
                        }
                    };
                    executor.submit(task);
                    it.remove();
                }
                executor.shutdown();
                return Json.createObjectBuilder().add("message", "successful").build().toString();
            }
            else
            {
                return Json.createObjectBuilder().add("message", "already exists").build().toString();
            }
        }
        catch(Exception e)
        {
            return Json.createObjectBuilder().add("message", "unsuccessful").build().toString();
        }
    }
    
    @GET
    @Path("list/powerstream")
    @Produces({MediaType.APPLICATION_JSON})
    public String findAllPowerStream(@QueryParam("activityId") String activityId)
    {
        try
        {
            List<PowerLink_dto> powerlinkstream = powerlinkFacadeRemote.findAll();
            powerlinkstream.removeIf((PowerLink_dto a) -> a.getActivityId().getActivityId() !=  parseLong(activityId));
            List<Power_dto> powerstream = powerFacadeRemote.findAll();
            HashMap<Long, Long> datastream = new HashMap<Long, Long>();

            int found = 0;
                for(PowerLink_dto pl : powerlinkstream)
                { 
                    for(Power_dto p : powerstream)
                    { 
                        if(pl.getPowerId().getPowerId().equals(p.getPowerId()))
                        {
                            found++;
                            datastream.put(p.getSecondstamp().longValue(), p.getDatapoint().longValue());
                        }
                        
                    }
                }

                System.out.println("COUNTER: " + powerstream.size() + "\n" + "FOUND: "+ found);
                return Json.createObjectBuilder().add("powerstream", new JSONObject(datastream).toString()).build().toString();


        }
        catch(Exception e)
        {
            System.out.println(e);
            return Json.createObjectBuilder().add("message", "unsuccessful").build().toString();
        }
    }
    
    public boolean checkActivityExists(String activityId)
    {
        List<PowerLink_dto> powerlinkstream = powerlinkFacadeRemote.findAll();
        for(PowerLink_dto pl : powerlinkstream)
        { 
            if(pl.getActivityId().getActivityId() == parseLong(activityId))
            {
                return false;
            }
        }
        return true;
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
