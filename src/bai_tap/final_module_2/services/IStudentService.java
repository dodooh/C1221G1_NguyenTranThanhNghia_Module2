package bai_tap.final_module_2.services;

import bai_tap.final_module_2.utils.NotFoundStudentException;
import bai_tap.quan_ly_benh_an_11.utils.NotFoundMedicalRecordException;

public interface IStudentService<T> {

    int findGoodID();

    void add(T t);

    void display();

    void remove(T t);

    T findStudentByID(int ID) throws NotFoundMedicalRecordException, NotFoundStudentException;

    void findStudentByName(String keywords);
}
