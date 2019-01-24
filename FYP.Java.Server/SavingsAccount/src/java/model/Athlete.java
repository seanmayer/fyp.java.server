/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 2008s
 */
@Entity
@Table(name = "ATHLETE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Athlete.findAll", query = "SELECT a FROM Athlete a")
    , @NamedQuery(name = "Athlete.findByAthleteId", query = "SELECT a FROM Athlete a WHERE a.athleteId = :athleteId")
    , @NamedQuery(name = "Athlete.findByStravaid", query = "SELECT a FROM Athlete a WHERE a.stravaid = :stravaid")
    , @NamedQuery(name = "Athlete.findByFirstname", query = "SELECT a FROM Athlete a WHERE a.firstname = :firstname")
    , @NamedQuery(name = "Athlete.findByLastname", query = "SELECT a FROM Athlete a WHERE a.lastname = :lastname")})
public class Athlete implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ATHLETE_ID")
    private Long athleteId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STRAVAID")
    private long stravaid;
    @Size(max = 50)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Size(max = 50)
    @Column(name = "LASTNAME")
    private String lastname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "athleteId")
    private Collection<Activity> activityCollection;

    public Athlete() {
    }

    public Athlete(Long athleteId) {
        this.athleteId = athleteId;
    }

    public Athlete(Long athleteId, long stravaid) {
        this.athleteId = athleteId;
        this.stravaid = stravaid;
    }

    public Long getAthleteId() {
        return athleteId;
    }

    public void setAthleteId(Long athleteId) {
        this.athleteId = athleteId;
    }

    public long getStravaid() {
        return stravaid;
    }

    public void setStravaid(long stravaid) {
        this.stravaid = stravaid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @XmlTransient
    public Collection<Activity> getActivityCollection() {
        return activityCollection;
    }

    public void setActivityCollection(Collection<Activity> activityCollection) {
        this.activityCollection = activityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (athleteId != null ? athleteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Athlete)) {
            return false;
        }
        Athlete other = (Athlete) object;
        if ((this.athleteId == null && other.athleteId != null) || (this.athleteId != null && !this.athleteId.equals(other.athleteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Athlete[ athleteId=" + athleteId + " ]";
    }
    
}
