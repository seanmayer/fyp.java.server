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
public class Athlete_dtoTest {
    
    public Athlete_dtoTest() {
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
     * Test of getAthleteId method, of class Athlete_dto.
     */
    @Test
    public void testGetAthleteId() {
        System.out.println("getAthleteId");
        Athlete_dto instance = null;
        Long expResult = null;
        Long result = instance.getAthleteId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAthleteId method, of class Athlete_dto.
     */
    @Test
    public void testSetAthleteId() {
        System.out.println("setAthleteId");
        Long athleteId = null;
        Athlete_dto instance = null;
        instance.setAthleteId(athleteId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStravaid method, of class Athlete_dto.
     */
    @Test
    public void testGetStravaid() {
        System.out.println("getStravaid");
        Athlete_dto instance = null;
        long expResult = 0L;
        long result = instance.getStravaid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStravaid method, of class Athlete_dto.
     */
    @Test
    public void testSetStravaid() {
        System.out.println("setStravaid");
        long stravaid = 0L;
        Athlete_dto instance = null;
        instance.setStravaid(stravaid);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstname method, of class Athlete_dto.
     */
    @Test
    public void testGetFirstname() {
        System.out.println("getFirstname");
        Athlete_dto instance = null;
        String expResult = "";
        String result = instance.getFirstname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstname method, of class Athlete_dto.
     */
    @Test
    public void testSetFirstname() {
        System.out.println("setFirstname");
        String firstname = "";
        Athlete_dto instance = null;
        instance.setFirstname(firstname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastname method, of class Athlete_dto.
     */
    @Test
    public void testGetLastname() {
        System.out.println("getLastname");
        Athlete_dto instance = null;
        String expResult = "";
        String result = instance.getLastname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastname method, of class Athlete_dto.
     */
    @Test
    public void testSetLastname() {
        System.out.println("setLastname");
        String lastname = "";
        Athlete_dto instance = null;
        instance.setLastname(lastname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCredentialsId method, of class Athlete_dto.
     */
    @Test
    public void testGetCredentialsId() {
        System.out.println("getCredentialsId");
        Athlete_dto instance = null;
        Credentials_dto expResult = null;
        Credentials_dto result = instance.getCredentialsId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCredentialsId method, of class Athlete_dto.
     */
    @Test
    public void testSetCredentialsId() {
        System.out.println("setCredentialsId");
        Credentials_dto credentialsId = null;
        Athlete_dto instance = null;
        instance.setCredentialsId(credentialsId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
