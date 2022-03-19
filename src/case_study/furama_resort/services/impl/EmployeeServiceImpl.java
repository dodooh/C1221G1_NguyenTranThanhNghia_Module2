package case_study.furama_resort.services.impl;

import case_study.furama_resort.models.Person;
import case_study.furama_resort.services.IEmployeeService;
import case_study.furama_resort.utils.ReadWriteCSVFile;
import java.util.LinkedList;
import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {

    private static final String EMPLOYEE_FILE_PATH = "src/case_study/furama_resort/data/employee.csv";
    public static List<Person> employeeList = new LinkedList<>();
    private static EmployeeServiceImpl instance;

    static {
        employeeList = new LinkedList<>();
        employeeList = ReadWriteCSVFile.readEmployeeListFromCSVFile(EMPLOYEE_FILE_PATH);

    }

    private EmployeeServiceImpl() {
    }

    public static EmployeeServiceImpl getInstance() {
        if (instance == null) {
            instance = new EmployeeServiceImpl();
        }
        return instance;
    }

    public void edit(int index, Person person) {
        employeeList.set(index, person);
        ReadWriteCSVFile.writeListToCSVFile(employeeList, EMPLOYEE_FILE_PATH);
        System.out.println(person);
        System.out.println("✓Edit Successfully");
    }

    @Override
    public void displayList() {
        System.out.println("=========EMPLOYEE LIST==========");
        if (employeeList != null && employeeList.size() != 0) {
            int index = 0;
            for (Person item : employeeList) {
                System.out.printf("[%d] - %s", index++, item);
                System.out.println();
            }
        } else {
            System.out.println("!!!EMPLOYEE LIST IS EMPTY!!!");
        }
    }

    @Override
    public void add(Person person) {
        employeeList.add(person);
        ReadWriteCSVFile.writeListToCSVFile(employeeList, EMPLOYEE_FILE_PATH);
        System.out.println(person);
        System.out.println("✓Add Successfully!!");
    }

}
