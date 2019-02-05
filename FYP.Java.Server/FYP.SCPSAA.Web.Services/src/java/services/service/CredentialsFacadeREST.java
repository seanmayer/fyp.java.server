/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.service;

import com.google.gson.Gson;
import dto.Credentials_dto;
import static java.lang.Long.parseLong;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;
import remote.Credentials_FacadeRemote;


/**
 *
 * @author 2008s
 */
@Stateless
@Path("services.credentials")
public class CredentialsFacadeREST  {

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
    public String createCredentials() 
    {
          //Credentials_dto d = new Credentials_dto(parseLong("1"), "username", "password");
//        Gson gson = new Gson();
//        return Response.ok(gson.toJson(d)).build();   
        try
        {

            //credentialsFacadeRemote.createCredentials(entity);
            return Json.createObjectBuilder().add("message", "successful").build().toString();
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
