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
    @Path("create/athlete/{credentialsId}/{stravaId}/{accessToken}")
    @Produces({MediaType.APPLICATION_JSON})
    public String createAthlete(@PathParam("credentialsId") String credentialsId, @PathParam("stravaId") String stravaId, @PathParam("accessToken") String accessToken)
    {
        try
        {

            JSONObject athleteJsonObject = new JSONObject(WebhookFactory.getInstance(stravaId, accessToken).createRequest(RequestType.ATHLETE_REQUEST));
            athleteFacadeRemote.createCredendentedAthlete(new Credentials_dto(parseLong(credentialsId)), new Athlete_dto(parseLong("1"),athleteJsonObject.getLong("id"),athleteJsonObject.getString("firstname"),athleteJsonObject.getString("lastname")));
            return Json.createObjectBuilder().add("message", "success").build().toString();
        }
        catch(Exception e)
        {
            return Json.createObjectBuilder().add("message", "unsuccessful").build().toString();
        }
    }

    

//    @POST
//    @Override
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void create(Athlete entity) {
//        super.create(entity);
//    }
//
//    @PUT
//    @Path("{id}")
//    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public void edit(@PathParam("id") Long id, Athlete entity) {
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
//    public Athlete find(@PathParam("id") Long id) {
//        return super.find(id);
//    }
//
    @GET
    @Path("getAll")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public String findAll() {
        
        return "test1";
    }
//
//    @GET
//    @Path("{from}/{to}")
//    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
//    public List<Athlete> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
