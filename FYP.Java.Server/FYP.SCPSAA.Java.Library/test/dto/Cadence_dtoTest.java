/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
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
public class Cadence_dtoTest {
    
    public Cadence_dtoTest() {
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
     * Test of getCadenceId method, of class Cadence_dto.
     */
    @Test
    public void testGetCadenceId() {
        System.out.println("getCadenceId");
        Cadence_dto instance = null;
        Long expResult = null;
        Long result = instance.getCadenceId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCadenceId method, of class Cadence_dto.
     */
    @Test
    public void testSetCadenceId() {
        System.out.println("setCadenceId");
        Long cadenceId = null;
        Cadence_dto instance = null;
        instance.setCadenceId(cadenceId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDatapoint method, of class Cadence_dto.
     */
    @Test
    public void testGetDatapoint() {
        System.out.println("getDatapoint");
        Cadence_dto instance = null;
        BigDecimal expResult = null;
        BigDecimal result = instance.getDatapoint();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDatapoint method, of class Cadence_dto.
     */
    @Test
    public void testSetDatapoint() {
        System.out.println("setDatapoint");
        BigDecimal datapoint = null;
        Cadence_dto instance = null;
        instance.setDatapoint(datapoint);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSecondstamp method, of class Cadence_dto.
     */
    @Test
    public void testGetSecondstamp() {
        System.out.println("getSecondstamp");
        Cadence_dto instance = null;
        BigInteger expResult = null;
        BigInteger result = instance.getSecondstamp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSecondstamp method, of class Cadence_dto.
     */
    @Test
    public void testSetSecondstamp() {
        System.out.println("setSecondstamp");
        BigInteger secondstamp = null;
        Cadence_dto instance = null;
        instance.setSecondstamp(secondstamp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCadenceLinkCollection method, of class Cadence_dto.
     */
    @Test
    public void testGetCadenceLinkCollection() {
        System.out.println("getCadenceLinkCollection");
        Cadence_dto instance = null;
        Collection<CadenceLink_dto> expResult = null;
        Collection<CadenceLink_dto> result = instance.getCadenceLinkCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCadenceLinkCollection method, of class Cadence_dto.
     */
    @Test
    public void testSetCadenceLinkCollection() {
        System.out.println("setCadenceLinkCollection");
        Collection<CadenceLink_dto> cadenceLinkCollection = null;
        Cadence_dto instance = null;
        instance.setCadenceLinkCollection(cadenceLinkCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
