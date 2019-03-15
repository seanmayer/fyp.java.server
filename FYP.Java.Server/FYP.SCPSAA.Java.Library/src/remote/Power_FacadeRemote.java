/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remote;

import dto.Power_dto;
import dto.Athlete_dto;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author 2008s
 */
@Remote
public interface Power_FacadeRemote 
{
     public Long createPower(Power_dto powerDetails);
     public void editPower(Power_dto powerDetails);
     public void removePower(Long id);
     public Power_dto find(Object pk);
     public Power_dto findById(Long id);
     public List<Power_dto> findAll();
}
