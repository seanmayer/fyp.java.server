/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author 2008s
 */
public class Strava
{

    public String STRAVA_USER_ID = "581409";
    public String STRAVA_ACCESS_TOKEN = "3aa96600c17636ee70c0fe95af4a28eeae20de32";
    
    public Strava() throws Exception 
    {
        System.out.println("Testing 1 - Send Http GET request");
        getActivitiesIDs();
    }
    
    
    public static void main(String[] args) throws Exception 
    {
        Strava strava = new Strava();
    }
    
    public URL getAthlete() throws MalformedURLException
    {
        return new URL("https://www.strava.com/api/v3/athletes/" + STRAVA_USER_ID + "?access_token=" + STRAVA_ACCESS_TOKEN);
    }
    
    public URL getActivities() throws MalformedURLException
    {
        return new URL("https://www.strava.com/api/v3/athlete/activities" + "?access_token=" + STRAVA_ACCESS_TOKEN);
    }
    
    public void getActivitiesIDs() throws MalformedURLException, IOException, JSONException
    {
        JSONArray values = getJsonArray(getActivities());
        
          for (int i = 0; i < values.length(); i++) 
          {
                JSONObject jsonObject = values.getJSONObject(i); 
                int id = jsonObject.getInt("id");
                System.out.println(id);
          }
    }
    
    
    public JSONArray getJsonArray(URL url) throws IOException, JSONException 
    {
        try
        (
            InputStream openStream = url.openStream();
            Scanner scanner = new Scanner(new BufferedInputStream(openStream), StandardCharsets.UTF_8.name());
        ) 
        {
            if (!scanner.useDelimiter("\\A").hasNext()) 
            {
                throw new EOFException("empty response");
            }

            return new JSONArray(scanner.next());
        }
    }

}
