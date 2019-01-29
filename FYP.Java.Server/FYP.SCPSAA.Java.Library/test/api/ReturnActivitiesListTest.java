/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.net.URL;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 2008s
 */
public class ReturnActivitiesListTest {
    
    public ReturnActivitiesListTest() {
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
     * Test of getActivities method, of class ReturnActivitiesList.
     */
    @Test
    public void testGetActivities() throws Exception {
        System.out.println("getActivities");
        ReturnActivitiesList instance = new ReturnActivitiesList();
        assertNotNull(instance);

    }

    /**
     * Test of getRequest method, of class ReturnActivitiesList.
     */
    @Test
    public void testGetRequest() throws Exception {
        System.out.println("getRequest");
        ReturnActivitiesList instance = new ReturnActivitiesList();
        instance.getRequest();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
