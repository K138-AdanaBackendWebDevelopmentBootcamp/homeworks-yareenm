package dev.patika.controller;

import dev.patika.hmwModules.Student;
import dev.patika.service.StudentService;

import java.util.List;

public class StudentController {

    private StudentService studentService = new StudentService();

    public List<Student> findAllStudent(){
        return studentService.findAll();
    }

    public Student findStudentById(int id){
        return studentService.findById(id);
    }

    public void saveStudent(Student student){
        studentService.saveToDb(student);
    }
}
