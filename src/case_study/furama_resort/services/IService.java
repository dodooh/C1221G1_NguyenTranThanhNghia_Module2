package case_study.furama_resort.services;

import java.util.List;

public interface IService<T> {

    void displayList();

    void add(T object);
}
