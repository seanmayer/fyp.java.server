package controller;
import dto.Power_dto;
import dto.Athlete_dto;
import dto.Power_dto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import model.Power;
import model.Athlete;
import model.Power;
import remote.Power_FacadeRemote;



@Stateless(mappedName="powerfacade")
public class PowerHandler extends AbstractEntityManager implements Power_FacadeRemote 
{

    private List<Power_dto> copyPowerStream(List<Power> powerstream)
    {
        List<Power_dto> powerList = new ArrayList<>();
        Iterator i = powerstream.iterator();
    
            while (i.hasNext())
            {
                Power c = (Power) i.next();
                Power_dto details = new Power_dto(c.getPowerId(),c.getDatapoint(),c.getSecondstamp());
                powerList.add(details);
            }
            
        return powerList;
    }

    @Override
    public Long createPower(Power_dto powerDetails) {
        
        try
        {
            Power power = new Power(powerDetails.getPowerId(),powerDetails.getDatapoint(),powerDetails.getSecondstamp());
            persistMany(power);
            em.flush();
            return power.getPowerId();
        }
        catch (Exception e)
        {
           return null;   
        }
        
    }

    @Override
    public void editPower(Power_dto activityDetails) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removePower(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Power_dto find(Object pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Power_dto findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Power_dto> findAll() {
       return copyPowerStream(em.createQuery("select object(o) from Power o ").getResultList());
    }
    
    

    
}
    


