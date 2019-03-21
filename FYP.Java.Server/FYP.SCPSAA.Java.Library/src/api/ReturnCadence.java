/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author 2008s
 */
public class ReturnCadence extends RequestHandler 
{
    @Override
    public URL getURL() throws MalformedURLException
    {
        return new URL("https://www.strava.com/api/v3/activities/" + ACTIVITY_ID + "/streams/time,cadence?access_token=" + STRAVA_ACCESS_TOKEN);
    }

    @Override
    public String getRequest() throws Exception
    {
        return getJsonArray(getURL()).toString();
    }
}
