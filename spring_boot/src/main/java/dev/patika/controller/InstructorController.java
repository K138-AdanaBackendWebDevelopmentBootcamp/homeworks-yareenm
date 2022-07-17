package dev.patika.controller;

import dev.patika.hmwModules.Instructor;
import dev.patika.service.InstructorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

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
}
