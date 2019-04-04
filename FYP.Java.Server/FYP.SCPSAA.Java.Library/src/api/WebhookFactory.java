/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import javax.ejb.Remote;

/**
* @author  Sean Mayer
* @version 1.0
* @since   2019-02-05
*/

@Remote
public class WebhookFactory 
{
   private static volatile WebhookFactory instance;
   private String stravaId;
   private String accessToken;  
   private String activityId;

    /**
     * This implements the Factory Method and Singleton Pattern.
     * Its purpose is to make web requests to the Strava API and return JSONString.
     */
    public WebhookFactory() {}

    /**
     * This method instantiates the Singleton with the accessToken and stravaID that is required to make web requests.
     * @param stravaId
     * @param accessToken
     */
    public WebhookFactory(String stravaId, String accessToken) 
    {
        this.accessToken = accessToken;
        this.stravaId = stravaId;
    }
    
    public WebhookFactory(String stravaId, String accessToken, String activityId) 
    {
        this.accessToken = accessToken;
        this.stravaId = stravaId;
        this.activityId = activityId;
    }

    /**
     * This gets the Singleton instance.
     * @param stravaId
     * @param accessToken
     * @return WebhookFactory
     */
    public static WebhookFactory getInstance(String stravaId, String accessToken)
    {   
        instance = new WebhookFactory(stravaId,accessToken);
        return instance;
    }
    
    public static WebhookFactory getInstance(String stravaId, String accessToken, String activityId)
    {   
        instance = new WebhookFactory(stravaId,accessToken, activityId);
        return instance;
    }

    /**
     * This is the webhook request factory, this calls the concrete classes for each use case.
     * @param type
     * @return
     * @throws Exception
     */
    public String createRequest(RequestType type) throws Exception 
   {
      switch (type) 
      {
            case ATHLETE_REQUEST: return genericRequest(new ReturnAthlete()).getRequest();

            case ACTIVITIES_LIST_REQUEST: return genericRequest(new ReturnActivitiesList()).getRequest();
            
            case POWER_STREAM: return genericRequest(new ReturnPower()).getRequest();
            
            case SPEED_STREAM: return genericRequest(new ReturnSpeed()).getRequest();
            
            case CADENCE_STREAM: return genericRequest(new ReturnCadence()).getRequest();
            
            case ACTIVITY_SUMMARY: return genericRequest(new ReturnActivitySummary()).getRequest();
            
            default: return null;
      }
    }
   
    /**
     * This is a Generic Method, that takes in abstract RequestHandler children classes. This instantiates the request handler's STRAVA_ACCESS_TOKEN and STRAVA_USER_ID.
     * @param <T>
     * @param requestHandler
     * @return
     */
    public <T extends RequestHandler> RequestHandler genericRequest(T requestHandler) 
    {
        requestHandler.STRAVA_ACCESS_TOKEN = accessToken;
        requestHandler.STRAVA_USER_ID = stravaId;
        requestHandler.ACTIVITY_ID = activityId;
        return requestHandler;
    }

}
