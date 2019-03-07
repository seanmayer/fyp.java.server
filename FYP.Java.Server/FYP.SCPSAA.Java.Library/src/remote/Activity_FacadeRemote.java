/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remote;

import dto.Activity_dto;
import dto.Athlete_dto;
import java.util.List;
import javax.ejb.Remote;



/**
 *
 * @author 2008s
 */
@Remote
public interface Activity_FacadeRemote 
{
     public void createActivity(Activity_dto activityDetails);
     public void editActivity(Athlete_dto details, Activity_dto activityDetails);
     public void removeActivity(Long id);
     public Activity_dto find(Object pk);
     public Activity_dto findById(Long id);
     public List<Activity_dto> findAll();
}
