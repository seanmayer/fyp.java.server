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
public class ReturnAthlete extends RequestHandler
{
    public URL getAthlete() throws MalformedURLException
    {
        return new URL("https://www.strava.com/api/v3/athletes/" + STRAVA_USER_ID + "?access_token=" + STRAVA_ACCESS_TOKEN);
    }

    @Override
    public void getRequest() throws Exception
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
