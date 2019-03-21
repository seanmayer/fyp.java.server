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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import remote.SpeedLink_FacadeRemote;
import remote.Speed_FacadeRemote;

/**
 *
 * @author 2008s
 */
public class SpeedClientIT extends EJBBean{
    
    private Speed_FacadeRemote requestSpeed;  
    private SpeedLink_FacadeRemote requestSpeedLink;  
    
    public SpeedClientIT() 
    {
        requestSpeed = (Speed_FacadeRemote)getEJBBean("speedfacade");
        requestSpeedLink = (SpeedLink_FacadeRemote)getEJBBean("speedlinkfacade");
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
    public void createSpeed()
    {
        requestSpeed.createSpeed(new Speed_dto(parseLong("1"),new BigDecimal("2500"),new BigInteger("1")));
    }
    
    @Test(expected = Test.None.class)
    public void createSpeedLink()
    {
        requestSpeedLink.createSpeedLink(new SpeedLink_dto(parseLong("1"),
                                         new Activity_dto(parseLong("156272543")),
                                         new Speed_dto(parseLong("1"))));
    }
    
}
