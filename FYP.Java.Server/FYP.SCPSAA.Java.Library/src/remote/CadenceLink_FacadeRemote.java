/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remote;

import dto.CadenceLink_dto;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author 2008s
 */
@Remote
public interface CadenceLink_FacadeRemote 
{
     public Long createCadenceLink(CadenceLink_dto cadenceLinkDetails);
     public void editCadenceLink(CadenceLink_dto cadenceLinkDetails);
     public void removeCadenceLink(Long id);
     public CadenceLink_dto find(Object pk);
     public CadenceLink_dto findById(Long id);
     public List<CadenceLink_dto> findAll();
}
