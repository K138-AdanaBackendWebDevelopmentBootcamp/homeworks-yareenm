package dev.patika.hmwModules;

import lombok.*;

import javax.persistence.Entity;

// This class name is Visiting Researcher. It inherits from Instructor class.
// It is a sub class.
// e-mail: yareenm@outlook.com
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitingResearcher extends Instructor{
    @Getter @Setter
    private double hourlySalary;

    public VisitingResearcher(String name, String address, String phoneNumber, double salary){
        super(name,address,phoneNumber);
        this.hourlySalary = salary;
    }

}
