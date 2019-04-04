package api;

import java.net.MalformedURLException;
import java.net.URL;

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
    }   
}