package services.service;

import api.RequestType;
import api.WebhookFactory;
import dto.ActivitySummary_dto;
import dto.Activity_dto;
import dto.Athlete_dto;
import static java.lang.Long.parseLong;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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
import remote.Activity_FacadeRemote;


@Stateless
@Path("services.activitysummary")
public class ActivitySummaryFacadeREST 
{
    private static Activity_FacadeRemote activityFacadeRemote;  
    private static ActivitySummary_FacadeRemote activitySummaryFacadeRemote;  
    
    public ActivitySummaryFacadeREST() 
    {
        try
        {
            Context initial = new InitialContext();
            activityFacadeRemote = (Activity_FacadeRemote) initial.lookup("activityfacade");
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
                            jsonObject.getLong("id"),
                            BigInteger.valueOf(jsonObject.optInt("moving_time")),
                            BigDecimal.valueOf(jsonObject.optLong("distance")),
                            BigDecimal.valueOf(jsonObject.optLong("max_speed")),
                            BigDecimal.valueOf(jsonObject.optLong("max_watts")),
                            BigDecimal.valueOf(jsonObject.optLong("average_speed")),
                            BigDecimal.valueOf(jsonObject.optLong("average_watts")),
                            BigDecimal.valueOf(jsonObject.optLong("average_cadence")),
                            BigDecimal.valueOf(jsonObject.optInt("kilojoules")),
                            new Activity_dto(jsonObject.getLong("id"))));
                  count++;
                }
                catch(Exception e)
                {
                    System.out.println(e);
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
    public String findAllActivities(@QueryParam("athleteId") String athleteId)
    {
        try
        {
            List<Activity_dto> activityList = activityFacadeRemote.findAll();
            activityList.removeIf((Activity_dto a) -> a.getAthleteId().getAthleteId() !=  parseLong(athleteId));
            List<ActivitySummary_dto> activitySummaryList = activitySummaryFacadeRemote.findAll();
            List<ActivitySummary_dto> activitySummaryReturn = new ArrayList<ActivitySummary_dto>();
            for (Activity_dto activity : activityList) 
            {
                for (ActivitySummary_dto activitySummary : activitySummaryList) 
                {
                    if(activitySummary.getActivityId().getActivityId().equals(activity.getActivityId()))
                    {
                        activitySummaryReturn.add(activitySummary);
                    }
                }
            }
            
            return new JSONArray(activitySummaryReturn).toString();
        }
        catch(Exception e)
        {
            return Json.createObjectBuilder().add("message", "unsuccessful").build().toString();
        }
    }
    
}
