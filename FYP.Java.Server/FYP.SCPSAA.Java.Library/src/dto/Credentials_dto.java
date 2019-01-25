/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Collection;

/**
 *
 * @author 2008s
 */
class Credentials_dto 
{
    private Long credentialsId;
    private String username;
    private String password;
    private Athlete_dto athleteId;

    
    
    
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

    public Athlete_dto getAthleteId() {
        return athleteId;
    }

    public void setAthleteId(Athlete_dto athleteId) {
        this.athleteId = athleteId;
    }

    
    
    
    
}
