package dev.patika.controller;

import dev.patika.hmwModules.Course;
import dev.patika.hmwModules.Instructor;
import dev.patika.service.InstructorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@RequestMapping("/instructors")
public class InstructorController {
    private InstructorService instService = new InstructorService();

    @GetMapping(value = "/getinstructors")
    public ResponseEntity<List<Instructor>> getInstructor(){
        return ResponseEntity.ok().body(instService.findAll());
    }
    @GetMapping("/getinstructors/{id}")
    public ResponseEntity<Instructor> getInstructorWID(@PathVariable(required = false) int id){
        return ResponseEntity.ok().body(instService.findById(id));
    }
    @PostMapping(value = "/postinstructor")
    public ResponseEntity<List<Instructor>> addInstructor(@RequestBody Instructor instructor){
        instService.saveToDb(instructor);
        return ResponseEntity.ok().body(instService.findAll());
    }
    @PutMapping(value = "/putinstructor/{id}")
    public ResponseEntity<List<Instructor>>updateInstructor(@RequestBody Instructor instructor,@PathVariable int id){
        instService.updateOnDb(instructor,id);
        return ResponseEntity.ok().body(instService.findAll());
    }
    @DeleteMapping("/deleteinstructor/{id}")
    public ResponseEntity<List<Instructor>>deleteInstructor(@PathVariable int id){
        instService.deleteFromDb(id);
        return ResponseEntity.ok().body(instService.findAll());
    }
    @GetMapping("/getinstructor")
    public ResponseEntity<Instructor> getInstructorWName(@RequestParam String name){
        int id = instService.findIdByName(name);
        return ResponseEntity.ok().body(instService.findById(id));
    }
    @DeleteMapping("/deleteinstructor/{name}")
    public ResponseEntity<List<Instructor>> deleteInstructorWName(@PathVariable String name){
        int id = instService.findIdByName(name);
        instService.deleteFromDb(id);
        return ResponseEntity.ok().body(instService.findAll());
    }
    @GetMapping("/getinstructor/{choice}")
    public ResponseEntity<List<Instructor>> getInstructorOfChoice(@PathVariable String choice){
        if(choice.equals("y")){

            List<Instructor> maxList = new ArrayList<>();
            maxList = instService.findThreeMax();
            return ResponseEntity.ok().body(maxList);
        }
        else if (choice.equals("d")) {
            List<Instructor> minList = new ArrayList<>();
            minList = instService.findThreeMin();
            return ResponseEntity.ok().body(minList);
        }
        else{
            return ResponseEntity.ok().body(instService.findAll());
        }
    }
}
