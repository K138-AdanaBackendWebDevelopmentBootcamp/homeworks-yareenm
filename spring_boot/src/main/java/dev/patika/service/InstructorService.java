package dev.patika.service;

import dev.patika.repository.CrudRepository;
import dev.patika.hmwModules.Instructor;
import dev.patika.utils.EntityManagerUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class InstructorService implements CrudRepository<Instructor> {

    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
    @Override
    public List<Instructor> findAll() {
        List<Instructor> instructorList = em.createQuery("SELECT s FROM Instructor s", Instructor.class).getResultList();
        return instructorList;
    }

    @Override
    public Instructor findById(int id) {
        return em.find(Instructor.class,id);
    }

    @Override
    public void saveToDb(Instructor instructor) {
        try {
            em.getTransaction().begin();
            em.persist(instructor);
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
            Instructor instructor = em.find(Instructor.class,id);
            em.remove(instructor);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally {
            //EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void updateOnDb(Instructor instructor, int id) {
        try {
            em.getTransaction().begin();
            em.merge(instructor);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally {
            //EntityManagerUtils.closeEntityManager(em);
        }
    }
}
