/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;

/**
 *
 * @author 2008s
 */
public class Power_dto implements Serializable
{
    private Long powerId;
    private BigDecimal datapoint;
    private BigInteger secondstamp;
    private Collection<PowerLink_dto> powerLinkCollection;

    public Power_dto(Long powerId) {
        this.powerId = powerId;
    }

    public Power_dto(Long powerId, BigDecimal datapoint, BigInteger secondstamp) {
        this.powerId = powerId;
        this.datapoint = datapoint;
        this.secondstamp = secondstamp;
    }

    /**
     * @return the powerId
     */
    public Long getPowerId() {
        return powerId;
    }

    /**
     * @param powerId the powerId to set
     */
    public void setPowerId(Long powerId) {
        this.powerId = powerId;
    }

    /**
     * @return the datapoint
     */
    public BigDecimal getDatapoint() {
        return datapoint;
    }

    /**
     * @param datapoint the datapoint to set
     */
    public void setDatapoint(BigDecimal datapoint) {
        this.datapoint = datapoint;
    }

    /**
     * @return the secondstamp
     */
    public BigInteger getSecondstamp() {
        return secondstamp;
    }

    /**
     * @param secondstamp the secondstamp to set
     */
    public void setSecondstamp(BigInteger secondstamp) {
        this.secondstamp = secondstamp;
    }

    /**
     * @return the powerLinkCollection
     */
    public Collection<PowerLink_dto> getPowerLinkCollection() {
        return powerLinkCollection;
    }

    /**
     * @param powerLinkCollection the powerLinkCollection to set
     */
    public void setPowerLinkCollection(Collection<PowerLink_dto> powerLinkCollection) {
        this.powerLinkCollection = powerLinkCollection;
    }
}
