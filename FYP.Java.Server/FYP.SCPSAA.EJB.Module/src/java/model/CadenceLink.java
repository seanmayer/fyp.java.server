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
@Table(name = "CADENCE_LINK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CadenceLink.findAll", query = "SELECT c FROM CadenceLink c")
    , @NamedQuery(name = "CadenceLink.findByCadenceLinkId", query = "SELECT c FROM CadenceLink c WHERE c.cadenceLinkId = :cadenceLinkId")})
public class CadenceLink implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CADENCE_LINK_ID")
    private Long cadenceLinkId;
    @JoinColumn(name = "ACTIVITY_ID", referencedColumnName = "ACTIVITY_ID")
    @ManyToOne(optional = false)
    private Activity activityId;
    @JoinColumn(name = "CADENCE_ID", referencedColumnName = "CADENCE_ID")
    @ManyToOne(optional = false)
    private Cadence cadenceId;

    public CadenceLink() {
    }

    public CadenceLink(Long cadenceLinkId) {
        this.cadenceLinkId = cadenceLinkId;
    }

    public CadenceLink(Long cadenceLinkId, Activity activityId, Cadence cadenceId) {
        this.cadenceLinkId = cadenceLinkId;
        this.activityId = activityId;
        this.cadenceId = cadenceId;
    }
    
    public Long getCadenceLinkId() {
        return cadenceLinkId;
    }

    public void setCadenceLinkId(Long cadenceLinkId) {
        this.cadenceLinkId = cadenceLinkId;
    }

    public Activity getActivityId() {
        return activityId;
    }

    public void setActivityId(Activity activityId) {
        this.activityId = activityId;
    }

    public Cadence getCadenceId() {
        return cadenceId;
    }

    public void setCadenceId(Cadence cadenceId) {
        this.cadenceId = cadenceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cadenceLinkId != null ? cadenceLinkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CadenceLink)) {
            return false;
        }
        CadenceLink other = (CadenceLink) object;
        if ((this.cadenceLinkId == null && other.cadenceLinkId != null) || (this.cadenceLinkId != null && !this.cadenceLinkId.equals(other.cadenceLinkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CadenceLink[ cadenceLinkId=" + cadenceLinkId + " ]";
    }
    
}
