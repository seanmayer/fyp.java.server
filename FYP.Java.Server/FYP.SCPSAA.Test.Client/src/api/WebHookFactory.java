/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

public class WebHookFactory
{
    WebhookFactory whf = WebhookFactory.getInstance("581409","3aa96600c17636ee70c0fe95af4a28eeae20de32"); 
    
    public WebHookFactory() throws Exception 
    {
        //getAthleteData();
        getActivitesData();
    }
    
    public static void main(String[] args) throws Exception {
        WebHookFactory whft = new WebHookFactory();
    }
    
    public void getAthleteData() throws Exception
    {     
        whf.createRequest(RequestType.ATHLETE_REQUEST);
    }
    
    public void getActivitesData() throws Exception
    {  
        whf.createRequest(RequestType.ACTIVITIES_LIST_REQUEST); 
    }    
    
}
