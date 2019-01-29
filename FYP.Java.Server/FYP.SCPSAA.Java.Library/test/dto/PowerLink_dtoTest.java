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
public class PowerLink_dtoTest {
    
    public PowerLink_dtoTest() {
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
     * Test of getPowerLinkId method, of class PowerLink_dto.
     */
    @Test
    public void testGetPowerLinkId() {
        System.out.println("getPowerLinkId");
        PowerLink_dto instance = null;
        Long expResult = null;
        Long result = instance.getPowerLinkId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPowerLinkId method, of class PowerLink_dto.
     */
    @Test
    public void testSetPowerLinkId() {
        System.out.println("setPowerLinkId");
        Long powerLinkId = null;
        PowerLink_dto instance = null;
        instance.setPowerLinkId(powerLinkId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getActivityId method, of class PowerLink_dto.
     */
    @Test
    public void testGetActivityId() {
        System.out.println("getActivityId");
        PowerLink_dto instance = null;
        Activity_dto expResult = null;
        Activity_dto result = instance.getActivityId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setActivityId method, of class PowerLink_dto.
     */
    @Test
    public void testSetActivityId() {
        System.out.println("setActivityId");
        Activity_dto activityId = null;
        PowerLink_dto instance = null;
        instance.setActivityId(activityId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPowerId method, of class PowerLink_dto.
     */
    @Test
    public void testGetPowerId() {
        System.out.println("getPowerId");
        PowerLink_dto instance = null;
        Power_dto expResult = null;
        Power_dto result = instance.getPowerId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPowerId method, of class PowerLink_dto.
     */
    @Test
    public void testSetPowerId() {
        System.out.println("setPowerId");
        Power_dto powerId = null;
        PowerLink_dto instance = null;
        instance.setPowerId(powerId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
