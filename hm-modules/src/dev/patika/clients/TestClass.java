package dev.patika.clients;

import dev.patika.controller.CourseController;
import dev.patika.controller.InstructorController;
import dev.patika.controller.StudentController;
import dev.patika.hmwModules.*;
import dev.patika.utils.EntityManagerUtils;
import javax.persistence.EntityManager;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
        
        if (checkTestData() == 0){
            saveTestData();
        }
        InstructorController instructorController = new InstructorController();
        StudentController studentController = new StudentController();
        CourseController courseController = new CourseController();

        Student newStudent = new Student("Ceren","June","Mersin","Female");
        Instructor newInstructor = new PermanentInstructor("Nizami","Adana","863",9000);
        Course newCourse = new Course("FinalProject","BIL545",10);

        List<Student> studentList = studentController.findAllStudent();
        List<Instructor> instructorList =instructorController.findAllInstructors();
        List<Course> courseList =courseController.findAllCourses();

        //save to Db function's test
        studentController.saveStudent(newStudent);
        instructorController.saveInstructor(newInstructor);
        courseController.saveCourse(newCourse);

        //find all function's test
         for (Student student : studentList) {
             System.out.println(student);
         }

      //for (Instructor instructor : instructorList) {
      //    System.out.println(instructor);
      //}

      //for (Course course : courseList) {
      //    System.out.println(course);
      //}

        //find by Id function's test
      //System.out.println(instructorController.findInstructorById(1));
      //System.out.println(studentController.findStudentById(1));



    }

    private static int checkTestData() {
        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");
        return em.createQuery("FROM Student",Student.class).getResultList().size();
    }

    private static void saveTestData() {

        Student student1 = new Student("Yaren","January","Ankara","Female");
        Student student2 = new Student("Zeynep","March","Istanbul","Female");
        Student student3 = new Student("Cem","April","Miami","Male");
        Student student4 = new Student("Dogukan","June","Izmir","Male");

        Instructor v_researcher1 = new VisitingResearcher("Tulin","Ankara","553",5000);
        Instructor v_researcher2 = new VisitingResearcher("Buket","Istanbul","642",4000);
        Instructor v_researcher3 = new VisitingResearcher("Koray","New York","373",6000);
        Instructor p_instructor1 = new PermanentInstructor("Mehmet","Diyabakir","646",2500);

        Course course1 = new Course("Network","BIL462",6);
        Course course2 = new Course("OOP","BIL383",9);
        Course course3 = new Course("Python","BIL285",5);
        Course course4 = new Course("AI","BIL466",6);
        Course course5 = new Course("ML","BIL646",8);

        //Course could be instructed by only one instructor.
        //Every identified course instructed by only one instructor.
        course1.setInstructor(v_researcher1);
        course2.setInstructor(p_instructor1);
        course3.setInstructor(v_researcher3);
        course4.setInstructor(v_researcher1);
        course5.setInstructor(v_researcher2);

        //Instructor could instruct at least one or more courses.
        //In this case, v_researcher1 instruct two courses which it is more than one.
        //Also, every identified instructor has at least one course to instruct.

        v_researcher1.getCourseList().add(course1);
        v_researcher1.getCourseList().add(course4);
        v_researcher2.getCourseList().add(course5);
        v_researcher3.getCourseList().add(course3);
        p_instructor1.getCourseList().add(course5);

        //Student could take zero or more courses.
        //In this case, student2 took zero courses. Other students took one or more courses.

        student1.getCourseList().add(course1);
        student1.getCourseList().add(course4);
        student1.getCourseList().add(course3);
        student3.getCourseList().add(course2);
        student4.getCourseList().add(course1);
        student4.getCourseList().add(course2);

        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            em.getTransaction().begin(); //begin the transaction

            em.persist(course1);
            em.persist(course2);
            em.persist(course3);
            em.persist(course4);
            em.persist(course5);

            em.persist(v_researcher1);
            em.persist(v_researcher2);
            em.persist(v_researcher3);
            em.persist(p_instructor1);

            em.persist(student1);
            em.persist(student2);
            em.persist(student3);
            em.persist(student4);


            em.getTransaction().commit(); //save in database

            System.out.println("All data persisted...");

        } catch (Exception e) {
            em.getTransaction().rollback();//Undoes what it has done so far
        }finally {
            EntityManagerUtils.closeEntityManager(em);
        }// this finally block will work no matter what happens above.


    }//This is the data part.
}
