/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.Activity_dto;
import dto.SpeedLink_dto;
import dto.Speed_dto;
import static java.lang.Long.parseLong;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import model.Activity;
import model.Speed;
import model.SpeedLink;
import remote.SpeedLink_FacadeRemote;

/**
 *
 * @author 2008s
 */
@Stateless(mappedName="speedlinkfacade")
public class SpeedLinkHandler extends AbstractEntityManager implements SpeedLink_FacadeRemote{
    
    private List<SpeedLink_dto> copySpeedLinkStream(List<SpeedLink> speedstream)
    {
        List<SpeedLink_dto> speedLinkList = new ArrayList<>();
        Iterator i = speedstream.iterator();
    
            while (i.hasNext())
            {
                SpeedLink c = (SpeedLink) i.next();
                SpeedLink_dto details = new SpeedLink_dto(c.getSpeedLinkId(),
                        new Activity_dto(c.getActivityId().getActivityId()),
                        new Speed_dto(c.getSpeedId().getSpeedId()));
                speedLinkList.add(details);
            }
            
        return speedLinkList;
    }
    
    @Override
    public Long createSpeedLink(SpeedLink_dto speedDetails) {
     try
        {
            Activity activity = em.getReference(Activity.class, speedDetails.getActivityId().getActivityId());
            Speed speed = em.getReference(Speed.class, speedDetails.getSpeedId().getSpeedId());
            SpeedLink speedLink = new SpeedLink(parseLong("1"),activity,speed);
            persistMany(speedLink);
            em.flush();
            return speedLink.getSpeedLinkId();
        }
        catch (Exception e)
        {
           return null;   
        }
    }

    @Override
    public void editSpeedLink(SpeedLink_dto speedLinkDetails) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeSpeedLink(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SpeedLink_dto find(Object pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SpeedLink_dto findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SpeedLink_dto> findAll() {
        return copySpeedLinkStream(em.createQuery("select object(o) from SpeedLink o ").getResultList());
    }
}
