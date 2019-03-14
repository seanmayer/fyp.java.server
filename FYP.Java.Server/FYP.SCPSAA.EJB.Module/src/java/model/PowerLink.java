/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
@Table(name = "POWER_LINK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PowerLink.findAll", query = "SELECT p FROM PowerLink p")
    , @NamedQuery(name = "PowerLink.findByPowerLinkId", query = "SELECT p FROM PowerLink p WHERE p.powerLinkId = :powerLinkId")})
public class PowerLink implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "POWER_LINK_ID")
    private Long powerLinkId;
    @JoinColumn(name = "ACTIVITY_ID", referencedColumnName = "ACTIVITY_ID")
    @ManyToOne(optional = false)
    private Activity activityId;
    @JoinColumn(name = "POWER_ID", referencedColumnName = "POWER_ID")
    @ManyToOne(optional = false)
    private Power powerId;

    public PowerLink() {
    }

    public PowerLink(Long powerLinkId, Activity activityId, Power powerId) {
        this.powerLinkId = powerLinkId;
        this.activityId = activityId;
        this.powerId = powerId;
    }

    public PowerLink(Long powerLinkId) {
        this.powerLinkId = powerLinkId;
    }

    public Long getPowerLinkId() {
        return powerLinkId;
    }

    public void setPowerLinkId(Long powerLinkId) {
        this.powerLinkId = powerLinkId;
    }

    public Activity getActivityId() {
        return activityId;
    }

    public void setActivityId(Activity activityId) {
        this.activityId = activityId;
    }

    public Power getPowerId() {
        return powerId;
    }

    public void setPowerId(Power powerId) {
        this.powerId = powerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (powerLinkId != null ? powerLinkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PowerLink)) {
            return false;
        }
        PowerLink other = (PowerLink) object;
        if ((this.powerLinkId == null && other.powerLinkId != null) || (this.powerLinkId != null && !this.powerLinkId.equals(other.powerLinkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.PowerLink[ powerLinkId=" + powerLinkId + " ]";
    }
    
}
