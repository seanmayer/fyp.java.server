/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.Athlete_dto;
import dto.Credentials_dto;
import static java.lang.Long.parseLong;
import javax.naming.InitialContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import remote.Athlete_FacadeRemote;
import remote.Credentials_FacadeRemote;

/**
 *
 * @author 2008s
 */
public class AthleteClientIT {
    
    private Athlete_FacadeRemote requestAthlete;  
    private Credentials_FacadeRemote requestCredentials;
    
    
    public AthleteClientIT() throws Exception
    {
        requestAthlete = (Athlete_FacadeRemote)getEJBBean("athletefacade"); 
        requestCredentials = (Credentials_FacadeRemote)getEJBBean("credentialsfacade");
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

    /**
     * Test of main method, of class AthleteClient.
     */
    @Test(expected = Test.None.class /* no exception expected */) 
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        AthleteClient.main(args);
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
    
    @Test(expected = Test.None.class /* no exception expected */)
    public void createCredentials() throws Exception
    {
        requestCredentials.createCredentials(new Credentials_dto(parseLong("1"),"Username","Password"));
    } 
    
    @Test(expected = Test.None.class /* no exception expected */)
    public void createAthlete() throws Exception
    {
        Credentials_dto credentials = new Credentials_dto(parseLong("1"));
        requestAthlete.createCredendentedAthlete(credentials , new Athlete_dto(parseLong("1"),parseLong("1234567"),"FirstNameTest","LastNameTest"));
    }
    
}
