/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

/**
 *
 * @author 2008s
 */
public class WebhookFactory 
{
   private static WebhookFactory instance = null;
   
    private WebhookFactory() 
    {

    }

    public static WebhookFactory getInstance() {

        if (instance == null)
        {
            instance =  new WebhookFactory();
        }

        return instance;
    }
    
   public void createRequest(RequestType type) throws Exception 
   {
      switch (type) 
      {
            case ATHLETE_REQUEST: new ReturnAthlete().getRequest();
            break;
            case ACTIVITIES_LIST_REQUEST: new ReturnActivitiesList().getRequest();
            break;
      }
    }

}
