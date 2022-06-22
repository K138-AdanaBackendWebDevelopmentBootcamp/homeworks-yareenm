package hmw1;

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
