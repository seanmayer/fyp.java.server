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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import remote.CadenceLink_FacadeRemote;
import remote.Cadence_FacadeRemote;

/**
 *
 * @author 2008s
 */
public class CadenceClientIT extends EJBBean{
    
    private Cadence_FacadeRemote requestCadence;  
    private CadenceLink_FacadeRemote requestCadenceLink;      
    
    

    
    public CadenceClientIT() 
    {
        requestCadence = (Cadence_FacadeRemote)getEJBBean("cadencefacade");
        requestCadenceLink = (CadenceLink_FacadeRemote)getEJBBean("cadencelinkfacade");
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
    public void createCadence()
    {
        requestCadence.createCadence(new Cadence_dto(parseLong("1"),new BigDecimal("2500"),new BigInteger("1")));
    }
    
    @Test(expected = Test.None.class)
    public void createCadenceLink()
    {
        requestCadenceLink.createCadenceLink(new CadenceLink_dto(parseLong("1"),
                                         new Activity_dto(parseLong("156272543")),
                                         new Cadence_dto(parseLong("1"))));
    }  
    
}
