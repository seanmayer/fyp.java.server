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
public class CadenceLink_dto implements Serializable
{
    private Long cadenceLinkId;
    private Activity_dto activityId;
    private Cadence_dto cadenceId;

    public CadenceLink_dto(Long cadenceLinkId, Activity_dto activityId, Cadence_dto cadenceId) {
        this.cadenceLinkId = cadenceLinkId;
        this.activityId = activityId;
        this.cadenceId = cadenceId;
    }

    /**
     * @return the cadenceLinkId
     */
    public Long getCadenceLinkId() {
        return cadenceLinkId;
    }

    /**
     * @param cadenceLinkId the cadenceLinkId to set
     */
    public void setCadenceLinkId(Long cadenceLinkId) {
        this.cadenceLinkId = cadenceLinkId;
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
     * @return the cadenceId
     */
    public Cadence_dto getCadenceId() {
        return cadenceId;
    }

    /**
     * @param cadenceId the cadenceId to set
     */
    public void setCadenceId(Cadence_dto cadenceId) {
        this.cadenceId = cadenceId;
    }
    
    
}
