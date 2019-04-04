
package api;

import javax.ejb.Remote;

@Remote
public enum RequestType 
{
    ATHLETE_REQUEST,
    ACTIVITIES_LIST_REQUEST,
    SPEED_STREAM,
    POWER_STREAM,
    CADENCE_STREAM,
    ACTIVITY_SUMMARY;
}
