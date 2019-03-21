/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.Speed_dto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import model.Speed;
import remote.Speed_FacadeRemote;

/**
 *
 * @author 2008s
 */
@Stateless(mappedName="speedfacade")
public class SpeedHandler extends AbstractEntityManager implements Speed_FacadeRemote 
{
    private List<Speed_dto> copySpeedStream(List<Speed> speedstream)
    {
        List<Speed_dto> speedList = new ArrayList<>();
        Iterator i = speedstream.iterator();
    
            while (i.hasNext())
            {
                Speed c = (Speed) i.next();
                Speed_dto details = new Speed_dto(c.getSpeedId(),c.getDatapoint(),c.getSecondstamp());
                speedList.add(details);
            }
            
        return speedList;
    }
    
    @Override
    public Long createSpeed(Speed_dto speedDetails) {
     try
        {
            Speed speed = new Speed(speedDetails.getSpeedId(),speedDetails.getDatapoint(),speedDetails.getSecondstamp());
            persistMany(speed);
            em.flush();
            return speed.getSpeedId();
        }
        catch (Exception e)
        {
           return null;   
        }
    }

    @Override
    public void editSpeed(Speed_dto speedDetails) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeSpeed(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Speed_dto find(Object pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Speed_dto findById(Long id) {
        Speed details = em.find(Speed.class, id);
        return new Speed_dto(details.getSpeedId(),details.getDatapoint(),details.getSecondstamp());
    }

    @Override
    public List<Speed_dto> findAll() {
        return copySpeedStream(em.createQuery("select object(o) from Speed o ").getResultList());
    }
    
}
