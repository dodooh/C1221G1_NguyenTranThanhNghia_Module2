package case_study.furama_resort.models;



import case_study.furama_resort.models.enums.EmployeeLevel;
import case_study.furama_resort.models.enums.EmployeePosition;

public class Employee extends Person {

    private EmployeeLevel level; // level.TRUNG_CAP level.CAO_HOC
    private EmployeePosition position;
    private double salary;

    public Employee(String name, String dayOfBirth, boolean isMale, String nationalID, String phoneNumber, String email, String id,
        EmployeeLevel level, EmployeePosition position, double salary) {
        super(name, dayOfBirth, isMale, nationalID, phoneNumber, email, id);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public EmployeeLevel getDegree() {
        return level;
    }

    public void setLevel(EmployeeLevel level) {
        this.level = level;
    }

    public EmployeePosition getPosition() {
        return position;
    }

    public void setPosition(EmployeePosition position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
            super.toString() +
            ", level=" + level +
            ", position=" + position +
            ", salary=" + salary +
            '}';
    }
}
