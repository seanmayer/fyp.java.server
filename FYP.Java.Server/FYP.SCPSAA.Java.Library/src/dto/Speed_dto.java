/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;

/**
 *
 * @author 2008s
 */
class Speed_dto 
{
    private Long speedId;
    private BigDecimal datapoint;
    private BigInteger secondstamp;
    private Collection<SpeedLink_dto> speedLinkCollection; 

    public Speed_dto(Long speedId, BigDecimal datapoint, BigInteger secondstamp) {
        this.speedId = speedId;
        this.datapoint = datapoint;
        this.secondstamp = secondstamp;
    }

    /**
     * @return the speedId
     */
    public Long getSpeedId() {
        return speedId;
    }

    /**
     * @param speedId the speedId to set
     */
    public void setSpeedId(Long speedId) {
        this.speedId = speedId;
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
     * @return the speedLinkCollection
     */
    public Collection<SpeedLink_dto> getSpeedLinkCollection() {
        return speedLinkCollection;
    }

    /**
     * @param speedLinkCollection the speedLinkCollection to set
     */
    public void setSpeedLinkCollection(Collection<SpeedLink_dto> speedLinkCollection) {
        this.speedLinkCollection = speedLinkCollection;
    }
}
