/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Collection;
import java.util.Date;

/**
 *
 * @author 2008s
 */
class Activity_dto 
{
    private Long activityId;
    private long stravaid;
    private String name;
    private Date startDate;
    private String timeZone;
    private Collection<ActivitySummary_dto> activitySummaryCollection;
    private Collection<CadenceLink_dto> cadenceLinkCollection;
    private Collection<PowerLink_dto> powerLinkCollection;
    private Collection<SpeedLink_dto> speedLinkCollection;
    private Athlete_dto athleteId;

    public Activity_dto(Long activityId, long stravaid, String name, Date startDate, String timeZone, Athlete_dto athleteId) {
        this.activityId = activityId;
        this.stravaid = stravaid;
        this.name = name;
        this.startDate = startDate;
        this.timeZone = timeZone;
        this.athleteId = athleteId;
    }

    
    
    
    /**
     * @return the activityId
     */
    public Long getActivityId() {
        return activityId;
    }

    /**
     * @param activityId the activityId to set
     */
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    /**
     * @return the stravaid
     */
    public long getStravaid() {
        return stravaid;
    }

    /**
     * @param stravaid the stravaid to set
     */
    public void setStravaid(long stravaid) {
        this.stravaid = stravaid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the timeZone
     */
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * @param timeZone the timeZone to set
     */
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    /**
     * @return the activitySummaryCollection
     */
    public Collection<ActivitySummary_dto> getActivitySummaryCollection() {
        return activitySummaryCollection;
    }

    /**
     * @param activitySummaryCollection the activitySummaryCollection to set
     */
    public void setActivitySummaryCollection(Collection<ActivitySummary_dto> activitySummaryCollection) {
        this.activitySummaryCollection = activitySummaryCollection;
    }

    /**
     * @return the cadenceLinkCollection
     */
    public Collection<CadenceLink_dto> getCadenceLinkCollection() {
        return cadenceLinkCollection;
    }

    /**
     * @param cadenceLinkCollection the cadenceLinkCollection to set
     */
    public void setCadenceLinkCollection(Collection<CadenceLink_dto> cadenceLinkCollection) {
        this.cadenceLinkCollection = cadenceLinkCollection;
    }

    /**
     * @return the powerLinkCollection
     */
    public Collection<PowerLink_dto> getPowerLinkCollection() {
        return powerLinkCollection;
    }

    /**
     * @param powerLinkCollection the powerLinkCollection to set
     */
    public void setPowerLinkCollection(Collection<PowerLink_dto> powerLinkCollection) {
        this.powerLinkCollection = powerLinkCollection;
    }

    /**
     * @return the speedLinkCollection
     */
    public Collection<SpeedLink_dto> getSpeedLinkCollection() {
        return speedLinkCollection;
    }

    /**
     * @param speedLinkCollection the speedLinkCollection to set
     */
    public void setSpeedLinkCollection(Collection<SpeedLink_dto> speedLinkCollection) {
        this.speedLinkCollection = speedLinkCollection;
    }

    /**
     * @return the athleteId
     */
    public Athlete_dto getAthleteId() {
        return athleteId;
    }

    /**
     * @param athleteId the athleteId to set
     */
    public void setAthleteId(Athlete_dto athleteId) {
        this.athleteId = athleteId;
    }
    
    
}
