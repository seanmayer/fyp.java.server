package services.service;

import api.RequestType;
import api.WebhookFactory;
import dto.ActivitySummary_dto;
import dto.Activity_dto;
import dto.Athlete_dto;
import static java.lang.Long.parseLong;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
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
import remote.ActivitySummary_FacadeRemote;


@Stateless
@Path("services.activitysummary")
public class ActivitySummaryFacadeREST 
{
    private static ActivitySummary_FacadeRemote activitySummaryFacadeRemote;  
    
    public ActivitySummaryFacadeREST() 
    {
        try
        {
            Context initial = new InitialContext();
            activitySummaryFacadeRemote = (ActivitySummary_FacadeRemote) initial.lookup("activitysummaryfacade");
        }
        catch(Exception ex)
        {
            System.out.println("Caught an exception");
            ex.printStackTrace();
        }
    }
    
    @GET
    @Path("create/activitysummaries")
    @Produces({MediaType.APPLICATION_JSON})
    public String createActivitySummary(@QueryParam("stravaId") String stravaId, @QueryParam("accessToken") String accessToken) 
    {
        try
        {
            WebhookFactory whf = WebhookFactory.getInstance(stravaId,accessToken); 
            JSONArray values = new JSONArray(whf.createRequest(RequestType.ACTIVITY_SUMMARY)); 
            int count = 0;
            for (int i = 0; i < values.length(); i++) 
            {
                try
                {
                  JSONObject jsonObject = values.getJSONObject(i); 
                  activitySummaryFacadeRemote.createActivitySummary(new ActivitySummary_dto(
                            parseLong("1"),
                            BigInteger.valueOf(jsonObject.getInt("moving_time")),
                            BigDecimal.valueOf(jsonObject.getLong("distance")),
                            BigDecimal.valueOf(jsonObject.getLong("max_speed")),
                            BigDecimal.valueOf(jsonObject.getLong("max_watts")),
                            BigDecimal.valueOf(jsonObject.getLong("average_speed")),
                            BigDecimal.valueOf(jsonObject.getLong("average_watts")),
                            BigDecimal.valueOf(jsonObject.getLong("average_cadence")),
                            BigDecimal.valueOf(jsonObject.getInt("kilojoules")),
                            new Activity_dto(jsonObject.getLong("id"))));
                  count++;
                }
                catch(Exception e)
                {
                    
                }
            }
            return Json.createObjectBuilder().add("message", "successful").add("updateCount", count).build().toString();
        }
        catch(Exception e)
        {
            return Json.createObjectBuilder().add("message", "unsuccessful").build().toString();
        }
    }
    
    @GET
    @Path("list/activitysummaries")
    @Produces({MediaType.APPLICATION_JSON})
    public String findAllActivities(@QueryParam("activityId") String activityId)
    {
        try
        {
            List<ActivitySummary_dto> activitySummaryList = activitySummaryFacadeRemote.findAll();
            activitySummaryList.removeIf((ActivitySummary_dto a) -> a.getActivityId().getActivityId() !=  parseLong(activityId));
            return new JSONArray(activitySummaryList).toString();
        }
        catch(Exception e)
        {
            System.out.println(e);
            return Json.createObjectBuilder().add("message", "unsuccessful").build().toString();
        }
    }
    
}
