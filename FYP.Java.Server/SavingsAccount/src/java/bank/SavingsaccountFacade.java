/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import banks.SavingsaccountFacadeRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import utils.SavingsAccountDetails;

/**
 *The session bean will handle access between clients and the information in the entity class.
 * @author 2008s
 */
@Stateless (mappedName="savingsaccountfacade")
public class SavingsaccountFacade implements SavingsaccountFacadeRemote 
{

    @PersistenceContext(unitName = "SavingsAccountPU")
    private EntityManager em;

    public void persist(Object object) {
        em.persist(object);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    
    //collections of SavingsAccount objects //serialized - so that it can be sent over the network to clients
private List<SavingsAccountDetails> copyAccountsToDetails(List<Savingsaccount> accounts)
{
    List<SavingsAccountDetails> accountList = new ArrayList<>();
    Iterator i = accounts.iterator();

    while(i.hasNext())
    {
        Savingsaccount acct = (Savingsaccount) i.next();
        SavingsAccountDetails details = new SavingsAccountDetails(acct.getId(),acct.getFirstname(), acct.getLastname(), acct.getBalance());
        accountList.add(details);
    }

    return accountList;
}
    
@Override
public void createAccount(SavingsAccountDetails details)
{
    try
    {
        Savingsaccount acct = new Savingsaccount(details.getId(), details.getFirstname(), details.getLastname(), details.getBalance());
        em.persist(acct);
    }
    catch (Exception ex)
    {
    throw new EJBException(ex);
    }
 }
    
@Override
public void editAccount(SavingsAccountDetails details)
{
    try
    {
        Savingsaccount acct = new Savingsaccount(details.getId(), details.getFirstname(),
        details.getLastname(), details.getBalance());
        em.merge(acct);
    }
    catch (Exception ex)
    {
        throw new EJBException(ex);
    }
}
    
@Override    
public void removeAccount(Long id)
{
    try
    {
        Savingsaccount a = em.find(Savingsaccount.class, id);
        em.remove(a);
    }
    catch (Exception ex)
    {
        throw new EJBException(ex);
    }
}

@Override
public SavingsAccountDetails find(Object pk)
{
    Savingsaccount acct= em.find(Savingsaccount.class, pk);
    return new SavingsAccountDetails(acct.getId(),acct.getFirstname(), acct.getLastname(), acct.getBalance());
}

@Override
public List<SavingsAccountDetails> findAll()
{
    return copyAccountsToDetails(em.createQuery("select object(o) from Savingsaccount as o order by o.id").getResultList());
}


}