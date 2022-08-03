package dev.patika.hmwModules;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Class name is Student. It has 4 attributes; related person's name, birth date, address, and gender.
// e-mail: yareenm@outlook.com
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Student {
    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String birthDate;
    @Getter @Setter
    private String address;
    @Getter @Setter
    private String gender;
    @Getter @Setter
    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    private List<Course> courseList = new ArrayList<>();

    public Student(String name, String birthDate, String address, String gender){
        this.name = name;
        this. birthDate = birthDate;
        this.address = address;
        this.gender = gender;
    }
}
