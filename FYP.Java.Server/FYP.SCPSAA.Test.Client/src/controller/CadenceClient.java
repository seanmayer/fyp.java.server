/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.Activity_dto;
import dto.CadenceLink_dto;
import dto.Cadence_dto;
import static java.lang.Long.parseLong;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.naming.InitialContext;
import remote.CadenceLink_FacadeRemote;
import remote.Cadence_FacadeRemote;

/**
 *
 * @author 2008s
 */
public class CadenceClient 
{
        
    private Cadence_FacadeRemote requestCadence;
    private CadenceLink_FacadeRemote requestCadenceLink;
    
    public CadenceClient() throws Exception
    {
        requestCadence = (Cadence_FacadeRemote)getEJBBean("cadencefacade");
        requestCadenceLink = (CadenceLink_FacadeRemote)getEJBBean("cadencelinkfacade");
        //createCadence();
        createCadenceLink();
    }
    
    private static Cadence_FacadeRemote cadenceFacadeRemote;  
    
        public static void main(String[] args) throws Exception {
        CadenceClient c = new CadenceClient();
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
    
    public void createCadence()
    {
        requestCadence.createCadence(new Cadence_dto(parseLong("1"),new BigDecimal("2500"),new BigInteger("1")));
    }
    
    public void createCadenceLink()
    {
        requestCadence.createCadence(new Cadence_dto(parseLong("1"),new BigDecimal("2500"),new BigInteger("1")));
        requestCadenceLink.createCadenceLink(new CadenceLink_dto(parseLong("1"),
                                         new Activity_dto(parseLong("156272543")),
                                         new Cadence_dto(parseLong("1"))));
    }
}
