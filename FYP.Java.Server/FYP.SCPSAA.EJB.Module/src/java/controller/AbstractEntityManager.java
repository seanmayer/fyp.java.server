package controller;

import java.util.Iterator;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;


public abstract class AbstractEntityManager<T>
{
     @PersistenceContext(unitName = "FYP.SCPSAA.EJB.ModulePU")
     public EntityManager em;
    
    public void persist(Object object) 
    {
        em.persist(object);
    }
    
    public void persistMany(T entity) 
    {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(entity);
        if(constraintViolations.size() > 0)
        {
            Iterator<ConstraintViolation<T>> iterator = constraintViolations.iterator();
            while(iterator.hasNext())
            {
                ConstraintViolation<T> cv = iterator.next();
            }
        }
        else
        {
            em.persist(entity);
        }
    }

}
