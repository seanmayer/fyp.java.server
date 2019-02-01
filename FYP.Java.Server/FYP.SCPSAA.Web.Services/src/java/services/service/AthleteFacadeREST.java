/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.service;

import controller.Athlete_FacadeRemote;
import controller.Credentials_FacadeRemote;
import dto.Athlete_dto;
import dto.Credentials_dto;
import static java.lang.Long.parseLong;
import java.util.List;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author 2008s
 */
@Stateless
@Path("services.athlete")
public class AthleteFacadeREST 
{
//    private Athlete_FacadeRemote requestAthlete; //theses lines of code break the service, suggest looking at EEA web module!
//    private Credentials_FacadeRemote requestCredentials;

    public AthleteFacadeREST() 
    {
//        requestAthlete = (Athlete_FacadeRemote)getEJBBean("athletefacade"); 
//        requestCredentials = (Credentials_FacadeRemote)getEJBBean("credentialsfacade");
    }
    
    public Object getEJBBean(String beanName)
    {
        try
        {
            InitialContext ctx=new InitialContext();
            return ctx.lookup(beanName);
        }
        catch (Exception ex)
        {
            System.err.println("ERROR: while locating bean from the server " + ex.getMessage());
            return null;
        }
    }
    
//    @GET
//    @Path("createAthlete")
//    @Produces({MediaType.APPLICATION_JSON})
//    public String createAthlete() {
//        
//        try
//        {
//            Credentials_dto credentials = new Credentials_dto(parseLong("1"));
//            requestAthlete.createCredendentedAthlete(credentials , new Athlete_dto(parseLong("1"),parseLong("1234567"),"Webservice","Webservice"));
//            
//            return "Successful";
//        }
//        catch(Exception e)
//        {
//            return "unsuccessful";
//        }
//                
//        
//    }    
//    

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
