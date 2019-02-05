/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import dto.Activity_dto;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReturnActivitiesList extends RequestHandler 
{
    @Override
    public URL getURL() throws MalformedURLException
    {
        return new URL("https://www.strava.com/api/v3/athlete/activities" + "?access_token=" + STRAVA_ACCESS_TOKEN);
    }
    
    @Override
    public String getRequest() throws Exception
    {
        return getJsonArray(getURL()).toString();
        
//        for (int i = 0; i < values.length(); i++) 
//        {
//              JSONObject jsonObject = values.getJSONObject(i); 
//              int id = jsonObject.getInt("id");
//              System.out.println(id);
//        }
    }   
}