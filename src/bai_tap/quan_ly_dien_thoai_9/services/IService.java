package bai_tap.quan_ly_dien_thoai_9.services;

import bai_tap.quan_ly_dien_thoai_9.utils.NotFoundProductException;

public interface IService<T> {

    int findGoodID();

    void add(T t);

    void display();

    void remove(T t);

    T findPhoneByID(int ID) throws NotFoundProductException;

    void displayPhoneByKeyword(String keywords);
}
