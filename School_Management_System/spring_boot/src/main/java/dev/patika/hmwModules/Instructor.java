package dev.patika.hmwModules;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Class name is Instructor. It has 3 attributes; related person's name, address, and phone number.
// I used inheritance here, this class is a super class.
// e-mail: yareenm@outlook.com
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Instructor {
    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String address;
    @Getter @Setter
    private String phoneNumber;
    @Getter @Setter
    @OneToMany(mappedBy = "instructor", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Course> courseList = new ArrayList<>();
    public Instructor(String name, String address, String phoneNumber){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

}
