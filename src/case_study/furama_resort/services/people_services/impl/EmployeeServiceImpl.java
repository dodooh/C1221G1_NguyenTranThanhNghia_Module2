package case_study.furama_resort.services.people_services.impl;

import case_study.furama_resort.models.people_models.Employee;
import case_study.furama_resort.models.people_models.Person;
import case_study.furama_resort.models.enums.EmployeeLevel;
import case_study.furama_resort.models.enums.EmployeePosition;
import case_study.furama_resort.services.people_services.IEmployeeService;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {

    public static List<Person> employeeList;


    static {
        employeeList = new ArrayList<>(10);
        employeeList.add(new Employee("Nguyen", "20/01/1997", true, "200862169",
            "0935151766", "abc@gmail.com", "A101",
            EmployeeLevel.SAU_DAI_HOC, EmployeePosition.GIAM_DOC, 2500));
        employeeList.add(new Employee("Tran", "01/01/1997", true, "122323445",
            "093512342", "asdbc@gmail.com", "A151",
            EmployeeLevel.CAO_DANG, EmployeePosition.LE_TAN, 1500));
    }

    public void edit(int index, Person person) {
        employeeList.set(index, person);
    }


    @Override
    public void add(Person person) {
        employeeList.add(person);
        System.out.println(person);
        System.out.println("Add Successfully!!");
    }

}
