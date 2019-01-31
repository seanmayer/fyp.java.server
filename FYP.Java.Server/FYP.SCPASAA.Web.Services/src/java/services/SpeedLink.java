/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.io.Serializable;
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
@Table(name = "SPEED_LINK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpeedLink.findAll", query = "SELECT s FROM SpeedLink s")
    , @NamedQuery(name = "SpeedLink.findBySpeedLinkId", query = "SELECT s FROM SpeedLink s WHERE s.speedLinkId = :speedLinkId")})
public class SpeedLink implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SPEED_LINK_ID")
    private Long speedLinkId;
    @JoinColumn(name = "ACTIVITY_ID", referencedColumnName = "ACTIVITY_ID")
    @ManyToOne(optional = false)
    private Activity activityId;
    @JoinColumn(name = "SPEED_ID", referencedColumnName = "SPEED_ID")
    @ManyToOne(optional = false)
    private Speed speedId;

    public SpeedLink() {
    }

    public SpeedLink(Long speedLinkId) {
        this.speedLinkId = speedLinkId;
    }

    public Long getSpeedLinkId() {
        return speedLinkId;
    }

    public void setSpeedLinkId(Long speedLinkId) {
        this.speedLinkId = speedLinkId;
    }

    public Activity getActivityId() {
        return activityId;
    }

    public void setActivityId(Activity activityId) {
        this.activityId = activityId;
    }

    public Speed getSpeedId() {
        return speedId;
    }

    public void setSpeedId(Speed speedId) {
        this.speedId = speedId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (speedLinkId != null ? speedLinkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpeedLink)) {
            return false;
        }
        SpeedLink other = (SpeedLink) object;
        if ((this.speedLinkId == null && other.speedLinkId != null) || (this.speedLinkId != null && !this.speedLinkId.equals(other.speedLinkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "services.SpeedLink[ speedLinkId=" + speedLinkId + " ]";
    }
    
}
