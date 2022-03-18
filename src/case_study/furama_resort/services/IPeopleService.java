package case_study.furama_resort.services;

import case_study.furama_resort.models.Person;

public interface IPeopleService extends IService<Person> {

    void edit(int index, Person person);
}
