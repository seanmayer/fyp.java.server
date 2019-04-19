package services.service;

import remote.SpeedLink_FacadeRemote;
import remote.Speed_FacadeRemote;
import api.RequestType;
import api.WebhookFactory;
import dto.Activity_dto;
import dto.SpeedLink_dto;
import dto.Speed_dto;
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

/**
 * @author Sean Mayer
 * Speed Web Service
 */
@Stateless
@Path("services.speed")
public class SpeedREST 
{
    private static Speed_FacadeRemote speedFacadeRemote;  
    private static SpeedLink_FacadeRemote speedlinkFacadeRemote;
    private JSONArray speed = null;
    private JSONArray time = null;
    
     /**
     * Constructor for initiating Context and looking up speedfacade bean and speedlinkfacade bean
     */
    public SpeedREST() 
    {
        try
        {
            Context initial = new InitialContext();
            speedFacadeRemote = (Speed_FacadeRemote) initial.lookup("speedfacade");
            speedlinkFacadeRemote = (SpeedLink_FacadeRemote)initial.lookup("speedlinkfacade");
        }
        catch(Exception ex)
        {
            System.out.println("Caught an exception");
            ex.printStackTrace();
        }
    }
    
    /**
     *
     * Create Speed
     * @param activityId - Activity ID retrieved from Strava API Activity IDs
     * @param stravaId - Strava ID retrieved from Strava API
     * @param accessToken - Access Token retrieved from Strava API
     * @return JSONObjectBuilder message:success or message unsuccessful or already exists
     */
    @GET
    @Path("create/speedstream")
    @Produces({MediaType.APPLICATION_JSON})
    public String createSpeed(@QueryParam("activityId") String activityId, @QueryParam("stravaId") String stravaId, @QueryParam("accessToken") String accessToken) 
    {
        try
        {
            if(checkActivityExists(activityId))
            {
                WebhookFactory whf = WebhookFactory.getInstance(stravaId,accessToken,activityId); 
                getDataStreamJSONArrays(new JSONArray(whf.createRequest(RequestType.SPEED_STREAM)));
                
                for (Map.Entry pair : createHashmapFromJSONArrays().entrySet()) {
                    if(!pair.getValue().toString().equals("0"))
                    {
                        speedlinkFacadeRemote.createSpeedLink(
                                new SpeedLink_dto(parseLong("1"),
                                        new Activity_dto(parseLong(activityId)),
                                        new Speed_dto(speedFacadeRemote.createSpeed(
                                                new Speed_dto(parseLong("1"),
                                                        new BigDecimal(pair.getValue().toString()),
                                                        new BigInteger(pair.getKey().toString()))))));
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
     * Find All Speed Stream
     * @param activityId Activity ID retrieved from Strava API Activity IDs
     * @return JSONObjectBuilder JSONObject that returns a HashMap Array of Stream Data
     */
    @GET
    @Path("list/speedstream")
    @Produces({MediaType.APPLICATION_JSON})
    public String findAllSpeedStream(@QueryParam("activityId") String activityId)
    {
        try
        {
            List<SpeedLink_dto> speedlinkstream = speedlinkFacadeRemote.findAll();
            speedlinkstream.removeIf((SpeedLink_dto a) -> a.getActivityId().getActivityId() !=  parseLong(activityId));
            List<Speed_dto> speedstream = speedFacadeRemote.findAll();
            HashMap<Long, Long> datastream = new HashMap<Long, Long>();

            
                for(SpeedLink_dto sl : speedlinkstream)
                { 
                    for(Speed_dto s : speedstream)
                    { 
                        if(sl.getSpeedId().getSpeedId().equals(s.getSpeedId()))
                        {
                            datastream.put(s.getSecondstamp().longValue(), convertVelocityToMph(s.getDatapoint().longValue()));
                        }
                    }
                }

                System.out.println("COUNTER: " + speedstream.size());
                return Json.createObjectBuilder().add("speedstream", new JSONObject(datastream).toString()).build().toString();


        }
        catch(Exception e)
        {
            System.out.println(e);
            return Json.createObjectBuilder().add("message", "unsuccessful").build().toString();
        }
    }
    
    /**
     * Converts Velocity To MPH
     * @param velocity retrieved from Strava API
     * @return (velocity / 0.44704)
     */
    public long convertVelocityToMph(long velocity)
    {
        return (long)(velocity / 0.44704);
    }
    
    /**
     * Check Activity Exists
     * @param activityId Activity ID retrieved from Strava API Activity IDs
     * @return true or false
     */
    public boolean checkActivityExists(String activityId)
    {
        List<SpeedLink_dto> speedlinkstream = speedlinkFacadeRemote.findAll();
        for(SpeedLink_dto sl : speedlinkstream)
        { 
            if(sl.getActivityId().getActivityId() == parseLong(activityId))
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
            
        assert(speed.length() == time.length());
        for (int i=0; i<speed.length(); i++) 
        {
            
            datastream.put(Integer.parseInt(time.get(i).toString()), speed.get(i).toString());
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
                  
                  if(jsonObject.getString("type").equals("velocity_smooth"))
                  {
                      speed = jsonObject.getJSONArray("data");
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
