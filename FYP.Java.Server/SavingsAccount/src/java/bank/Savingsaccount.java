/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 2008s
 */
@Entity
@Table(name = "SAVINGSACCOUNT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Savingsaccount.findAll", query = "SELECT s FROM Savingsaccount s")
    , @NamedQuery(name = "Savingsaccount.findById", query = "SELECT s FROM Savingsaccount s WHERE s.id = :id")
    , @NamedQuery(name = "Savingsaccount.findByFirstname", query = "SELECT s FROM Savingsaccount s WHERE s.firstname = :firstname")
    , @NamedQuery(name = "Savingsaccount.findByLastname", query = "SELECT s FROM Savingsaccount s WHERE s.lastname = :lastname")
    , @NamedQuery(name = "Savingsaccount.findByBalance", query = "SELECT s FROM Savingsaccount s WHERE s.balance = :balance")})
public class Savingsaccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Column(name = "LASTNAME")
    private String lastname;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "BALANCE")
    private BigDecimal balance;

    public Savingsaccount()
    {
    }
    
    public Savingsaccount(Long id, String fname, String lname, BigDecimal bal) 
    {
        this.id = id;
        firstname=fname;
        lastname=lname;
        balance=bal;
    }

    public Savingsaccount(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Savingsaccount)) {
            return false;
        }
        Savingsaccount other = (Savingsaccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bank.Savingsaccount[ id=" + id + " ]";
    }
    
}
