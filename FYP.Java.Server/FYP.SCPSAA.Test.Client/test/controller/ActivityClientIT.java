/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.Activity_dto;
import static java.lang.Long.parseLong;
import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import remote.Activity_FacadeRemote;

/**
 *
 * @author 2008s
 */
public class ActivityClientIT extends EJBBean{
    
    private Activity_FacadeRemote requestActivity;  
    
    public ActivityClientIT() 
    {
        requestActivity = (Activity_FacadeRemote)getEJBBean("activityfacade");
        
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
    
    @Test(expected = Test.None.class)
    public void createActivity()
    {
        requestActivity.createActivity(new Activity_dto(parseLong("REQUIRED"),parseLong("REQUIRED"),"JUNIT",new Date(),"JUNIT"));
    }
    

    @Test(expected = Test.None.class)
    public void findAllActivities()
    {
        List<Activity_dto> acctlist = requestActivity.findAll();
    
        for(Activity_dto ad:acctlist)
        {
            System.out.println(ad.getAthleteId().getAthleteId());
        }
        
    }
    
}
