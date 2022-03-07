package case_study.furama_resort.models;

public class Employee extends Person {

    public static final String[] EMPLOYEE_DEGREE = {"Trung Cấp", "Cao Đẳng", "Đại Học", "Sau Đại Học"};
    public static final String[] EMPLOYEE_POSITION = {"Lễ Tân", "Phục Vụ", "Chuyên Viên", "Giám Sát", "Quản Lý", "Giám Đốc"};
    private String employeeID;
    private String degree;
    private String position;
    private long salary;

    public Employee(String name, String dayOfBirth, boolean isMale, String nationalID, String phoneNumber, String email, String employeeID,
        String degree, String position, long salary) {
        super(name, dayOfBirth, isMale, nationalID, phoneNumber, email);
        this.employeeID = employeeID;
        this.degree = degree;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }
}
