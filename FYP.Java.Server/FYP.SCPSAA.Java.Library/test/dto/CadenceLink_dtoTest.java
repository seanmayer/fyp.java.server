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
public class CadenceLink_dtoTest {
    
    public CadenceLink_dtoTest() {
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
     * Test of getCadenceLinkId method, of class CadenceLink_dto.
     */
    @Test
    public void testGetCadenceLinkId() {
        System.out.println("getCadenceLinkId");
        CadenceLink_dto instance = null;
        Long expResult = null;
        Long result = instance.getCadenceLinkId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCadenceLinkId method, of class CadenceLink_dto.
     */
    @Test
    public void testSetCadenceLinkId() {
        System.out.println("setCadenceLinkId");
        Long cadenceLinkId = null;
        CadenceLink_dto instance = null;
        instance.setCadenceLinkId(cadenceLinkId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getActivityId method, of class CadenceLink_dto.
     */
    @Test
    public void testGetActivityId() {
        System.out.println("getActivityId");
        CadenceLink_dto instance = null;
        Activity_dto expResult = null;
        Activity_dto result = instance.getActivityId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setActivityId method, of class CadenceLink_dto.
     */
    @Test
    public void testSetActivityId() {
        System.out.println("setActivityId");
        Activity_dto activityId = null;
        CadenceLink_dto instance = null;
        instance.setActivityId(activityId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCadenceId method, of class CadenceLink_dto.
     */
    @Test
    public void testGetCadenceId() {
        System.out.println("getCadenceId");
        CadenceLink_dto instance = null;
        Cadence_dto expResult = null;
        Cadence_dto result = instance.getCadenceId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCadenceId method, of class CadenceLink_dto.
     */
    @Test
    public void testSetCadenceId() {
        System.out.println("setCadenceId");
        Cadence_dto cadenceId = null;
        CadenceLink_dto instance = null;
        instance.setCadenceId(cadenceId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
