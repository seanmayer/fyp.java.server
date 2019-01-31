/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import static api.RequestType.ATHLETE_REQUEST;

/**
 *
 * @author 2008s
 */
public class WebHookFactoryTest
{

    public WebHookFactoryTest() throws Exception 
    {
        getActivitesData();
    }
    
    public static void main(String[] args) throws Exception {
        WebHookFactoryTest whft = new WebHookFactoryTest();
    }
    
    public void getAthleteData() throws Exception
    {
        WebhookFactory whf = WebhookFactory.getInstance();    
        whf.createRequest(RequestType.ATHLETE_REQUEST); 
    }
    
    public void getActivitesData() throws Exception
    {
        WebhookFactory whf = WebhookFactory.getInstance();    
        whf.createRequest(RequestType.ACTIVITIES_LIST_REQUEST); 
    }    
    
}
