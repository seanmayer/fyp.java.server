
package api;

import javax.ejb.Remote;

@Remote
public enum RequestType 
{
    ATHLETE_REQUEST,
    ACTIVITIES_LIST_REQUEST,
    TEMPERATURE_STREAM,
    POWER_STREAM,
    CADENCE_STREAM;
}
