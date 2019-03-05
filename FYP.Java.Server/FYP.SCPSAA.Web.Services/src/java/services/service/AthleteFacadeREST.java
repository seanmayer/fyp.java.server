/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.service;

import api.RequestType;
import api.WebhookFactory;
import dto.Athlete_dto;
import dto.Credentials_dto;
import static java.lang.Long.parseLong;
import java.math.BigDecimal;
import remote.Athlete_FacadeRemote;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author 2008s
 */
@Stateless
@Path("services.athlete")
public class AthleteFacadeREST 
{
    private static Athlete_FacadeRemote athleteFacadeRemote;  
    
    
    public AthleteFacadeREST() 
    {
        try
        {
            Context initial = new InitialContext();
            athleteFacadeRemote = (Athlete_FacadeRemote) initial.lookup("athletefacade");
        }
        catch(Exception ex)
        {
            System.out.println("Caught an exception");
            ex.printStackTrace();
        }
    }
    
    @GET
    @Path("create/athlete/{athleteId}/{credentialsId}/{stravaId}/{accessToken}")
    @Produces({MediaType.APPLICATION_JSON})
    public String createAthlete(@PathParam("athleteId") String athleteId, @PathParam("credentialsId") String credentialsId, @PathParam("stravaId") String stravaId, @PathParam("accessToken") String accessToken)
    {
        try
        {

            JSONObject athleteJsonObject = new JSONObject(WebhookFactory.getInstance(stravaId, accessToken).createRequest(RequestType.ATHLETE_REQUEST));
            athleteFacadeRemote.createCredendentedAthlete(new Credentials_dto(parseLong(credentialsId)), new Athlete_dto(parseLong(athleteId),athleteJsonObject.getLong("id"),athleteJsonObject.getString("firstname"),athleteJsonObject.getString("lastname")));
            return Json.createObjectBuilder().add("message", "success").build().toString();
        }
        catch(Exception e)
        {
            return Json.createObjectBuilder().add("message", "unsuccessful").build().toString();
        }
    }
    
    @GET
    @Path("find/athlete/{athleteId}")
    @Produces({MediaType.APPLICATION_JSON})
    public String findAthlete(@PathParam("athleteId") String athleteId)
    {
        try
        {
            Athlete_dto a = athleteFacadeRemote.findById(parseLong(athleteId));
            
            return Json.createObjectBuilder().add("athleteId", a.getAthleteId())
                                             .add("stravaId",a.getStravaid())
                                             .add("firstname",a.getFirstname())
                                             .add("lastname",a.getLastname()).build().toString();
        }
        catch(Exception e)
        {
            return Json.createObjectBuilder().add("message", "unsuccessful").build().toString();
        }
    }    
    
    @GET
    @Path("list/athletes")
    @Produces({MediaType.APPLICATION_JSON})
    public String findAllCredentials()
    {
        try
        {
            return new JSONArray(athleteFacadeRemote.findAll()).toString();
        }
        catch(Exception e)
        {
            return Json.createObjectBuilder().add("message", "unsuccessful").build().toString();
        }
    }

    
    
}
