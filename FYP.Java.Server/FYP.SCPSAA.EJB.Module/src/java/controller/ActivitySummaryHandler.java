package controller;

import dto.ActivitySummary_dto;
import dto.Activity_dto;
import dto.Athlete_dto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import model.Athlete;
import remote.ActivitySummary_FacadeRemote;



@Stateless(mappedName="activitysummaryfacade")
public class ActivitySummaryHandler extends AbstractEntityManager implements ActivitySummary_FacadeRemote 
{

    private List<Athlete_dto> copyAthletes(List<Athlete> athletes)
    {
        List<Athlete_dto> athleteList = new ArrayList<>();
        Iterator i = athletes.iterator();
    
            while (i.hasNext())
            {
                Athlete c = (Athlete) i.next();
                Athlete_dto details = new Athlete_dto(c.getAthleteId(),c.getStravaid(),c.getFirstname(),c.getLastname());
                athleteList.add(details);
            }
            
        return athleteList;
    }

    @Override
    public void createActivitySummary(ActivitySummary_dto activitySummaryDetails) {
//        
//        Long activitySummaryId, BigInteger movingTime, BigDecimal distance, BigDecimal maxSpeed, BigDecimal maxWatts, BigDecimal averageSpeed, BigDecimal averageWatts, BigDecimal averageCadence, BigDecimal kilojoules, Activity activityId
//        ActivitySummary activitySummary = new ActivitySummary(activitySummaryDetails.getCredentialsId(),activitySummaryDetails.getUsername(),activitySummaryDetails.getPassword());
//        em.persist(activitySummary);
        
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
    public Activity_dto find(Object pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Activity_dto findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Activity_dto> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    

    
}
    


