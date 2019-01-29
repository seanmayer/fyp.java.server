/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Collection;
import java.util.Date;
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
public class Activity_dtoTest {
    
    public Activity_dtoTest() {
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
     * Test of getActivityId method, of class Activity_dto.
     */
    @Test
    public void testGetActivityId() {
        System.out.println("getActivityId");
        Activity_dto instance = null;
        Long expResult = null;
        Long result = instance.getActivityId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setActivityId method, of class Activity_dto.
     */
    @Test
    public void testSetActivityId() {
        System.out.println("setActivityId");
        Long activityId = null;
        Activity_dto instance = null;
        instance.setActivityId(activityId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStravaid method, of class Activity_dto.
     */
    @Test
    public void testGetStravaid() {
        System.out.println("getStravaid");
        Activity_dto instance = null;
        long expResult = 0L;
        long result = instance.getStravaid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStravaid method, of class Activity_dto.
     */
    @Test
    public void testSetStravaid() {
        System.out.println("setStravaid");
        long stravaid = 0L;
        Activity_dto instance = null;
        instance.setStravaid(stravaid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Activity_dto.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Activity_dto instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Activity_dto.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Activity_dto instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStartDate method, of class Activity_dto.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        Activity_dto instance = null;
        Date expResult = null;
        Date result = instance.getStartDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStartDate method, of class Activity_dto.
     */
    @Test
    public void testSetStartDate() {
        System.out.println("setStartDate");
        Date startDate = null;
        Activity_dto instance = null;
        instance.setStartDate(startDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimeZone method, of class Activity_dto.
     */
    @Test
    public void testGetTimeZone() {
        System.out.println("getTimeZone");
        Activity_dto instance = null;
        String expResult = "";
        String result = instance.getTimeZone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTimeZone method, of class Activity_dto.
     */
    @Test
    public void testSetTimeZone() {
        System.out.println("setTimeZone");
        String timeZone = "";
        Activity_dto instance = null;
        instance.setTimeZone(timeZone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCadenceLinkCollection method, of class Activity_dto.
     */
    @Test
    public void testGetCadenceLinkCollection() {
        System.out.println("getCadenceLinkCollection");
        Activity_dto instance = null;
        Collection<CadenceLink_dto> expResult = null;
        Collection<CadenceLink_dto> result = instance.getCadenceLinkCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCadenceLinkCollection method, of class Activity_dto.
     */
    @Test
    public void testSetCadenceLinkCollection() {
        System.out.println("setCadenceLinkCollection");
        Collection<CadenceLink_dto> cadenceLinkCollection = null;
        Activity_dto instance = null;
        instance.setCadenceLinkCollection(cadenceLinkCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPowerLinkCollection method, of class Activity_dto.
     */
    @Test
    public void testGetPowerLinkCollection() {
        System.out.println("getPowerLinkCollection");
        Activity_dto instance = null;
        Collection<PowerLink_dto> expResult = null;
        Collection<PowerLink_dto> result = instance.getPowerLinkCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPowerLinkCollection method, of class Activity_dto.
     */
    @Test
    public void testSetPowerLinkCollection() {
        System.out.println("setPowerLinkCollection");
        Collection<PowerLink_dto> powerLinkCollection = null;
        Activity_dto instance = null;
        instance.setPowerLinkCollection(powerLinkCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpeedLinkCollection method, of class Activity_dto.
     */
    @Test
    public void testGetSpeedLinkCollection() {
        System.out.println("getSpeedLinkCollection");
        Activity_dto instance = null;
        Collection<SpeedLink_dto> expResult = null;
        Collection<SpeedLink_dto> result = instance.getSpeedLinkCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSpeedLinkCollection method, of class Activity_dto.
     */
    @Test
    public void testSetSpeedLinkCollection() {
        System.out.println("setSpeedLinkCollection");
        Collection<SpeedLink_dto> speedLinkCollection = null;
        Activity_dto instance = null;
        instance.setSpeedLinkCollection(speedLinkCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAthleteId method, of class Activity_dto.
     */
    @Test
    public void testGetAthleteId() {
        System.out.println("getAthleteId");
        Activity_dto instance = null;
        Athlete_dto expResult = null;
        Athlete_dto result = instance.getAthleteId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAthleteId method, of class Activity_dto.
     */
    @Test
    public void testSetAthleteId() {
        System.out.println("setAthleteId");
        Athlete_dto athleteId = null;
        Activity_dto instance = null;
        instance.setAthleteId(athleteId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getActivitySummary method, of class Activity_dto.
     */
    @Test
    public void testGetActivitySummary() {
        System.out.println("getActivitySummary");
        Activity_dto instance = null;
        ActivitySummary_dto expResult = null;
        ActivitySummary_dto result = instance.getActivitySummary();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setActivitySummary method, of class Activity_dto.
     */
    @Test
    public void testSetActivitySummary() {
        System.out.println("setActivitySummary");
        ActivitySummary_dto activitySummary = null;
        Activity_dto instance = null;
        instance.setActivitySummary(activitySummary);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
