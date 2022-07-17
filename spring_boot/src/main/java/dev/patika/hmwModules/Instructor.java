package dev.patika.hmwModules;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Class name is Instructor. It has 3 attributes; related person's name, address, and phone number.
// I used inheritance here, this class is a super class.
// e-mail: yareenm@outlook.com
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String phoneNumber;

    @OneToMany(mappedBy = "instructor", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Course> courseList = new ArrayList<>();
    public Instructor(String name, String address, String phoneNumber){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Instructor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Course> getCourseList() {
        return courseList;
    }
    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, address, phoneNumber);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instructor that = (Instructor) o;
        return Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
