package bai_tap.quan_ly_benh_an_11.services;

import bai_tap.quan_ly_benh_an_11.utils.NotFoundMedicalRecordException;

public interface IService<T> {

    int findGoodID();

    void add(T t);

    void display();

    void remove(T t);

    T findPatientByID(String ID) throws NotFoundMedicalRecordException;

    void displayPatientByKeyword(String keywords);
}
