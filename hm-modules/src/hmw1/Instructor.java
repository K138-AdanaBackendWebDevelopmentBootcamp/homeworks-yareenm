package hmw1;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// Class name is Instructor. It has 3 attributes; related person's name, address, and phone number.
// I used inheritance here, this class is a super class.
// e-mail: yareenm@outlook.com
public class Instructor {
    private String name;
    private String address;
    private String phoneNumber;

    private List<Course> courseList = new ArrayList<>();
    public Instructor(String name, String address, String phoneNumber){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Instructor() {
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
