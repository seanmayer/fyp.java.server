/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author 2008s
 */
public class WebHookFactoryIT {
    
    public WebHookFactoryIT() {
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
     * Test of main method, of class WebHookFactory.
     */
    @Test(expected = Test.None.class /* no exception expected */)
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        WebHookFactory.main(args);
    }

    /**
     * Test of getAthleteData method, of class WebHookFactory.
     */
    @Test(expected = Test.None.class /* no exception expected */)
    public void testGetAthleteData() throws Exception {
        System.out.println("getAthleteData");
        WebHookFactory instance = new WebHookFactory();
        instance.whf.createRequest(RequestType.ATHLETE_REQUEST);
    }

    /**
     * Test of getActivitesData method, of class WebHookFactory.
     */
    @Test(expected = Test.None.class /* no exception expected */)
    public void testGetActivitesData() throws Exception {
        System.out.println("getActivitesData");
        WebHookFactory instance = new WebHookFactory();
        instance.whf.createRequest(RequestType.ACTIVITIES_LIST_REQUEST);
    }
    
}
