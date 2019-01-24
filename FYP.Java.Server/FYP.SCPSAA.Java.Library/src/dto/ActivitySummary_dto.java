/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author 2008s
 */
public class ActivitySummary_dto 
{
    private Long activitySummaryId;
    private BigInteger movingTime;
    private BigDecimal distance;
    private BigDecimal maxSpeed;
    private BigDecimal maxWatts;
    private BigDecimal averageSpeed;
    private BigDecimal averageWatts;
    private BigDecimal averageCadence;
    private BigDecimal kilojoules;
    private Activity_dto activityId;

    public ActivitySummary_dto(Long activitySummaryId, BigInteger movingTime, BigDecimal distance, BigDecimal maxSpeed, BigDecimal maxWatts, BigDecimal averageSpeed, BigDecimal averageWatts, BigDecimal averageCadence, BigDecimal kilojoules, Activity_dto activityId) {
        this.activitySummaryId = activitySummaryId;
        this.movingTime = movingTime;
        this.distance = distance;
        this.maxSpeed = maxSpeed;
        this.maxWatts = maxWatts;
        this.averageSpeed = averageSpeed;
        this.averageWatts = averageWatts;
        this.averageCadence = averageCadence;
        this.kilojoules = kilojoules;
        this.activityId = activityId;
    }

    /**
     * @return the activitySummaryId
     */
    public Long getActivitySummaryId() {
        return activitySummaryId;
    }

    /**
     * @param activitySummaryId the activitySummaryId to set
     */
    public void setActivitySummaryId(Long activitySummaryId) {
        this.activitySummaryId = activitySummaryId;
    }

    /**
     * @return the movingTime
     */
    public BigInteger getMovingTime() {
        return movingTime;
    }

    /**
     * @param movingTime the movingTime to set
     */
    public void setMovingTime(BigInteger movingTime) {
        this.movingTime = movingTime;
    }

    /**
     * @return the distance
     */
    public BigDecimal getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    /**
     * @return the maxSpeed
     */
    public BigDecimal getMaxSpeed() {
        return maxSpeed;
    }

    /**
     * @param maxSpeed the maxSpeed to set
     */
    public void setMaxSpeed(BigDecimal maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    /**
     * @return the maxWatts
     */
    public BigDecimal getMaxWatts() {
        return maxWatts;
    }

    /**
     * @param maxWatts the maxWatts to set
     */
    public void setMaxWatts(BigDecimal maxWatts) {
        this.maxWatts = maxWatts;
    }

    /**
     * @return the averageSpeed
     */
    public BigDecimal getAverageSpeed() {
        return averageSpeed;
    }

    /**
     * @param averageSpeed the averageSpeed to set
     */
    public void setAverageSpeed(BigDecimal averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    /**
     * @return the averageWatts
     */
    public BigDecimal getAverageWatts() {
        return averageWatts;
    }

    /**
     * @param averageWatts the averageWatts to set
     */
    public void setAverageWatts(BigDecimal averageWatts) {
        this.averageWatts = averageWatts;
    }

    /**
     * @return the averageCadence
     */
    public BigDecimal getAverageCadence() {
        return averageCadence;
    }

    /**
     * @param averageCadence the averageCadence to set
     */
    public void setAverageCadence(BigDecimal averageCadence) {
        this.averageCadence = averageCadence;
    }

    /**
     * @return the kilojoules
     */
    public BigDecimal getKilojoules() {
        return kilojoules;
    }

    /**
     * @param kilojoules the kilojoules to set
     */
    public void setKilojoules(BigDecimal kilojoules) {
        this.kilojoules = kilojoules;
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
    
    
    
    
}
