/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.Athlete_dto;
import java.util.List;
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
public class Athlete_FacadeRemoteTest {
    
    public Athlete_FacadeRemoteTest() {
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
     * Test of createAthlete method, of class Athlete_FacadeRemote.
     */
    @Test
    public void testCreateAthlete() {
        System.out.println("createAthlete");
        Athlete_dto details = null;
        Athlete_FacadeRemote instance = new Athlete_FacadeRemoteImpl();
        instance.createAthlete(details);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editAthlete method, of class Athlete_FacadeRemote.
     */
    @Test
    public void testEditAthlete() {
        System.out.println("editAthlete");
        Athlete_dto details = null;
        Athlete_FacadeRemote instance = new Athlete_FacadeRemoteImpl();
        instance.editAthlete(details);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAthlete method, of class Athlete_FacadeRemote.
     */
    @Test
    public void testRemoveAthlete() {
        System.out.println("removeAthlete");
        Long id = null;
        Athlete_FacadeRemote instance = new Athlete_FacadeRemoteImpl();
        instance.removeAthlete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class Athlete_FacadeRemote.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        Object pk = null;
        Athlete_FacadeRemote instance = new Athlete_FacadeRemoteImpl();
        Athlete_dto expResult = null;
        Athlete_dto result = instance.find(pk);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class Athlete_FacadeRemote.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        Long id = null;
        Athlete_FacadeRemote instance = new Athlete_FacadeRemoteImpl();
        Athlete_dto expResult = null;
        Athlete_dto result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class Athlete_FacadeRemote.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        Athlete_FacadeRemote instance = new Athlete_FacadeRemoteImpl();
        List<Athlete_dto> expResult = null;
        List<Athlete_dto> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class Athlete_FacadeRemoteImpl implements Athlete_FacadeRemote {

        public void createAthlete(Athlete_dto details) {
        }

        public void editAthlete(Athlete_dto details) {
        }

        public void removeAthlete(Long id) {
        }

        public Athlete_dto find(Object pk) {
            return null;
        }

        public Athlete_dto findById(Long id) {
            return null;
        }

        public List<Athlete_dto> findAll() {
            return null;
        }
    }
    
}
