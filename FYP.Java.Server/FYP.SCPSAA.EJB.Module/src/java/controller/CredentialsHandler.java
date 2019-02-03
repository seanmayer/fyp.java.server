package controller;

import remote.Credentials_FacadeRemote;
import dto.Credentials_dto;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import model.Credentials;



@Stateless(mappedName="credentialsfacade")
public class CredentialsHandler extends AbstractEntityManager implements Credentials_FacadeRemote 
{

    @Override
    public void createCredentials(Credentials_dto details) {
        try
        {
            
            Credentials credentials = new Credentials(details.getCredentialsId(),details.getUsername(),details.getPassword());
            em.persist(credentials);

        }
        catch (Exception ex)
        {
            throw new EJBException(ex);
        }
    }

    @Override
    public void editCredentials(Credentials_dto details) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeCredentials(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Credentials_dto find(Object pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Credentials_dto findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Credentials_dto> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    private List<Student_dto> copyStudent(List<Student_> students)
//    {
//        List<Student_dto> studentList = new ArrayList<>();
//        Iterator i = students.iterator();
//    
//            while (i.hasNext())
//            {
//                Student_ student = (Student_) i.next();
//                Student_dto details = new Student_dto(student.getStudentId(),student.getName(),student.getCreationDate());
//                studentList.add(details);
//            }
//            
//        return studentList;
//    }
//    
//    @Override
//    public void createStudent(Student_dto details)
//    {
//        try
//        {
//            
//            Student_ student = new Student_(details.getStudentId(),details.getName(),details.getCreationDate());
//            em.persist(student);
//
//        }
//        catch (Exception ex)
//        {
//            throw new EJBException(ex);
//        }
//    }
//    @Override
//    public void editStudent(Student_dto details)
//    {
//        try
//        {
//            Student_ student = new Student_(details.getStudentId(),details.getName(),details.getCreationDate());
//            em.merge(student);
//        }
//        catch (Exception ex)
//        {
//        throw new EJBException(ex);
//        }
//    }
//    
//    @Override
//    public void removeStudent(Long id)
//    {
//        try
//        {
//            Student_ s = em.find(Student_.class, id);
//            em.remove(s);
//        }
//        catch (Exception ex)
//        {
//            throw new EJBException(ex);
//        }
//    }
//    
//    @Override
//    public Student_dto findById(Long id) 
//    {
//        Student_ details = em.find(Student_.class, id);
//        return new Student_dto(details.getStudentId(), details.getName(), details.getCreationDate());
//
//    }
//    
//    @Override
//    public Student_dto find(Object pk)
//    {
//        Student_ details= em.find(Student_.class, pk);
//        return new Student_dto(details.getStudentId(), details.getName(),details.getCreationDate());
//    }
//    
//    @Override
//    public List<Student_dto> findAll()
//    {
//        return copyStudent(em.createQuery("select object(o) from Student_ as o order by o.name").getResultList());
//    }



    
}
    


