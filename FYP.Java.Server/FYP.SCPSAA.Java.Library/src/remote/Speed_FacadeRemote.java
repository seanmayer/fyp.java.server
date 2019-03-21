/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remote;

import dto.Speed_dto;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author 2008s
 */
@Remote
public interface Speed_FacadeRemote 
{
     public Long createSpeed(Speed_dto speedDetails);
     public void editSpeed(Speed_dto speedDetails);
     public void removeSpeed(Long id);
     public Speed_dto find(Object pk);
     public Speed_dto findById(Long id);
     public List<Speed_dto> findAll();
}
