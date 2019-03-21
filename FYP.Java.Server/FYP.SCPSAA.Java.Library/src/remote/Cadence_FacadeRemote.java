/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remote;

import dto.Cadence_dto;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author 2008s
 */
@Remote
public interface Cadence_FacadeRemote 
{
     public Long createCadence(Cadence_dto cadenceDetails);
     public void editCadence(Cadence_dto cadenceDetails);
     public void removeCadence(Long id);
     public Cadence_dto find(Object pk);
     public Cadence_dto findById(Long id);
     public List<Cadence_dto> findAll();
}
