/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.Activity_dto;
import dto.PowerLink_dto;
import dto.Power_dto;
import static java.lang.Long.parseLong;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.naming.InitialContext;
import remote.Credentials_FacadeRemote;
import remote.PowerLink_FacadeRemote;
import remote.Power_FacadeRemote;

/**
 *
 * @author 2008s
 */
public class PowerClient 
{
    
    private Power_FacadeRemote requestPower;
    private PowerLink_FacadeRemote requestPowerLink;
    
    public PowerClient() throws Exception
    {
        requestPower = (Power_FacadeRemote)getEJBBean("powerfacade");
        requestPowerLink = (PowerLink_FacadeRemote)getEJBBean("powerlinkfacade");
        //createPower();
        createPowerLink();
    }
    
    private static Power_FacadeRemote powerFacadeRemote;  
    
        public static void main(String[] args) throws Exception {
        PowerClient p = new PowerClient();
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
    
    public void createPower()
    {
        requestPower.createPower(new Power_dto(parseLong("1"),new BigDecimal("2500"),new BigInteger("1")));
    }
    
    public void createPowerLink()
    {
        requestPower.createPower(new Power_dto(parseLong("1"),new BigDecimal("2500"),new BigInteger("1")));
        requestPowerLink.createPowerLink(new PowerLink_dto(parseLong("1"),
                                         new Activity_dto(parseLong("156272543")),
                                         new Power_dto(parseLong("1"))));
    }
    
}
