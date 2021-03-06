/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remote;

import dto.Athlete_dto;
import dto.Credentials_dto;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface Athlete_FacadeRemote 
{
     public void createCredendentedAthlete(Credentials_dto credentialDetails, Athlete_dto athleteDetails);
     public void editAthlete(Athlete_dto details);
     public void removeAthlete(Long id);
     public Athlete_dto find(Object pk);
     public Athlete_dto findById(Long id);
     public List<Athlete_dto> findAll();
}
