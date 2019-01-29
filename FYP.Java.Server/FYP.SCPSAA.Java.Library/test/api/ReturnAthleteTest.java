/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.net.URL;
import static org.hamcrest.CoreMatchers.instanceOf;
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
public class ReturnAthleteTest {
    
    public ReturnAthleteTest() {
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
     * Test of getAthlete method, of class ReturnAthlete.
     */
    @Test
    public void testGetAthlete() throws Exception {
        System.out.println("getAthlete");
        ReturnAthlete instance = new ReturnAthlete();
        URL result = instance.getAthlete();
        assertThat(result, instanceOf(URL.class));
    }

    /**
     * Test of getRequest method, of class ReturnAthlete.
     */
    @Test
    public void testGetRequest() throws Exception {
        System.out.println("getRequest");
        ReturnAthlete instance = new ReturnAthlete();
        instance.getRequest();
        assertNotNull(instance);
    }
    
}
