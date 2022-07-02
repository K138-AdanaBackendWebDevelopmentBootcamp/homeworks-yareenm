package dev.patika.controller;

import dev.patika.hmwModules.Course;
import dev.patika.service.CourseService;

import java.util.List;

public class CourseController {
    private CourseService courseService = new CourseService();

    public List<Course> findAllCourses(){
        return courseService.findAll();
    }
    public Course findCourseById(int id){
        return courseService.findById(id);
    }
    public void saveCourse(Course course){
        courseService.saveToDb(course);
    }
}
