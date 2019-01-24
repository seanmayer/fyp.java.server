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
@Table(name = "POWER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Power.findAll", query = "SELECT p FROM Power p")
    , @NamedQuery(name = "Power.findByPowerId", query = "SELECT p FROM Power p WHERE p.powerId = :powerId")
    , @NamedQuery(name = "Power.findByDatapoint", query = "SELECT p FROM Power p WHERE p.datapoint = :datapoint")
    , @NamedQuery(name = "Power.findBySecondstamp", query = "SELECT p FROM Power p WHERE p.secondstamp = :secondstamp")})
public class Power implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "POWER_ID")
    private Long powerId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DATAPOINT")
    private BigDecimal datapoint;
    @Column(name = "SECONDSTAMP")
    private BigInteger secondstamp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "powerId")
    private Collection<PowerLink> powerLinkCollection;

    public Power() {
    }

    public Power(Long powerId) {
        this.powerId = powerId;
    }

    public Long getPowerId() {
        return powerId;
    }

    public void setPowerId(Long powerId) {
        this.powerId = powerId;
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
    public Collection<PowerLink> getPowerLinkCollection() {
        return powerLinkCollection;
    }

    public void setPowerLinkCollection(Collection<PowerLink> powerLinkCollection) {
        this.powerLinkCollection = powerLinkCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (powerId != null ? powerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Power)) {
            return false;
        }
        Power other = (Power) object;
        if ((this.powerId == null && other.powerId != null) || (this.powerId != null && !this.powerId.equals(other.powerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Power[ powerId=" + powerId + " ]";
    }
    
}
