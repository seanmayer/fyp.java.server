/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author 2008s
 */
public class Credentials_dto implements Serializable
{
    private Long credentialsId;
    private String username;
    private String password;
    private Athlete_dto athleteId;

    public Credentials_dto() {
    }

    public Credentials_dto(Long credentialsId) {
        this.credentialsId = credentialsId;
    }
    
    public Credentials_dto(Long credentialsId, String username, String password) {
        this.credentialsId = credentialsId;
        this.username = username;
        this.password = password;
    }

    /**
     * @return the credentialsId
     */
    public Long getCredentialsId() {
        return credentialsId;
    }

    /**
     * @param credentialsId the credentialsId to set
     */
    public void setCredentialsId(Long credentialsId) {
        this.credentialsId = credentialsId;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the athleteId
     */
    public Athlete_dto getAthleteId() {
        return athleteId;
    }

    /**
     * @param athleteId the athleteId to set
     */
    public void setAthleteId(Athlete_dto athleteId) {
        this.athleteId = athleteId;
    }

    
    
    
    
    
    
}
