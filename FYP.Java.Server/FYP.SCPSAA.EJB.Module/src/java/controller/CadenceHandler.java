/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.Cadence_dto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.Stateless;
import model.Cadence;
import remote.Cadence_FacadeRemote;

/**
 *
 * @author 2008s
 */
@Stateless(mappedName="cadencefacade")
public class CadenceHandler extends AbstractEntityManager implements Cadence_FacadeRemote
{

    private List<Cadence_dto> copyCadenceStream(List<Cadence> cadencestream)
    {
        List<Cadence_dto> cadenceList = new ArrayList<>();
        Iterator i = cadencestream.iterator();
    
            while (i.hasNext())
            {
                Cadence c = (Cadence) i.next();
                Cadence_dto details = new Cadence_dto(c.getCadenceId(),c.getDatapoint(),c.getSecondstamp());
                cadenceList.add(details);
            }
            
        return cadenceList;
    }
    
    @Override
    public Long createCadence(Cadence_dto cadenceDetails) {
      try
        {
            Cadence cadence = new Cadence(cadenceDetails.getCadenceId(),cadenceDetails.getDatapoint(),cadenceDetails.getSecondstamp());
            persistMany(cadence);
            em.flush();
            return cadence.getCadenceId();
        }
        catch (Exception e)
        {
           return null;   
        }
    }

    @Override
    public void editCadence(Cadence_dto cadenceDetails) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeCadence(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cadence_dto find(Object pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cadence_dto findById(Long id) {
        Cadence details = em.find(Cadence.class, id);
        return new Cadence_dto(details.getCadenceId(),details.getDatapoint(),details.getSecondstamp());
    }

    @Override
    public List<Cadence_dto> findAll() {
         return copyCadenceStream(em.createQuery("select object(o) from Cadence o ").getResultList());
    }
    
}
