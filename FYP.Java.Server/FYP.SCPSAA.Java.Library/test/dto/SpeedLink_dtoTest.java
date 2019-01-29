/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

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
public class SpeedLink_dtoTest {
    
    public SpeedLink_dtoTest() {
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
     * Test of getSpeedLinkId method, of class SpeedLink_dto.
     */
    @Test
    public void testGetSpeedLinkId() {
        System.out.println("getSpeedLinkId");
        SpeedLink_dto instance = null;
        Long expResult = null;
        Long result = instance.getSpeedLinkId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSpeedLinkId method, of class SpeedLink_dto.
     */
    @Test
    public void testSetSpeedLinkId() {
        System.out.println("setSpeedLinkId");
        Long speedLinkId = null;
        SpeedLink_dto instance = null;
        instance.setSpeedLinkId(speedLinkId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getActivityId method, of class SpeedLink_dto.
     */
    @Test
    public void testGetActivityId() {
        System.out.println("getActivityId");
        SpeedLink_dto instance = null;
        Activity_dto expResult = null;
        Activity_dto result = instance.getActivityId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setActivityId method, of class SpeedLink_dto.
     */
    @Test
    public void testSetActivityId() {
        System.out.println("setActivityId");
        Activity_dto activityId = null;
        SpeedLink_dto instance = null;
        instance.setActivityId(activityId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpeedId method, of class SpeedLink_dto.
     */
    @Test
    public void testGetSpeedId() {
        System.out.println("getSpeedId");
        SpeedLink_dto instance = null;
        Speed_dto expResult = null;
        Speed_dto result = instance.getSpeedId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSpeedId method, of class SpeedLink_dto.
     */
    @Test
    public void testSetSpeedId() {
        System.out.println("setSpeedId");
        Speed_dto speedId = null;
        SpeedLink_dto instance = null;
        instance.setSpeedId(speedId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
