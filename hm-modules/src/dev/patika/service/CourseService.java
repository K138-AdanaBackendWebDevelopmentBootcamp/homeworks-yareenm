package dev.patika.service;

import dev.patika.hmwModules.Course;
import dev.patika.repository.CrudRepository;
import dev.patika.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class CourseService implements CrudRepository<Course> {
    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
    @Override
    public List<Course> findAll() {
        List<Course> courseList = em.createQuery("SELECT s FROM Course s", Course.class).getResultList();
        return courseList;
    }

    @Override
    public Course findById(int id) {
        return em.find(Course.class,id);
    }

    @Override
    public void saveToDb(Course course) {
        try {
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally {
            //EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void deleteFromDb(int id) {

    }

    @Override
    public void updateOnDb(Course object, int id) {

    }
}
