/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;

/**
 * Data Transfer Object pattern
 */

public class Athlete_dto implements Serializable
{
    private Long athleteId;
    private Long stravaid;
    private String firstname;
    private String lastname;
    private Credentials_dto credentialsId;

    public Athlete_dto(Long athleteId) {
        this.athleteId = athleteId;
    }

    public Athlete_dto(Long athleteId, Long stravaid, String firstname, String lastname) {
        this.athleteId = athleteId;
        this.stravaid = stravaid;
        this.firstname = firstname;
        this.lastname = lastname;
    }    
    
    public Athlete_dto(Long athleteId, Long stravaid, String firstname, String lastname, Credentials_dto credentialsId) {
        this.athleteId = athleteId;
        this.stravaid = stravaid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.credentialsId = credentialsId;
    }

    /**
     * @return the athleteId
     */
    public Long getAthleteId() {
        return athleteId;
    }

    /**
     * @param athleteId the athleteId to set
     */
    public void setAthleteId(Long athleteId) {
        this.athleteId = athleteId;
    }

    /**
     * @return the stravaid
     */
    public Long getStravaid() {
        return stravaid;
    }

    /**
     * @param stravaid the stravaid to set
     */
    public void setStravaid(long stravaid) {
        this.stravaid = stravaid;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the credentialsId
     */
    public Credentials_dto getCredentialsId() {
        return credentialsId;
    }

    /**
     * @param credentialsId the credentialsId to set
     */
    public void setCredentialsId(Credentials_dto credentialsId) {
        this.credentialsId = credentialsId;
    }
    
    
}
