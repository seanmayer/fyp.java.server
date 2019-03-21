/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.Activity_dto;
import dto.CadenceLink_dto;
import dto.Cadence_dto;
import static java.lang.Long.parseLong;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import model.Activity;
import model.Cadence;
import model.CadenceLink;
import remote.CadenceLink_FacadeRemote;

/**
 *
 * @author 2008s
 */
@Stateless(mappedName="cadencelinkfacade")
public class CadenceLinkHandler extends AbstractEntityManager implements CadenceLink_FacadeRemote{

    private List<CadenceLink_dto> copyCadenceLinkStream(List<CadenceLink> cadencestream)
    {
        List<CadenceLink_dto> speedLinkList = new ArrayList<>();
        Iterator i = cadencestream.iterator();
    
            while (i.hasNext())
            {
                CadenceLink c = (CadenceLink) i.next();
                CadenceLink_dto details = new CadenceLink_dto(c.getCadenceLinkId(),
                        new Activity_dto(c.getActivityId().getActivityId()),
                        new Cadence_dto(c.getCadenceId().getCadenceId()));
                speedLinkList.add(details);
            }
            
        return speedLinkList;
    }
    
    
    @Override
    public Long createCadenceLink(CadenceLink_dto cadenceLinkDetails) {
        try
        {
            Activity activity = em.getReference(Activity.class, cadenceLinkDetails.getActivityId().getActivityId());
            Cadence cadence = em.getReference(Cadence.class, cadenceLinkDetails.getCadenceId().getCadenceId());
            CadenceLink cadenceLink = new CadenceLink(parseLong("1"),activity,cadence);
            persistMany(cadenceLink);
            em.flush();
            return cadenceLink.getCadenceLinkId();
        }
        catch (Exception e)
        {
           return null;   
        }
    }

    @Override
    public void editCadenceLink(CadenceLink_dto cadenceLinkDetails) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeCadenceLink(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CadenceLink_dto find(Object pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CadenceLink_dto findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CadenceLink_dto> findAll() {
        return copyCadenceLinkStream(em.createQuery("select object(o) from CadenceLink o ").getResultList());
    }
    
}
