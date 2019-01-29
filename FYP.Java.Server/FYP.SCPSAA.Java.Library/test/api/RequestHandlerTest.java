/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.net.URL;
import org.json.JSONArray;
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
public class RequestHandlerTest {
    
    public RequestHandlerTest() {
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
     * Test of getJsonArray method, of class RequestHandler.
     */
    @Test
    public void testGetJsonArray() throws Exception {
        System.out.println("getJsonArray");
        URL url = new URL("https://www.strava.com/api/v3/athlete/activities?access_token=e8a14408cd001cb6a86607a21ff50bd42f0b76f8");
        RequestHandler instance = new RequestHandlerImpl();
        JSONArray result = instance.getJsonArray(url);
        assertNotNull(result);
    }

    /**
     * Test of getRequest method, of class RequestHandler.
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testGetRequest() throws Exception {
        System.out.println("getRequest");
        RequestHandler instance = new RequestHandlerImpl();
        instance.getRequest();
    }

    public class RequestHandlerImpl extends RequestHandler {
    }
    
}
