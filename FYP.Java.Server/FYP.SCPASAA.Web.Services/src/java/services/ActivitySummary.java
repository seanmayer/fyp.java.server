/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 2008s
 */
@Entity
@Table(name = "ACTIVITY_SUMMARY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActivitySummary.findAll", query = "SELECT a FROM ActivitySummary a")
    , @NamedQuery(name = "ActivitySummary.findByActivitySummaryId", query = "SELECT a FROM ActivitySummary a WHERE a.activitySummaryId = :activitySummaryId")
    , @NamedQuery(name = "ActivitySummary.findByMovingTime", query = "SELECT a FROM ActivitySummary a WHERE a.movingTime = :movingTime")
    , @NamedQuery(name = "ActivitySummary.findByDistance", query = "SELECT a FROM ActivitySummary a WHERE a.distance = :distance")
    , @NamedQuery(name = "ActivitySummary.findByMaxSpeed", query = "SELECT a FROM ActivitySummary a WHERE a.maxSpeed = :maxSpeed")
    , @NamedQuery(name = "ActivitySummary.findByMaxWatts", query = "SELECT a FROM ActivitySummary a WHERE a.maxWatts = :maxWatts")
    , @NamedQuery(name = "ActivitySummary.findByAverageSpeed", query = "SELECT a FROM ActivitySummary a WHERE a.averageSpeed = :averageSpeed")
    , @NamedQuery(name = "ActivitySummary.findByAverageWatts", query = "SELECT a FROM ActivitySummary a WHERE a.averageWatts = :averageWatts")
    , @NamedQuery(name = "ActivitySummary.findByAverageCadence", query = "SELECT a FROM ActivitySummary a WHERE a.averageCadence = :averageCadence")
    , @NamedQuery(name = "ActivitySummary.findByKilojoules", query = "SELECT a FROM ActivitySummary a WHERE a.kilojoules = :kilojoules")})
public class ActivitySummary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ACTIVITY_SUMMARY_ID")
    private Long activitySummaryId;
    @Column(name = "MOVING_TIME")
    private BigInteger movingTime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DISTANCE")
    private BigDecimal distance;
    @Column(name = "MAX_SPEED")
    private BigDecimal maxSpeed;
    @Column(name = "MAX_WATTS")
    private BigDecimal maxWatts;
    @Column(name = "AVERAGE_SPEED")
    private BigDecimal averageSpeed;
    @Column(name = "AVERAGE_WATTS")
    private BigDecimal averageWatts;
    @Column(name = "AVERAGE_CADENCE")
    private BigDecimal averageCadence;
    @Column(name = "KILOJOULES")
    private BigDecimal kilojoules;
    @JoinColumn(name = "ACTIVITY_ID", referencedColumnName = "ACTIVITY_ID")
    @ManyToOne(optional = false)
    private Activity activityId;

    public ActivitySummary() {
    }

    public ActivitySummary(Long activitySummaryId) {
        this.activitySummaryId = activitySummaryId;
    }

    public Long getActivitySummaryId() {
        return activitySummaryId;
    }

    public void setActivitySummaryId(Long activitySummaryId) {
        this.activitySummaryId = activitySummaryId;
    }

    public BigInteger getMovingTime() {
        return movingTime;
    }

    public void setMovingTime(BigInteger movingTime) {
        this.movingTime = movingTime;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public BigDecimal getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(BigDecimal maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public BigDecimal getMaxWatts() {
        return maxWatts;
    }

    public void setMaxWatts(BigDecimal maxWatts) {
        this.maxWatts = maxWatts;
    }

    public BigDecimal getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(BigDecimal averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public BigDecimal getAverageWatts() {
        return averageWatts;
    }

    public void setAverageWatts(BigDecimal averageWatts) {
        this.averageWatts = averageWatts;
    }

    public BigDecimal getAverageCadence() {
        return averageCadence;
    }

    public void setAverageCadence(BigDecimal averageCadence) {
        this.averageCadence = averageCadence;
    }

    public BigDecimal getKilojoules() {
        return kilojoules;
    }

    public void setKilojoules(BigDecimal kilojoules) {
        this.kilojoules = kilojoules;
    }

    public Activity getActivityId() {
        return activityId;
    }

    public void setActivityId(Activity activityId) {
        this.activityId = activityId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (activitySummaryId != null ? activitySummaryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivitySummary)) {
            return false;
        }
        ActivitySummary other = (ActivitySummary) object;
        if ((this.activitySummaryId == null && other.activitySummaryId != null) || (this.activitySummaryId != null && !this.activitySummaryId.equals(other.activitySummaryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "services.ActivitySummary[ activitySummaryId=" + activitySummaryId + " ]";
    }
    
}
