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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import remote.PowerLink_FacadeRemote;
import remote.Power_FacadeRemote;

/**
 *
 * @author 2008s
 */
public class PowerClientIT extends EJBBean{
    
    private Power_FacadeRemote requestPower;  
    private PowerLink_FacadeRemote requestPowerLink;  
    
    public PowerClientIT() 
    {
        requestPower = (Power_FacadeRemote)getEJBBean("powerfacade");
        requestPowerLink = (PowerLink_FacadeRemote)getEJBBean("powerlinkfacade");
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test(expected = Test.None.class)
    public void createPower()
    {
        requestPower.createPower(new Power_dto(parseLong("1"),new BigDecimal("2500"),new BigInteger("1")));
    }
    
    @Test(expected = Test.None.class)
    public void createPowerLink()
    {
        requestPowerLink.createPowerLink(new PowerLink_dto(parseLong("1"),
                                         new Activity_dto(parseLong("156272543")),
                                         new Power_dto(parseLong("1"))));
    }

    
}
