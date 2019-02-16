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
 *
 * @author 2008s
 */
@Stateless
@Path("services.credentials")
public class CredentialsFacadeREST implements Serializable {

    private static Credentials_FacadeRemote credentialsFacadeRemote;

    public CredentialsFacadeREST() 
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
    
    
//
//    @PUT
//    @Path("{id}")
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void edit(@PathParam("id") Long id, Credentials entity) {
//        super.edit(entity);
//    }
//
//    @DELETE
//    @Path("{id}")
//    public void remove(@PathParam("id") Long id) {
//        super.remove(super.find(id));
//    }
//
//    @GET
//    @Path("{id}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public Credentials find(@PathParam("id") Long id) {
//        return super.find(id);
//    }
//
//    @GET
//    @Override
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<Credentials> findAll() {
//        return super.findAll();
//    }
//
//    @GET
//    @Path("{from}/{to}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<Credentials> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
//        return super.findRange(new int[]{from, to});
//    }
//
//    @GET
//    @Path("count")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String countREST() {
//        return String.valueOf(super.count());
//    }
//
//    @Override
//    protected EntityManager getEntityManager() {
//        return em;
//    }
    
}


class CredentialsTest
{
    
}