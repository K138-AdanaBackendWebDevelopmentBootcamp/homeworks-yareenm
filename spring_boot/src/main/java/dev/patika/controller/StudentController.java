package dev.patika.controller;

import dev.patika.hmwModules.Student;
import dev.patika.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private List<Student> studentlist = new ArrayList<Student>();
    private StudentService studentService = new StudentService();

    @GetMapping(value = "/getstudents")
    public ResponseEntity<List<Student>> getStudent(){
        Student student  = new Student("A","B","C","D");
        studentlist.add(student);
        return ResponseEntity.ok().body(studentlist);
    }
    //public ResponseEntity<List<Student>> getStudent(){
  //    return ResponseEntity.ok().body(studentService.findAll());
  //}
    @GetMapping(value = "/getstudent/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable(required = false) int id){
        return ResponseEntity.ok().body(studentService.findById(id));
    }
    @PostMapping(value = "/poststudent")
    public ResponseEntity<List<Student>> addStudent(@RequestBody Student student){
        studentService.saveToDb(student);
        return ResponseEntity.ok().body(studentService.findAll());
    }
    @PutMapping("/putstudent/{id}")
    public ResponseEntity<List<Student>>updateStudent(@RequestBody Student student, @PathVariable int id){
        studentService.updateOnDb(student,id);
        return ResponseEntity.ok().body(studentService.findAll());
    }
    @DeleteMapping("/deletestudent/{id}")
    public ResponseEntity<List<Student>>deleteStudent(@PathVariable int id){
        studentService.deleteFromDb(id);
        return ResponseEntity.ok().body(studentService.findAll());
    }
}