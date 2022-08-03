package dev.patika.service;

import dev.patika.hmwModules.Course;
import dev.patika.hmwModules.Student;
import dev.patika.repository.CrudRepository;
import dev.patika.utils.EntityManagerUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class StudentService implements CrudRepository <Student>{

    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
    @Override
    public List<Student> findAll() {
        List<Student> studentList = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        return studentList;
    }

    @Override
    public Student findById(int id) {
        return em.find(Student.class,id);
    }

    @Override
    public void saveToDb(Student student) {
        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally {
            //EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void deleteFromDb(int id) {
        try {
            em.getTransaction().begin();
            Student student = em.find(Student.class,id);
            em.remove(student);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally {
            //EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void updateOnDb(Student student, int id) {
        try {
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally {
            //EntityManagerUtils.closeEntityManager(em);
        }
    }
    @Override
    public int findIdByName(String name) {
        Student student = em.find(Student.class,name);
        return student.getId();
    }
}
