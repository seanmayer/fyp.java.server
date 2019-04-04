/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.net.MalformedURLException;
import java.net.URL;



public class ReturnActivitySummary extends RequestHandler
{
    @Override
    public URL getURL() throws MalformedURLException
    {
        return new URL("https://www.strava.com/api/v3/athlete/activities" +"?access_token=" + STRAVA_ACCESS_TOKEN);
    }

    @Override
    public String getRequest() throws Exception
    {
        return getJsonArray(getURL()).toString();
    }
}
    

