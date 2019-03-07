package services.service;

import api.RequestType;
import api.WebhookFactory;
import dto.Activity_dto;
import dto.Athlete_dto;
import static java.lang.Long.parseLong;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.joda.time.format.DateTimeFormat;
import org.json.JSONArray;
import org.json.JSONObject;
import remote.Activity_FacadeRemote;

@Stateless
@Path("services.activity")
public class ActivityFacadeREST 
{
    private static Activity_FacadeRemote activityFacadeRemote;  
    
    public ActivityFacadeREST() 
    {
        try
        {
            Context initial = new InitialContext();
            activityFacadeRemote = (Activity_FacadeRemote) initial.lookup("activityfacade");
        }
        catch(Exception ex)
        {
            System.out.println("Caught an exception");
            ex.printStackTrace();
        }
    }
    
    @GET
    @Path("create/activities")
    @Produces({MediaType.APPLICATION_JSON})
    public String createActivities(@QueryParam("athleteId") String athleteId, @QueryParam("stravaId") String stravaId, @QueryParam("accessToken") String accessToken) 
    {
        try
        {
            WebhookFactory whf = WebhookFactory.getInstance(stravaId,accessToken); 
            JSONArray values = new JSONArray(whf.createRequest(RequestType.ACTIVITIES_LIST_REQUEST)); 
            
            for (int i = 0; i < values.length(); i++) 
            {
                  JSONObject jsonObject = values.getJSONObject(i); 

                  activityFacadeRemote.createActivity(new Activity_dto(
                          jsonObject.getLong("id"),
                          jsonObject.getJSONObject("athlete").getLong("id"),
                          jsonObject.getString("name"),
                          DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ").parseDateTime(jsonObject.getString("start_date_local")).toDate(),
                          jsonObject.getString("timezone"), 
                          new Athlete_dto(parseLong(athleteId))));
            }
            return Json.createObjectBuilder().add("message", "successful").build().toString();
        }
        catch(Exception e)
        {
            return Json.createObjectBuilder().add("message", "unsuccessful").build().toString();
        }
    }
    
}
