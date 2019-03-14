/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

public class WebHookFactory
{
    WebhookFactory whf = WebhookFactory.getInstance("581409","3aa96600c17636ee70c0fe95af4a28eeae20de32"); 
    WebhookFactory whfA = WebhookFactory.getInstance("35193560","e8a14408cd001cb6a86607a21ff50bd42f0b76f8","1866935441"); 

//1866935441 //35193560 //e8a14408cd001cb6a86607a21ff50bd42f0b76f8
    public WebHookFactory() throws Exception 
    {
        //getAthleteData();
        //getActivityList();
        getActivityPowerStream();
    }
    
    public static void main(String[] args) throws Exception {
        WebHookFactory whft = new WebHookFactory();
    }
    
    public void getAthleteData() throws Exception
    {     
        whf.createRequest(RequestType.ATHLETE_REQUEST);
    }
    
    public void getActivityList() throws Exception
    {  
        System.out.println(whf.createRequest(RequestType.ACTIVITIES_LIST_REQUEST));
    }    
    
    public void getActivityPowerStream() throws Exception
    {
        System.out.println(whfA.createRequest(RequestType.POWER_STREAM));
    }
    
}
