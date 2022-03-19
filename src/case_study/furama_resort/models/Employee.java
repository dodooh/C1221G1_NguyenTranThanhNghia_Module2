package case_study.furama_resort.models;


import case_study.furama_resort.models.enums.EmployeeLevel;
import case_study.furama_resort.models.enums.EmployeePosition;

public class Employee extends Person {

    private String employeeID;
    private EmployeeLevel level;
    private EmployeePosition position;
    private double salary;

    public Employee(String name, String dayOfBirth, boolean isMale, String nationalID, String phoneNumber, String email,
        String employeeID,
        EmployeeLevel level, EmployeePosition position, double salary) {
        super(name, dayOfBirth, isMale, nationalID, phoneNumber, email);
        this.employeeID = employeeID;
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public Employee(Employee anotherEmployee) {
        this.setName(anotherEmployee.getName());
        this.setDayOfBirth(anotherEmployee.getDayOfBirth());
        this.setMale(anotherEmployee.isMale());
        this.setNationalID(anotherEmployee.getNationalID());
        this.setPhoneNumber(anotherEmployee.getPhoneNumber());
        this.setEmail(anotherEmployee.getEmail());
        this.employeeID = anotherEmployee.getEmployeeID();
        this.level = anotherEmployee.getLevel();
        this.position = anotherEmployee.getPosition();
        this.salary = anotherEmployee.getSalary();
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public EmployeeLevel getLevel() {
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
            "employeeID=" + employeeID +
            super.toString() +
            ", level=" + level +
            ", position=" + position +
            ", salary=" + String.format("%,.0f", salary) +
            '}';
    }

    @Override
    public String toCSVFormat() {
        return super.toCSVFormat() + "," + employeeID + "," + level + "," + position + "," + String.format("%.0f",
            salary);
    }
}
