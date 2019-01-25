/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 2008s
 */
@Entity
@Table(name = "ACTIVITY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activity.findAll", query = "SELECT a FROM Activity a")
    , @NamedQuery(name = "Activity.findByActivityId", query = "SELECT a FROM Activity a WHERE a.activityId = :activityId")
    , @NamedQuery(name = "Activity.findByStravaid", query = "SELECT a FROM Activity a WHERE a.stravaid = :stravaid")
    , @NamedQuery(name = "Activity.findByName", query = "SELECT a FROM Activity a WHERE a.name = :name")
    , @NamedQuery(name = "Activity.findByStartDate", query = "SELECT a FROM Activity a WHERE a.startDate = :startDate")
    , @NamedQuery(name = "Activity.findByTimeZone", query = "SELECT a FROM Activity a WHERE a.timeZone = :timeZone")})
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ACTIVITY_ID")
    private Long activityId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STRAVAID")
    private long stravaid;
    @Size(max = 50)
    @Column(name = "NAME")
    private String name;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Size(max = 50)
    @Column(name = "TIME_ZONE")
    private String timeZone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activityId")
    private Collection<CadenceLink> cadenceLinkCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activityId")
    private Collection<PowerLink> powerLinkCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "activityId")
    private Collection<SpeedLink> speedLinkCollection;
    @JoinColumn(name = "ATHLETE_ID", referencedColumnName = "ATHLETE_ID")
    @ManyToOne(optional = false)
    private Athlete athleteId;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "activityId")
    private ActivitySummary activitySummaryId;

    public Activity() {
    }

    public Activity(Long activityId) {
        this.activityId = activityId;
    }

    public Activity(Long activityId, long stravaid) {
        this.activityId = activityId;
        this.stravaid = stravaid;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public long getStravaid() {
        return stravaid;
    }

    public void setStravaid(long stravaid) {
        this.stravaid = stravaid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public ActivitySummary getActivitySummaryId() {
        return activitySummaryId;
    }

    public void setActivitySummaryId(ActivitySummary activitySummaryId) {
        this.activitySummaryId = activitySummaryId;
    }

    @XmlTransient
    public Collection<CadenceLink> getCadenceLinkCollection() {
        return cadenceLinkCollection;
    }

    public void setCadenceLinkCollection(Collection<CadenceLink> cadenceLinkCollection) {
        this.cadenceLinkCollection = cadenceLinkCollection;
    }

    @XmlTransient
    public Collection<PowerLink> getPowerLinkCollection() {
        return powerLinkCollection;
    }

    public void setPowerLinkCollection(Collection<PowerLink> powerLinkCollection) {
        this.powerLinkCollection = powerLinkCollection;
    }

    @XmlTransient
    public Collection<SpeedLink> getSpeedLinkCollection() {
        return speedLinkCollection;
    }

    public void setSpeedLinkCollection(Collection<SpeedLink> speedLinkCollection) {
        this.speedLinkCollection = speedLinkCollection;
    }

    public Athlete getAthleteId() {
        return athleteId;
    }

    public void setAthleteId(Athlete athleteId) {
        this.athleteId = athleteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (activityId != null ? activityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activity)) {
            return false;
        }
        Activity other = (Activity) object;
        if ((this.activityId == null && other.activityId != null) || (this.activityId != null && !this.activityId.equals(other.activityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Activity[ activityId=" + activityId + " ]";
    }
    
}
