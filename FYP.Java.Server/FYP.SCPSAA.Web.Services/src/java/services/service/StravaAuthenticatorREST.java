/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.service;

import api.RequestType;
import api.WebhookFactory;
import java.io.Serializable;
import javax.ejb.Singleton;
import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.json.JSONObject;

/**
 * @author Sean Mayer
 * Strava Authentication Web Service (deprecated)
 */
@Singleton
@Path("services.strava.authenticator")
public class StravaAuthenticatorREST implements Serializable 
{

    /**
     *
     * @param stravaId
     * @param accessToken
     * @return
     */
    @GET
    @Path("authenticate/athlete/{stravaId}/{accessToken}")
    @Produces({MediaType.APPLICATION_JSON})
    public String authenticateStravaUser(@PathParam("stravaId") String stravaId, @PathParam("accessToken") String accessToken) 
    {
        try
        {
            JSONObject athleteJsonObject = new JSONObject(WebhookFactory.getInstance(stravaId, accessToken).createRequest(RequestType.ATHLETE_REQUEST));
            return Json.createObjectBuilder().add("message", "success").build().toString();
        }
        catch(Exception e)
        {
            return Json.createObjectBuilder().add("message", "unsuccessful").build().toString();
        }
    }

}
