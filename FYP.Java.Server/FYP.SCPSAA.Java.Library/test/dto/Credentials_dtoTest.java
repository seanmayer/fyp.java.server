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
public class Credentials_dtoTest {
    
    public Credentials_dtoTest() {
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
     * Test of getCredentialsId method, of class Credentials_dto.
     */
    @Test
    public void testGetCredentialsId() {
        System.out.println("getCredentialsId");
        Credentials_dto instance = new Credentials_dto();
        Long expResult = null;
        Long result = instance.getCredentialsId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCredentialsId method, of class Credentials_dto.
     */
    @Test
    public void testSetCredentialsId() {
        System.out.println("setCredentialsId");
        Long credentialsId = null;
        Credentials_dto instance = new Credentials_dto();
        instance.setCredentialsId(credentialsId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class Credentials_dto.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Credentials_dto instance = new Credentials_dto();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class Credentials_dto.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        Credentials_dto instance = new Credentials_dto();
        instance.setUsername(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class Credentials_dto.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Credentials_dto instance = new Credentials_dto();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class Credentials_dto.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Credentials_dto instance = new Credentials_dto();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAthleteId method, of class Credentials_dto.
     */
    @Test
    public void testGetAthleteId() {
        System.out.println("getAthleteId");
        Credentials_dto instance = new Credentials_dto();
        Athlete_dto expResult = null;
        Athlete_dto result = instance.getAthleteId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAthleteId method, of class Credentials_dto.
     */
    @Test
    public void testSetAthleteId() {
        System.out.println("setAthleteId");
        Athlete_dto athleteId = null;
        Credentials_dto instance = new Credentials_dto();
        instance.setAthleteId(athleteId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
