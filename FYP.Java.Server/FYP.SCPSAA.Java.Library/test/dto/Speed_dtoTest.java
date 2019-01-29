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
public class Speed_dtoTest {
    
    public Speed_dtoTest() {
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
     * Test of getSpeedId method, of class Speed_dto.
     */
    @Test
    public void testGetSpeedId() {
        System.out.println("getSpeedId");
        Speed_dto instance = null;
        Long expResult = null;
        Long result = instance.getSpeedId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSpeedId method, of class Speed_dto.
     */
    @Test
    public void testSetSpeedId() {
        System.out.println("setSpeedId");
        Long speedId = null;
        Speed_dto instance = null;
        instance.setSpeedId(speedId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDatapoint method, of class Speed_dto.
     */
    @Test
    public void testGetDatapoint() {
        System.out.println("getDatapoint");
        Speed_dto instance = null;
        BigDecimal expResult = null;
        BigDecimal result = instance.getDatapoint();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDatapoint method, of class Speed_dto.
     */
    @Test
    public void testSetDatapoint() {
        System.out.println("setDatapoint");
        BigDecimal datapoint = null;
        Speed_dto instance = null;
        instance.setDatapoint(datapoint);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSecondstamp method, of class Speed_dto.
     */
    @Test
    public void testGetSecondstamp() {
        System.out.println("getSecondstamp");
        Speed_dto instance = null;
        BigInteger expResult = null;
        BigInteger result = instance.getSecondstamp();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSecondstamp method, of class Speed_dto.
     */
    @Test
    public void testSetSecondstamp() {
        System.out.println("setSecondstamp");
        BigInteger secondstamp = null;
        Speed_dto instance = null;
        instance.setSecondstamp(secondstamp);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpeedLinkCollection method, of class Speed_dto.
     */
    @Test
    public void testGetSpeedLinkCollection() {
        System.out.println("getSpeedLinkCollection");
        Speed_dto instance = null;
        Collection<SpeedLink_dto> expResult = null;
        Collection<SpeedLink_dto> result = instance.getSpeedLinkCollection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSpeedLinkCollection method, of class Speed_dto.
     */
    @Test
    public void testSetSpeedLinkCollection() {
        System.out.println("setSpeedLinkCollection");
        Collection<SpeedLink_dto> speedLinkCollection = null;
        Speed_dto instance = null;
        instance.setSpeedLinkCollection(speedLinkCollection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
