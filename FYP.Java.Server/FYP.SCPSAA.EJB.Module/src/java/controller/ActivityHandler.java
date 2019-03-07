package controller;
import dto.Activity_dto;
import dto.Athlete_dto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import model.Activity;
import model.Athlete;
import remote.Activity_FacadeRemote;



@Stateless(mappedName="activityfacade")
public class ActivityHandler extends AbstractEntityManager implements Activity_FacadeRemote 
{

    private List<Activity_dto> copyActivities(List<Activity> activities)
    {
        List<Activity_dto> activityList = new ArrayList<>();
        Iterator i = activities.iterator();
    
            while (i.hasNext())
            {
                Activity c = (Activity) i.next();
                Activity_dto details = new Activity_dto(c.getActivityId(),c.getStravaid(),c.getName(),c.getStartDate(),c.getTimeZone(),new Athlete_dto(c.getAthleteId().getAthleteId()));
                activityList.add(details);
            }
            
        return activityList;
    }

    @Override
    public void createActivity(Activity_dto activityDetails) {
        
        try
        {
            Athlete athlete = em.getReference(Athlete.class, activityDetails.getAthleteId().getAthleteId());
            Activity activity = new Activity(activityDetails.getActivityId(),activityDetails.getStravaid(), activityDetails.getName(), activityDetails.getStartDate(), activityDetails.getTimeZone(), athlete);
            persistMany(activity);
        }
        catch (Exception e)
        {
             
        }
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
       return copyActivities(em.createQuery("select object(o) from Activity o ").getResultList());
    }
    
    

    
}
    


