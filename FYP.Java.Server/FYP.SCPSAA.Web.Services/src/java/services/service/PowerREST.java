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
import java.util.List;
import java.util.Map;
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

/**
 * @author Sean Mayer
 * Power Web Service
 */
@Stateless
@Path("services.power")
public class PowerREST 
{
    private static Power_FacadeRemote powerFacadeRemote;  
    private static PowerLink_FacadeRemote powerlinkFacadeRemote;
    private JSONArray watts = null;
    private JSONArray time = null;
    
     /**
     * Constructor for initiating Context and looking up powerfacade bean and powerlinkfacade bean
     */
    public PowerREST() 
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
    
    /**
     *
     * Create Cadence
     * @param activityId - Activity ID retrieved from Strava API Activity IDs
     * @param stravaId - Strava ID retrieved from Strava API
     * @param accessToken - Access Token retrieved from Strava API
     * @return JSONObjectBuilder message:success or message unsuccessful or already exists
     */
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

                for (Map.Entry pair : createHashmapFromJSONArrays().entrySet()) 
                {
                    if(!pair.getValue().toString().equals("0"))
                    {
                        powerlinkFacadeRemote.createPowerLink(new PowerLink_dto(parseLong("1"),new Activity_dto(parseLong(activityId)),new Power_dto(
                        powerFacadeRemote.createPower(new Power_dto(parseLong("1"),new BigDecimal(pair.getValue().toString()),new BigInteger(pair.getKey().toString()))))));
                    }

                }

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

    /**
     * Find All Power Stream
     * @param activityId Activity ID retrieved from Strava API Activity IDs
     * @return JSONObjectBuilder JSONObject that returns a HashMap Array of Stream Data
     */
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
    
    /**
     * Check Activity Exists
     * @param activityId Activity ID retrieved from Strava API Activity IDs
     * @return true or false
     */
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
    
    /**
     * Creates HashMap From JSON Arrays
     * @return HashMap
     * @throws JSONException
     */
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
    
    /**
     * Get Data Stream JSON Arrays
     * @param values Strava API JSON Return for Activity Stream Power
     */
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
