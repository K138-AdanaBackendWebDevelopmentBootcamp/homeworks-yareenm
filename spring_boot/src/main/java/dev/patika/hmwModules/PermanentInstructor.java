package dev.patika.hmwModules;

import javax.persistence.Entity;

// This class name is Permanent Instructor. It inherits from Instructor class.
// It is a sub class.
// e-mail: yareenm@outlook.com
@Entity
public class PermanentInstructor extends Instructor {
    private double fixedSalary;

    public PermanentInstructor(String name, String address, String phoneNumber, double salary){
        super(name,address,phoneNumber); //calling the super class constructor
        this.fixedSalary = salary;
    }

    public PermanentInstructor(double fixedSalary){
        this.fixedSalary = fixedSalary;
    }

    public PermanentInstructor() {

    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }
}
