package controller;
import dto.Activity_dto;
import dto.PowerLink_dto;
import dto.Power_dto;
import static java.lang.Long.parseLong;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import model.Activity;
import model.Power;
import model.PowerLink;
import remote.PowerLink_FacadeRemote;



@Stateless(mappedName="powerlinkfacade")
public class PowerLinkHandler extends AbstractEntityManager implements PowerLink_FacadeRemote 
{

    private List<PowerLink_dto> copyPowerLinkStream(List<PowerLink> powerstream)
    {
        List<PowerLink_dto> powerList = new ArrayList<>();
        Iterator i = powerstream.iterator();
    
            while (i.hasNext())
            {
                PowerLink c = (PowerLink) i.next();
                PowerLink_dto details = new PowerLink_dto(c.getPowerLinkId(),new Activity_dto(c.getActivityId().getActivityId()),new Power_dto(c.getPowerId().getPowerId()));
                powerList.add(details);
            }
            
        return powerList;
    }

    @Override
    public void createPowerLink(PowerLink_dto powerDetails) {
        
        try
        {
            Activity activity = em.getReference(Activity.class, powerDetails.getActivityId().getActivityId());
            Power power = em.getReference(Power.class, powerDetails.getPowerId().getPowerId());
            
            PowerLink powerLink = new PowerLink(parseLong("1"),activity,power);
            
            persistMany(powerLink);
        }
        catch (Exception e)
        {
             System.out.println(e);
        }
    }

    @Override
    public void editPowerLink(PowerLink_dto activityDetails) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removePowerLink(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PowerLink_dto find(Object pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PowerLink_dto findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PowerLink_dto> findAll() {
       return copyPowerLinkStream(em.createQuery("select object(o) from PowerLink o ").getResultList());
    }
    
    

    
}
    


