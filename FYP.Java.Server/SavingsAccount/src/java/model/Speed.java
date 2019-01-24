/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 2008s
 */
@Entity
@Table(name = "SPEED")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Speed.findAll", query = "SELECT s FROM Speed s")
    , @NamedQuery(name = "Speed.findBySpeedId", query = "SELECT s FROM Speed s WHERE s.speedId = :speedId")
    , @NamedQuery(name = "Speed.findByDatapoint", query = "SELECT s FROM Speed s WHERE s.datapoint = :datapoint")
    , @NamedQuery(name = "Speed.findBySecondstamp", query = "SELECT s FROM Speed s WHERE s.secondstamp = :secondstamp")})
public class Speed implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SPEED_ID")
    private Long speedId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DATAPOINT")
    private BigDecimal datapoint;
    @Column(name = "SECONDSTAMP")
    private BigInteger secondstamp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "speedId")
    private Collection<SpeedLink> speedLinkCollection;

    public Speed() {
    }

    public Speed(Long speedId) {
        this.speedId = speedId;
    }

    public Long getSpeedId() {
        return speedId;
    }

    public void setSpeedId(Long speedId) {
        this.speedId = speedId;
    }

    public BigDecimal getDatapoint() {
        return datapoint;
    }

    public void setDatapoint(BigDecimal datapoint) {
        this.datapoint = datapoint;
    }

    public BigInteger getSecondstamp() {
        return secondstamp;
    }

    public void setSecondstamp(BigInteger secondstamp) {
        this.secondstamp = secondstamp;
    }

    @XmlTransient
    public Collection<SpeedLink> getSpeedLinkCollection() {
        return speedLinkCollection;
    }

    public void setSpeedLinkCollection(Collection<SpeedLink> speedLinkCollection) {
        this.speedLinkCollection = speedLinkCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (speedId != null ? speedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Speed)) {
            return false;
        }
        Speed other = (Speed) object;
        if ((this.speedId == null && other.speedId != null) || (this.speedId != null && !this.speedId.equals(other.speedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Speed[ speedId=" + speedId + " ]";
    }
    
}
