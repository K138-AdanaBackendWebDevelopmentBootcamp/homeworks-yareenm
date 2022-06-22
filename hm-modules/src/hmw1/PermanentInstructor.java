package hmw1;

public class PermanentInstructor extends Instructor {
    private double fixedSalary;

    public PermanentInstructor(String name, String address, String phoneNumber, double salary){
        super(name,address,phoneNumber);
        this.fixedSalary = salary;
    }

    public PermanentInstructor(double fixedSalary){
        this.fixedSalary = fixedSalary;
    }

    public double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }
}
