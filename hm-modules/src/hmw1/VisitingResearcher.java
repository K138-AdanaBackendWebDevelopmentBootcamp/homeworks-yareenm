package hmw1;

// This class name is Visiting Researcher. It inherits from Instructor class.
// It is a sub class.
// e-mail: yareenm@outlook.com
public class VisitingResearcher extends Instructor{
    private double hourlySalary;

    public VisitingResearcher(String name, String address, String phoneNumber, double salary){
        super(name,address,phoneNumber);
        this.hourlySalary = salary;
    }

    public VisitingResearcher(double hourlySalary){
        this.hourlySalary = hourlySalary;
    }

    public double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }
}
