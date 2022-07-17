package dev.patika.hmwModules;

import javax.persistence.*;
import java.util.Objects;

// Class name is Course. It has 3 attributes; related course name, course code and credit score.
// e-mail: yareenm@outlook.com
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String courseCode;
    private String courseName;
    private int creditScore;

    @ManyToOne(fetch = FetchType.LAZY)
    private Instructor instructor;// = new Instructor();

    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;// = new Student();

    public Course(String courseName, String courseCode, int creditScore){
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditScore = creditScore;
    }//constructor

    public Course(){

    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return creditScore == course.creditScore && Objects.equals(courseName, course.courseName) && Objects.equals(courseCode, course.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, courseCode, creditScore);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", creditScore=" + creditScore +
                '}';
    }

}
