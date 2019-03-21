/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remote;

import dto.SpeedLink_dto;
import java.util.List;
import javax.ejb.Remote;
/**
 *
 * @author 2008s
 */
@Remote
public interface SpeedLink_FacadeRemote 
{
     public Long createSpeedLink(SpeedLink_dto speedLinkDetails);
     public void editSpeedLink(SpeedLink_dto speedLinkDetails);
     public void removeSpeedLink(Long id);
     public SpeedLink_dto find(Object pk);
     public SpeedLink_dto findById(Long id);
     public List<SpeedLink_dto> findAll();
}
