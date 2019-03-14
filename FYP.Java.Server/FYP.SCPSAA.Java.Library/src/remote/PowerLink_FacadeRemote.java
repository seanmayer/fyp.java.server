/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remote;

import dto.PowerLink_dto;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author 2008s
 */
@Remote
public interface PowerLink_FacadeRemote 
{
     public void createPowerLink(PowerLink_dto powerDetails);
     public void editPowerLink(PowerLink_dto powerDetails);
     public void removePowerLink(Long id);
     public PowerLink_dto find(Object pk);
     public PowerLink_dto findById(Long id);
     public List<PowerLink_dto> findAll();
}
