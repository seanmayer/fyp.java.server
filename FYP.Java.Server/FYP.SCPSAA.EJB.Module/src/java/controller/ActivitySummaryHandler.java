package controller;

import dto.ActivitySummary_dto;
import dto.Activity_dto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import model.Activity;
import model.ActivitySummary;
import remote.ActivitySummary_FacadeRemote;



@Stateless(mappedName="activitysummaryfacade")
public class ActivitySummaryHandler extends AbstractEntityManager implements ActivitySummary_FacadeRemote 
{

    private List<ActivitySummary_dto> copyActivitySummary(List<ActivitySummary> activitysummaries)
    {
        List<ActivitySummary_dto> activitySummaryList = new ArrayList<>();
        Iterator i = activitysummaries.iterator();
    
            while (i.hasNext())
            {
                ActivitySummary c = (ActivitySummary) i.next();
 //        Long activitySummaryId, BigInteger movingTime, BigDecimal distance, BigDecimal maxSpeed, BigDecimal maxWatts, BigDecimal averageSpeed, BigDecimal averageWatts, BigDecimal averageCadence, BigDecimal kilojoules, Activity activityId               
                ActivitySummary_dto details = new ActivitySummary_dto(c.getActivitySummaryId(),
                                                                      c.getMovingTime(),
                                                                      c.getDistance(),
                                                                      c.getMaxSpeed(),
                                                                      c.getMaxWatts(),
                                                                      c.getAverageSpeed(),
                                                                      c.getAverageWatts(),
                                                                      c.getAverageCadence(),
                                                                      c.getKilojoules(),
                                                                      new Activity_dto(c.getActivityId().getActivityId()));
                activitySummaryList.add(details);
            }
            
        return activitySummaryList;
    }

    @Override
    public void createActivitySummary(ActivitySummary_dto activitySummaryDetails) {
        
        try
        {
          Activity activity = em.getReference(Activity.class, activitySummaryDetails.getActivityId().getActivityId());
          ActivitySummary activitySummary = new ActivitySummary(activitySummaryDetails.getActivitySummaryId(),
                                                                      activitySummaryDetails.getMovingTime(),
                                                                      activitySummaryDetails.getDistance(),
                                                                      activitySummaryDetails.getMaxSpeed(),
                                                                      activitySummaryDetails.getMaxWatts(),
                                                                      activitySummaryDetails.getAverageSpeed(),
                                                                      activitySummaryDetails.getAverageWatts(),
                                                                      activitySummaryDetails.getAverageCadence(),
                                                                      activitySummaryDetails.getKilojoules(),
                                                                      activity);
            persistMany(activitySummary);
            em.flush();
        }
        catch (Exception e)
        {
           
        }
        
    }

    @Override
    public void editActivitySummary(ActivitySummary_dto activitySummaryDetails) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeActivitySummary(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ActivitySummary_dto find(Object pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ActivitySummary_dto findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ActivitySummary_dto> findAll() {
        return copyActivitySummary(em.createQuery("select object(o) from ActivitySummary o ").getResultList());
    }

    
    
    

    
}
    


