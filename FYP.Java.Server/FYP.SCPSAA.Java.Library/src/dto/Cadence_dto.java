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
public class Cadence_dto implements Serializable
{
    private Long cadenceId;
    private BigDecimal datapoint;
    private BigInteger secondstamp;
    private Collection<CadenceLink_dto> cadenceLinkCollection;

    public Cadence_dto(Long cadenceId, BigDecimal datapoint, BigInteger secondstamp, Collection<CadenceLink_dto> cadenceLinkCollection) {
        this.cadenceId = cadenceId;
        this.datapoint = datapoint;
        this.secondstamp = secondstamp;
        this.cadenceLinkCollection = cadenceLinkCollection;
    }
    
    /**
     * @return the cadenceId
     */
    public Long getCadenceId() {
        return cadenceId;
    }

    /**
     * @param cadenceId the cadenceId to set
     */
    public void setCadenceId(Long cadenceId) {
        this.cadenceId = cadenceId;
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
     * @return the cadenceLinkCollection
     */
    public Collection<CadenceLink_dto> getCadenceLinkCollection() {
        return cadenceLinkCollection;
    }

    /**
     * @param cadenceLinkCollection the cadenceLinkCollection to set
     */
    public void setCadenceLinkCollection(Collection<CadenceLink_dto> cadenceLinkCollection) {
        this.cadenceLinkCollection = cadenceLinkCollection;
    }
}
