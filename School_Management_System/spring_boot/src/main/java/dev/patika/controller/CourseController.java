package dev.patika.controller;

import dev.patika.hmwModules.Course;
import dev.patika.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private CourseService courseService = new CourseService();

    @RequestMapping(value = "/getcourses")
    public ResponseEntity<List<Course>> getCourse(@PathVariable(required = false) int id){
        return ResponseEntity.ok().body(courseService.findAll());
    }
    @RequestMapping("/getcourses/{id}")
    public ResponseEntity<Course> getCourseWID(@PathVariable(required = false) int id){
        return ResponseEntity.ok().body(courseService.findById(id));
    }
    @PostMapping(value = "/postcourse")
    public ResponseEntity<List<Course>> addCourse(@RequestBody Course course){
        courseService.saveToDb(course);
        return ResponseEntity.ok().body(courseService.findAll());
    }
    @PutMapping("/putcourse/{id}")
    public ResponseEntity<List<Course>>updateCourse(@RequestBody Course course, @PathVariable int id){
        courseService.updateOnDb(course,id);
        return ResponseEntity.ok().body(courseService.findAll());
    }
    @DeleteMapping("/deletecourse/{id}")
    public ResponseEntity<List<Course>>deleteCourse(@PathVariable int id){
        courseService.deleteFromDb(id);
        return ResponseEntity.ok().body(courseService.findAll());
    }
    @GetMapping("/getcourse")
    public ResponseEntity<Course> getCourseWName(@RequestParam String name){
        int id = courseService.findIdByName(name);
        return ResponseEntity.ok().body(courseService.findById(id));
    }
    @DeleteMapping("/deletecourse/{name}")
    public ResponseEntity<List<Course>> deleteCourseWName(@PathVariable String name){
        int id = courseService.findIdByName(name);
        courseService.deleteFromDb(id);
        return ResponseEntity.ok().body(courseService.findAll());
    }
}
