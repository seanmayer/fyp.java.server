package controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractEntityManager
{
     @PersistenceContext(unitName = "FYP.SCPSAA.EJB.ModulePU")
     public EntityManager em;
    
    public void persist(Object object) 
    {
        em.persist(object);
    }

}
