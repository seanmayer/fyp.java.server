/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remote;

import dto.ActivitySummary_dto;
import dto.Activity_dto;
import java.util.List;
import javax.ejb.Remote;



/**
 *
 * @author 2008s
 */
@Remote
public interface ActivitySummary_FacadeRemote 
{
     public void createActivitySummary(ActivitySummary_dto activitySummaryDetails);
     public void editActivitySummary(ActivitySummary_dto activitySummaryDetails);
     public void removeActivitySummary(Long id);
     public Activity_dto find(Object pk);
     public Activity_dto findById(Long id);
     public List<Activity_dto> findAll();
}
