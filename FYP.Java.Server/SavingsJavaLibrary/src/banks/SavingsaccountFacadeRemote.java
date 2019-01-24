/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banks;

import java.util.List;
import javax.ejb.Remote;
import utils.SavingsAccountDetails;

/**
 *
 * @author 2008s
 */
@Remote
public interface SavingsaccountFacadeRemote 
{
     public void createAccount(SavingsAccountDetails details);
     public void editAccount(SavingsAccountDetails details);
     public void removeAccount(Long id);
     public SavingsAccountDetails find(Object pk);
     public List<SavingsAccountDetails> findAll();
    
}
