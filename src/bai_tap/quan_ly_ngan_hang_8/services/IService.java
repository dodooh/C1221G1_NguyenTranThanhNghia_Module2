package bai_tap.quan_ly_ngan_hang_8.services;

public interface IService<T> {

    void create(T t);

    void display();

    void remove(T t);
}
