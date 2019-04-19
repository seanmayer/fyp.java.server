/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.service;

import dto.Credentials_dto;
import java.io.Serializable;
import static java.lang.Long.parseLong;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.json.CredentialsJSONObject;
import org.json.JSONArray;
import org.json.JSONObject;
import remote.Credentials_FacadeRemote;


/**
 * @author Sean Mayer
 * Credentials Web Service 
 */
@Stateless
@Path("services.credentials")
public class CredentialsREST implements Serializable {

    private static Credentials_FacadeRemote credentialsFacadeRemote;

    /**
     * Constructor for initiating Context and looking up credentialsfacade bean
     */
    public CredentialsREST() 
    {
        try
        {
            Context initial = new InitialContext();
            credentialsFacadeRemote = (Credentials_FacadeRemote) initial.lookup("credentialsfacade");
        }
        catch(Exception ex)
        {
            System.out.println("Caught an exception");
            ex.printStackTrace();
        }
    }

    /**
     * Create Credentials
     * @param entity CredentialsJSONObject
     * @return JSONObjectBuilder message:success or message unsuccessful
     */
    @POST
    @Path("create/credentials")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public String createCredentials(CredentialsJSONObject entity) 
    { 
        try
        {
            credentialsFacadeRemote.createCredentials(new Credentials_dto(entity.getCredentialsId(), entity.getUsername(), entity.getPassword()));
            return Json.createObjectBuilder().add("message", "successful").build().toString();
        }
        catch(Exception e)
        {
            return Json.createObjectBuilder().add("message", "unsuccessful").build().toString();
        }
    }
    
    /**
     * Find All Credentials
     * @return JSONObjectBuilder JSONArray or message unsuccessful
     */
    @GET
    @Path("list/credentials")
    @Produces({MediaType.APPLICATION_JSON})
    public String findAllCredentials()
    {
        try
        {
            return new JSONArray(credentialsFacadeRemote.findAll()).toString();
        }
        catch(Exception e)
        {
            return Json.createObjectBuilder().add("message", "unsuccessful").build().toString();
        }
    }

    
}
