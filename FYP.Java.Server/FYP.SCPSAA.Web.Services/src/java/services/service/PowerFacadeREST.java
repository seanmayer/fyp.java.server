package services.service;

import api.RequestType;
import api.WebhookFactory;
import dto.Activity_dto;
import dto.Athlete_dto;
import dto.PowerLink_dto;
import dto.Power_dto;
import static java.lang.Long.parseLong;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.joda.time.format.DateTimeFormat;
import org.json.JSONArray;
import org.json.JSONObject;
import remote.Activity_FacadeRemote;
import remote.Power_FacadeRemote;

@Stateless
@Path("services.power")
public class PowerFacadeREST 
{
    private static Power_FacadeRemote powerFacadeRemote;  
    
    public PowerFacadeREST() 
    {
        try
        {
            Context initial = new InitialContext();
            powerFacadeRemote = (Power_FacadeRemote) initial.lookup("powerfacade");
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
    public String createActivities(@QueryParam("activityId") String activityId, @QueryParam("stravaId") String stravaId, @QueryParam("accessToken") String accessToken) 
    {
        try
        {
            WebhookFactory whf = WebhookFactory.getInstance(stravaId,accessToken,activityId); 
            JSONArray values = new JSONArray(whf.createRequest(RequestType.POWER_STREAM)); 
            int count = 0;
            for (int i = 0; i < values.length(); i++) 
            {
                try
                {
                  JSONObject jsonObject = values.getJSONObject(i); 
                  System.out.println(jsonObject.getString("type")); // gets the type!
                  //System.out.println(jsonObject.getJSONArray("data")); //gets the data!
                  
                  //activityFacadeRemote.createActivity(new Activity_dto(jsonObject.getLong("id"),jsonObject.getJSONObject("athlete").getLong("id"),jsonObject.getString("name"),DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZ").parseDateTime(jsonObject.getString("start_date_local")).toDate(),jsonObject.getString("timezone"), new Athlete_dto(parseLong(athleteId))));
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
    
    
//            requestPower.createPower(new Power_dto(parseLong("1"),new BigDecimal("2500"),new BigInteger("1")));
//        requestPowerLink.createPowerLink(new PowerLink_dto(parseLong("1"),
//                                         new Activity_dto(parseLong("156272543")),
//                                         new Power_dto(parseLong("1"))));
    
   

}
