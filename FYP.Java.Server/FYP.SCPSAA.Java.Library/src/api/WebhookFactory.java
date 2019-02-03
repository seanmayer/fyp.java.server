/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import static java.lang.Math.E;
import static java.lang.StrictMath.E;
import static javafx.scene.input.KeyCode.T;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author 2008s
 */
public class WebhookFactory 
{
   private static WebhookFactory instance = null;
   private String stravaId;
   private String accessToken;
   
    private WebhookFactory() 
    {

    }
   
    private WebhookFactory(String stravaId, String accessToken) 
    {
        this.accessToken = accessToken;
        this.stravaId = stravaId;
    }

    public static WebhookFactory getInstance(String stravaId, String accessToken) {

        if (instance == null)
        {
            instance =  new WebhookFactory(stravaId,accessToken);
        }
        return instance;
    }
    
   public void createRequest(RequestType type) throws Exception 
   {
      switch (type) 
      {
            case ATHLETE_REQUEST: genericRequest(new ReturnAthlete()).getRequest();

            case ACTIVITIES_LIST_REQUEST: genericRequest(new ReturnActivitiesList()).getRequest();
            
            default: break;
      }
    }
   
   
    public <T extends RequestHandler> RequestHandler genericRequest(T requestHandler) 
    {
        requestHandler.STRAVA_ACCESS_TOKEN = accessToken;
        requestHandler.STRAVA_USER_ID = stravaId;
        return requestHandler;
    }

}
