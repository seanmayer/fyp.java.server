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
public class PowerLink_dto implements Serializable
{
    private Long powerLinkId;
    private Activity_dto activityId;
    private Power_dto powerId;

    public PowerLink_dto(Long powerLinkId, Activity_dto activityId, Power_dto powerId) {
        this.powerLinkId = powerLinkId;
        this.activityId = activityId;
        this.powerId = powerId;
    }

    /**
     * @return the powerLinkId
     */
    public Long getPowerLinkId() {
        return powerLinkId;
    }

    /**
     * @param powerLinkId the powerLinkId to set
     */
    public void setPowerLinkId(Long powerLinkId) {
        this.powerLinkId = powerLinkId;
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
     * @return the powerId
     */
    public Power_dto getPowerId() {
        return powerId;
    }

    /**
     * @param powerId the powerId to set
     */
    public void setPowerId(Power_dto powerId) {
        this.powerId = powerId;
    }
    
    
}
