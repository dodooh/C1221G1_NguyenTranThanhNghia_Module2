package case_study.furama_resort.services.people_services;

import case_study.furama_resort.models.people_models.Person;
import case_study.furama_resort.services.IService;

public interface IPeopleService extends IService<Person> {

    void edit(int index, Person person);
}
