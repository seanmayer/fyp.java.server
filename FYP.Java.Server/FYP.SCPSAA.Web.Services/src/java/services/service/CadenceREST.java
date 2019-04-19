package services.service;

import api.RequestType;
import api.WebhookFactory;
import dto.Activity_dto;
import dto.CadenceLink_dto;
import dto.Cadence_dto;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.json.JSONArray;
import remote.CadenceLink_FacadeRemote;
import remote.Cadence_FacadeRemote;
import static java.lang.Long.parseLong;
import java.util.HashMap;
import java.util.List;
import javax.json.Json;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Sean Mayer
 * Cadence Web Service
 */
@Stateless
@Path("services.cadence")
public class CadenceREST 
{
    private static Cadence_FacadeRemote cadenceFacadeRemote;  
    private static CadenceLink_FacadeRemote cadencelinkFacadeRemote;
    private JSONArray cadence = null;
    private JSONArray time = null;
    

     /**
     * Constructor for initiating Context and looking up cadencefacade bean and cadencelinkfacade bean
     */
    public CadenceREST() 
    {
        try
        {
            Context initial = new InitialContext();
            cadenceFacadeRemote = (Cadence_FacadeRemote) initial.lookup("cadencefacade");
            cadencelinkFacadeRemote = (CadenceLink_FacadeRemote)initial.lookup("cadencelinkfacade");
        }
        catch(Exception ex)
        {
            System.out.println("Caught an exception");
            ex.printStackTrace();
        }
    }
    
    /**
     * Create Cadence
     * @param activityId - Activity ID retrieved from Strava API Activity IDs
     * @param stravaId - Strava ID retrieved from Strava API
     * @param accessToken - Access Token retrieved from Strava API
     * @return JSONObjectBuilder message:success or message unsuccessful or already exists
     */
    @GET
    @Path("create/cadencestream")
    @Produces({MediaType.APPLICATION_JSON})
    public String createCadence(@QueryParam("activityId") String activityId, @QueryParam("stravaId") String stravaId, @QueryParam("accessToken") String accessToken) 
    {
        try
        {
            if(checkActivityExists(activityId))
            {
                WebhookFactory whf = WebhookFactory.getInstance(stravaId,accessToken,activityId); 
                getDataStreamJSONArrays(new JSONArray(whf.createRequest(RequestType.CADENCE_STREAM)));
                
                for (Map.Entry pair : createHashmapFromJSONArrays().entrySet()) {
                    if(!pair.getValue().toString().equals("0"))
                    {
                        cadencelinkFacadeRemote.createCadenceLink(
                                new CadenceLink_dto(parseLong("1"),
                                        new Activity_dto(parseLong(activityId)),
                                        new Cadence_dto(cadenceFacadeRemote.createCadence(
                                                new Cadence_dto(parseLong("1"),
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
     * Find All Cadence Stream
     * @param activityId Activity ID retrieved from Strava API Activity IDs
     * @return JSONObjectBuilder JSONObject that returns a HashMap Array of Stream Data
     */
    @GET
    @Path("list/cadencestream")
    @Produces({MediaType.APPLICATION_JSON})
    public String findAllCadenceStream(@QueryParam("activityId") String activityId)
    {
        try
        {
            List<CadenceLink_dto> cadencelinkstream = cadencelinkFacadeRemote.findAll();
            cadencelinkstream.removeIf((CadenceLink_dto a) -> a.getActivityId().getActivityId() !=  parseLong(activityId));
            List<Cadence_dto> cadencestream = cadenceFacadeRemote.findAll();
            HashMap<Long, Long> datastream = new HashMap<Long, Long>();

            
                for(CadenceLink_dto cl : cadencelinkstream)
                { 
                    for(Cadence_dto c : cadencestream)
                    {   
                        if(cl.getCadenceId().getCadenceId().equals(c.getCadenceId()))
                        {
                            datastream.put(c.getSecondstamp().longValue(), c.getDatapoint().longValue());
                        }
                    }
                }

                System.out.println("COUNTER: " + cadencestream.size());
                return Json.createObjectBuilder().add("cadencestream", new JSONObject(datastream).toString()).build().toString();


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
        List<CadenceLink_dto> cadencelinkstream = cadencelinkFacadeRemote.findAll();
        for(CadenceLink_dto cl : cadencelinkstream)
        { 
            if(cl.getActivityId().getActivityId() == parseLong(activityId))
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
            
        assert(cadence.length() == time.length());
        for (int i=0; i<cadence.length(); i++) 
        {
            datastream.put(Integer.parseInt(time.get(i).toString()), cadence.get(i).toString());
        }
        
        return datastream;
    }
    
    /**
     * Get Data Stream JSON Arrays
     * @param values Strava API JSON Return for Activity Stream Cadence
     */
    public void getDataStreamJSONArrays(JSONArray values)
    {
            for (int i = 0; i < values.length(); i++) 
            {
                try
                {
                  JSONObject jsonObject = values.getJSONObject(i);
                  
                  if(jsonObject.getString("type").equals("cadence"))
                  {
                      cadence = jsonObject.getJSONArray("data");
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
