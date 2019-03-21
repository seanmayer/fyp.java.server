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
@Table(name = "CADENCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cadence.findAll", query = "SELECT c FROM Cadence c")
    , @NamedQuery(name = "Cadence.findByCadenceId", query = "SELECT c FROM Cadence c WHERE c.cadenceId = :cadenceId")
    , @NamedQuery(name = "Cadence.findByDatapoint", query = "SELECT c FROM Cadence c WHERE c.datapoint = :datapoint")
    , @NamedQuery(name = "Cadence.findBySecondstamp", query = "SELECT c FROM Cadence c WHERE c.secondstamp = :secondstamp")})
public class Cadence implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CADENCE_ID")
    private Long cadenceId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DATAPOINT")
    private BigDecimal datapoint;
    @Column(name = "SECONDSTAMP")
    private BigInteger secondstamp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cadenceId")
    private Collection<CadenceLink> cadenceLinkCollection;

    public Cadence() {
    }

    public Cadence(Long cadenceId) {
        this.cadenceId = cadenceId;
    }

    public Cadence(Long cadenceId, BigDecimal datapoint, BigInteger secondstamp) {
        this.cadenceId = cadenceId;
        this.datapoint = datapoint;
        this.secondstamp = secondstamp;
    }
    
    

    public Long getCadenceId() {
        return cadenceId;
    }

    public void setCadenceId(Long cadenceId) {
        this.cadenceId = cadenceId;
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
    public Collection<CadenceLink> getCadenceLinkCollection() {
        return cadenceLinkCollection;
    }

    public void setCadenceLinkCollection(Collection<CadenceLink> cadenceLinkCollection) {
        this.cadenceLinkCollection = cadenceLinkCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cadenceId != null ? cadenceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cadence)) {
            return false;
        }
        Cadence other = (Cadence) object;
        if ((this.cadenceId == null && other.cadenceId != null) || (this.cadenceId != null && !this.cadenceId.equals(other.cadenceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cadence[ cadenceId=" + cadenceId + " ]";
    }
    
}
