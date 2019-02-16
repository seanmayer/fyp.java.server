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
import remote.Credentials_FacadeRemote;

/**
 *
 * @author 2008s
 */
public class CredentialsClient 
{
    
  private Credentials_FacadeRemote requestCredentials;
    
    public CredentialsClient() throws Exception
    {

        requestCredentials = (Credentials_FacadeRemote)getEJBBean("credentialsfacade");
        //createCredentials();
        findAll();
    }
  
  
  
    public static void main(String[] args) throws Exception {
        CredentialsClient c = new CredentialsClient();
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

    private void createCredentials() throws Exception
    {
        requestCredentials.createCredentials(new Credentials_dto(parseLong("1"),"Username","Password"));
    }    
    
    public void findAll() throws Exception
    {

            List<Credentials_dto> credList = requestCredentials.findAll();

            for(Credentials_dto c:credList)
            {
                System.out.println(c.getCredentialsId() + " " + c.getUsername());
            }
    }
    
}
