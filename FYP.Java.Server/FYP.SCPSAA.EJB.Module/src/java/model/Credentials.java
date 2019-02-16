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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 2008s
 */
@Entity
@Table(name = "CREDENTIALS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Credentials.findAll", query = "SELECT c FROM Credentials c")
    , @NamedQuery(name = "Credentials.findByCredentialsId", query = "SELECT c FROM Credentials c WHERE c.credentialsId = :credentialsId")
    , @NamedQuery(name = "Credentials.findByUsername", query = "SELECT c FROM Credentials c WHERE c.username = :username")
    , @NamedQuery(name = "Credentials.findByPassword", query = "SELECT c FROM Credentials c WHERE c.password = :password")})
public class Credentials implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CREDENTIALS_ID")
    private Long credentialsId;
    @Size(max = 128)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 9)
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "credentialsId")
    private Collection<Athlete> athleteCollection;

    public Credentials() {
    }

    public Credentials(Long credentialsId) {
        this.credentialsId = credentialsId;
    }

    public Credentials(Long credentialsId, String username) {
        this.credentialsId = credentialsId;
        this.username = username;
    }

    public Credentials(Long credentialsId, String username, String password) {
        this.credentialsId = credentialsId;
        this.username = username;
        this.password = password;
    }
    
    public Long getCredentialsId() {
        return credentialsId;
    }

    public void setCredentialsId(Long credentialsId) {
        this.credentialsId = credentialsId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Athlete> getAthleteCollection() {
        return athleteCollection;
    }

    public void setAthleteCollection(Collection<Athlete> athleteCollection) {
        this.athleteCollection = athleteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (credentialsId != null ? credentialsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Credentials)) {
            return false;
        }
        Credentials other = (Credentials) object;
        if ((this.credentialsId == null && other.credentialsId != null) || (this.credentialsId != null && !this.credentialsId.equals(other.credentialsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Credentials[ credentialsId=" + credentialsId + " ]";
    }
    
}
