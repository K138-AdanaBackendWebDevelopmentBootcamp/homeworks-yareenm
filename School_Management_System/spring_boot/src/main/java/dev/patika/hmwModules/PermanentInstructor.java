package dev.patika.hmwModules;

import lombok.*;

import javax.persistence.Entity;

// This class name is Permanent Instructor. It inherits from Instructor class.
// It is a sub class.
// e-mail: yareenm@outlook.com
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermanentInstructor extends Instructor {
    @Getter @Setter
    private double fixedSalary;

    public PermanentInstructor(String name, String address, String phoneNumber, double salary){
        super(name,address,phoneNumber); //calling the super class constructor
        this.fixedSalary = salary;
    }

}
