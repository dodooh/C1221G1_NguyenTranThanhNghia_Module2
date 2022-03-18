package case_study.furama_resort.services.impl;

import case_study.furama_resort.models.Person;
import case_study.furama_resort.services.IEmployeeService;
import case_study.furama_resort.utils.ReadWriteCSVFile;
import java.util.LinkedList;
import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {

    private static final String EMPLOYEE_FILE_PATH = "src/case_study/furama_resort/data/employee.csv";
    public static List<Person> employeeList = new LinkedList<>();

    static {
        employeeList = new LinkedList<>();
        employeeList = ReadWriteCSVFile.readEmployeeListFromCSVFile(EMPLOYEE_FILE_PATH);

    }

    public void edit(int index, Person person) {
        employeeList.set(index, person);
        ReadWriteCSVFile.writeListToCSV(employeeList, EMPLOYEE_FILE_PATH);
        System.out.println(person);
        System.out.println("Edit Successfully");
    }

    @Override
    public void displayList(List<Person> list) {
        System.out.println("=========EMPLOYEE LIST==========");
        if (list != null && list.size() != 0) {
            int index = 0;
            for (Person item : list) {
                System.out.printf("[%d] = %s", index++, item);
                System.out.println();
            }
        } else {
            System.out.println("!!!Employee List not found.");
        }
    }

    @Override
    public void add(Person person) {
        employeeList.add(person);
        ReadWriteCSVFile.writeListToCSV(employeeList, EMPLOYEE_FILE_PATH);
        System.out.println(person);
        System.out.println("Add Successfully!!");
    }

}
