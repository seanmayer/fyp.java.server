
package api;

import dto.Athlete_dto;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import javax.ejb.Remote;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Remote
public abstract class RequestHandler<T> 
{    
    public String STRAVA_USER_ID = null;
    public String STRAVA_ACCESS_TOKEN = null;
    public String ACTIVITY_ID = null;

    private Scanner requestConnection(URL url) throws IOException
    {
        InputStream openStream = url.openStream();
        return new Scanner(new BufferedInputStream(openStream), StandardCharsets.UTF_8.name());
    }
    
    private Scanner delimitateRequest(Scanner scanner) throws IOException
    {
        if (!scanner.useDelimiter("\\A").hasNext()) 
        {
            throw new EOFException("empty response");
        }     
        return scanner;
    }
    
    public JSONObject getJsonObject(URL url) throws JSONException, IOException
    {
        try(Scanner scanner = requestConnection(url);) 
        {
            delimitateRequest(scanner);
            return new JSONObject(scanner.next());
        }
    }
    
    public JSONArray getJsonArray(URL url) throws IOException, JSONException 
    {
        try(Scanner scanner = requestConnection(url);) 
        {
            delimitateRequest(scanner);
            return new JSONArray(scanner.next());
        }
    }
    
    public URL getURL() throws MalformedURLException
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getRequest() throws Exception
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
