package controller;

import remote.Athlete_FacadeRemote;
import dto.Athlete_dto;
import dto.Credentials_dto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import model.Athlete;
import model.Credentials;



@Stateless(mappedName="athletefacade")
public class AthleteHandler extends AbstractEntityManager implements Athlete_FacadeRemote 
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
    public void createCredendentedAthlete(Credentials_dto credentialsDetails, Athlete_dto athleteDetails) {
        try
        {
            Credentials credentials = em.getReference(Credentials.class, credentialsDetails.getCredentialsId());
            Athlete athlete = new Athlete(athleteDetails.getAthleteId(),athleteDetails.getStravaid(),athleteDetails.getFirstname(),athleteDetails.getLastname(), credentials);
            
            em.persist(athlete);

        }
        catch (Exception ex)
        {
            throw new EJBException(ex);
        }
    }

    @Override
    public void editAthlete(Athlete_dto details) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeAthlete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Athlete_dto find(Object pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Athlete_dto findById(Long id) {
         Athlete details = em.find(Athlete.class, id);
        return new Athlete_dto(details.getAthleteId(), details.getStravaid(), details.getFirstname(), details.getLastname());
    }

    @Override
    public List<Athlete_dto> findAll() {
        return copyAthletes(em.createQuery("select object(o) from Athlete o ").getResultList());
    }

}
    


