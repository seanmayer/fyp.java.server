/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.Activity_dto;
import dto.SpeedLink_dto;
import dto.Speed_dto;
import static java.lang.Long.parseLong;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.naming.InitialContext;
import remote.SpeedLink_FacadeRemote;
import remote.Speed_FacadeRemote;



/**
 *
 * @author 2008s
 */
public class SpeedClient 
{
        
    private Speed_FacadeRemote requestSpeed;
    private SpeedLink_FacadeRemote requestSpeedLink;
    
    public SpeedClient() throws Exception
    {
        requestSpeed = (Speed_FacadeRemote)getEJBBean("speedfacade");
        requestSpeedLink = (SpeedLink_FacadeRemote)getEJBBean("speedlinkfacade");
        //createSpeed();
        createSpeedLink();
    }
    
    private static Speed_FacadeRemote speedFacadeRemote;  
    
        public static void main(String[] args) throws Exception {
        SpeedClient c = new SpeedClient();
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
    
    public void createSpeed()
    {
        requestSpeed.createSpeed(new Speed_dto(parseLong("1"),new BigDecimal("2500"),new BigInteger("1")));
    }
    
    public void createSpeedLink()
    {
        requestSpeed.createSpeed(new Speed_dto(parseLong("1"),new BigDecimal("2500"),new BigInteger("1")));
        requestSpeedLink.createSpeedLink(new SpeedLink_dto(parseLong("1"),
                                         new Activity_dto(parseLong("156272543")),
                                         new Speed_dto(parseLong("1"))));
    }
}
