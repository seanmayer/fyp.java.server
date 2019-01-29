
package api;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONException;


public abstract class RequestHandler 
{
    //requestHandler.STRAVA_USER_ID = value;
    
    public String STRAVA_USER_ID = "581409";
    public String STRAVA_ACCESS_TOKEN = "3aa96600c17636ee70c0fe95af4a28eeae20de32";

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
    
    
    
    public void getRequest() throws Exception
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
