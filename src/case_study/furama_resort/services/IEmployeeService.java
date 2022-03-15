package case_study.furama_resort.services;

import case_study.furama_resort.models.Person;
import java.util.List;

public interface IEmployeeService extends IPeopleService{
    List<Person> getEmployeeList();
}
