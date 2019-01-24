package controller;

//import dto.Athlete_dto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Singleton;
import model.Athlete;

@Singleton(mappedName="athleteFacade")
public class AthleteHandler extends AbstractEntityManager //implements Athlete_FacadeRemote 
{

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
    


