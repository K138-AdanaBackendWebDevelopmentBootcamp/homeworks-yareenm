package dev.patika.hmwModules;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

// Class name is Course. It has 3 attributes; related course name, course code and credit score.
// e-mail: yareenm@outlook.com
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Course {
    @Getter @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Getter @Setter
    private String courseCode;
    @Getter @Setter
    private String courseName;
    @Getter @Setter
    private int creditScore;
    @Getter
    @ManyToOne(fetch = FetchType.LAZY)
    private Instructor instructor;// = new Instructor();
    @Getter @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;// = new Student();

    public Course(String courseName, String courseCode, int creditScore){
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditScore = creditScore;
    }//constructor

}
