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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author 2008s
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({dto.Power_dtoTest.class, dto.Speed_dtoTest.class, dto.CadenceLink_dtoTest.class, dto.Credentials_dtoTest.class, dto.Activity_dtoTest.class, dto.PowerLink_dtoTest.class, dto.SpeedLink_dtoTest.class, dto.Cadence_dtoTest.class, dto.Athlete_dtoTest.class, dto.ActivitySummary_dtoTest.class})
public class DtoSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
