package dev.patika.controller;

import dev.patika.hmwModules.Instructor;
import dev.patika.service.InstructorService;


import java.util.List;

public class InstructorController {
    private InstructorService instructorService = new InstructorService();

    public List<Instructor> findAllInstructors(){
        return instructorService.findAll();
    }
    public Instructor findInstructorById(int id){
        return instructorService.findById(id);
    }
    public void saveInstructor(Instructor instructor){
        instructorService.saveToDb(instructor);
    }
}
