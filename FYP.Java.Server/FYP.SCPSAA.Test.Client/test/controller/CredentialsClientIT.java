/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.Credentials_dto;
import static java.lang.Long.parseLong;
import java.util.List;
import javax.naming.InitialContext;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import remote.Credentials_FacadeRemote;

/**
 *
 * @author 2008s
 */
public class CredentialsClientIT 
{
    
    private Credentials_FacadeRemote requestCredentials;
    
    public CredentialsClientIT() 
    {
        requestCredentials = (Credentials_FacadeRemote)getEJBBean("credentialsfacade");
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


    public Object getEJBBean(String beanName)
    {
        try
        {
            InitialContext ctx=new InitialContext();
            return ctx.lookup(beanName);
        }
        catch (Exception ex)
        {
            System.err.println("ERROR: while locating bean from the server " + ex.getMessage());
            return null;
        }
    }
    
    
    /**
     * Test of getEJBBean method, of class CredentialsClient.
     */
    @Test(expected = Test.None.class /* no exception expected */)
    public void createCredentials() throws Exception
    {
        requestCredentials.createCredentials(new Credentials_dto(parseLong("1"),"Username","Password"));
    } 

    /**
     * Test of displayInfo method, of class CredentialsClient.
     */
     @Test(expected = Test.None.class /* no exception expected */)
    public void testDisplayInfo() throws Exception 
    {
        List<Credentials_dto> credList = requestCredentials.findAll();

        for(Credentials_dto c:credList)
        {
            System.out.println(c.getCredentialsId() + " " + c.getUsername());
        }
    }
    
}
