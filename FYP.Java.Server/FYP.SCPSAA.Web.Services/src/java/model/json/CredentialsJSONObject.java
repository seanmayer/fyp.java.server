/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.json;

/**
 *
 * @author 2008s
 */
public class CredentialsJSONObject 
{
    private Long credentialsId;
    private String username;
    private String password;

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
    
    

}