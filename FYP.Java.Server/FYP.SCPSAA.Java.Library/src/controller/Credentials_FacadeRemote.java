/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.Credentials_dto;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface Credentials_FacadeRemote 
{
     public void createCredentials(Credentials_dto details);
     public void editCredentials(Credentials_dto details);
     public void removeCredentials(Long id);
     public Credentials_dto find(Object pk);
     public Credentials_dto findById(Long id);
     public List<Credentials_dto> findAll();
}
