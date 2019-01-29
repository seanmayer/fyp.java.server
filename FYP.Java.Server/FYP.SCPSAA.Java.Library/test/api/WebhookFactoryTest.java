/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import static api.RequestType.ATHLETE_REQUEST;
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
public class WebhookFactoryTest {
    
    public WebhookFactoryTest() {
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
     * Test of createRequest method, of class WebhookFactory.
     */
    @Test
    public void testCreateRequest() throws Exception {
        System.out.println("createRequest");
        RequestType type = null;
        WebhookFactory.createRequest(ATHLETE_REQUEST);

    }
    
}
