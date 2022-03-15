package case_study.furama_resort.services;

import case_study.furama_resort.models.Person;

public interface IPeopleService extends IService{
    void edit(int index, Person person);
}
