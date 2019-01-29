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
public class Power_dtoTest {
    
    public Power_dtoTest() {
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
     * Test of getPowerId method, of class Power_dto.
     */
    @Test
    public void testGetPowerId() {
        System.out.println("getPowerId");
        Power_dto instance = null;
        Long expResult = null;
        Long result = instance.getPowerId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPowerId method, of class Power_dto.
     */
    @Test
    public void testSetPowerId() {
        System.out.println("setPowerId");
        Long powerId = null;
        Power_dto instance = null;
        instance.setPowerId(powerId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDatapoint method, of class Power_dto.
     */
    @Test
    public void testGetDatapoint() {
        System.out.println("getDatapoint");
        Power_dto instance = null;
        BigDecimal expResult = null;
        BigDecimal result = instance.getDatapoint();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDatapoint method, of class Power_dto.
     */
    @Test
    public void testSetDatapoint() {
        System.out.println("setDatapoint");
        BigDecimal datapoint = null;
        Power_dto instance = null;
        instance.setDatapoint(datapoint);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSecondstamp method, of class Power_dto.
     */
    @Test
    public void testGetSecondstamp() {
        System.out.println("getSecondstamp");
        Power_dto instance = null;
        BigInteger expResult = null;
        BigInteger result = instance.getSecondstamp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSecondstamp method, of class Power_dto.
     */
    @Test
    public void testSetSecondstamp() {
        System.out.println("setSecondstamp");
        BigInteger secondstamp = null;
        Power_dto instance = null;
        instance.setSecondstamp(secondstamp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPowerLinkCollection method, of class Power_dto.
     */
    @Test
    public void testGetPowerLinkCollection() {
        System.out.println("getPowerLinkCollection");
        Power_dto instance = null;
        Collection<PowerLink_dto> expResult = null;
        Collection<PowerLink_dto> result = instance.getPowerLinkCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPowerLinkCollection method, of class Power_dto.
     */
    @Test
    public void testSetPowerLinkCollection() {
        System.out.println("setPowerLinkCollection");
        Collection<PowerLink_dto> powerLinkCollection = null;
        Power_dto instance = null;
        instance.setPowerLinkCollection(powerLinkCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
