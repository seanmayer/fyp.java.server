/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReturnActivitiesList extends RequestHandler 
{

    public URL getActivities() throws MalformedURLException
    {
        return new URL("https://www.strava.com/api/v3/athlete/activities" + "?access_token=" + STRAVA_ACCESS_TOKEN);
    }
    
    @Override
    public void getRequest() throws Exception
    {
        JSONArray values = getJsonArray(getActivities());
        
        for (int i = 0; i < values.length(); i++) 
        {
              JSONObject jsonObject = values.getJSONObject(i); 
              int id = jsonObject.getInt("id");
              System.out.println(id);
        }
    }
    
}
