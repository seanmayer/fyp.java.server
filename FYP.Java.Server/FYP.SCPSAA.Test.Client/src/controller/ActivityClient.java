/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dto.Activity_dto;
import remote.Credentials_FacadeRemote;
import remote.Athlete_FacadeRemote;
import dto.Athlete_dto;
import dto.Credentials_dto;
import static java.lang.Long.parseLong;
import java.util.List;
import javax.naming.InitialContext;
import remote.Activity_FacadeRemote;


/**
 *test class
 * @author 2008s
 */
public class ActivityClient {


  private Activity_FacadeRemote requestActivity;  

    
    public ActivityClient() throws Exception
    {
        requestActivity = (Activity_FacadeRemote)getEJBBean("activityfacade");

        requestActivities();
        createActivities();
        findAllActivities();
    }
  
  
  
    public static void main(String[] args) throws Exception {
        ActivityClient sac = new ActivityClient();
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


    private void requestActivities()
    {

    }

    private void createActivities()
    {

    }
    
    public void findAllActivities()
    {

        List<Activity_dto> acctlist = requestActivity.findAll();
    
        for(Activity_dto ad:acctlist)
        {
            System.out.println(ad.getAthleteId().getAthleteId());
        }
        
    }

    
    
}
