/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 *
 * @author 2008s
 */
public class SpeedLink_dto implements Serializable
{
    private Long speedLinkId;
    private Activity_dto activityId;
    private Speed_dto speedId;

    public SpeedLink_dto(Long speedLinkId, Activity_dto activityId, Speed_dto speedId) {
        this.speedLinkId = speedLinkId;
        this.activityId = activityId;
        this.speedId = speedId;
    }

    /**
     * @return the speedLinkId
     */
    public Long getSpeedLinkId() {
        return speedLinkId;
    }

    /**
     * @param speedLinkId the speedLinkId to set
     */
    public void setSpeedLinkId(Long speedLinkId) {
        this.speedLinkId = speedLinkId;
    }

    /**
     * @return the activityId
     */
    public Activity_dto getActivityId() {
        return activityId;
    }

    /**
     * @param activityId the activityId to set
     */
    public void setActivityId(Activity_dto activityId) {
        this.activityId = activityId;
    }

    /**
     * @return the speedId
     */
    public Speed_dto getSpeedId() {
        return speedId;
    }

    /**
     * @param speedId the speedId to set
     */
    public void setSpeedId(Speed_dto speedId) {
        this.speedId = speedId;
    }
    
    
}
