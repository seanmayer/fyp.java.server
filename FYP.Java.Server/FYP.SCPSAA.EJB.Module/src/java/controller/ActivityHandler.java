package controller;

import dto.ActivitySummary_dto;
import dto.Activity_dto;
import remote.Athlete_FacadeRemote;
import dto.Athlete_dto;
import dto.Credentials_dto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import model.Activity;
import model.ActivitySummary;
import model.Athlete;
import model.Credentials;
import remote.Activity_FacadeRemote;



@Stateless(mappedName="activityfacade")
public class ActivityHandler extends AbstractEntityManager implements Activity_FacadeRemote 
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
    public void createActivity(Athlete_dto athleteDetails, Activity_dto activityDetails) {
//        try
//        {
//            Athlete athlete = em.getReference(Athlete.class, athleteDetails.getAthleteId());
//            Activity activity = new Activity(activityDetails.getActivityId(),
//                    activityDetails.getStravaid(), 
//                    activityDetails.getName(), 
//                    activityDetails.getStartDate(), 
//                    activityDetails.getTimeZone(), 
//                    athlete);
//            
//            em.persist(activity);
//
//        }
//        catch (Exception ex)
//        {
//            throw new EJBException(ex);
//        }
    }

    @Override
    public void editActivity(Athlete_dto details, Activity_dto activityDetails) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeActivity(Long id) {
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
    


