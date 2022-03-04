package oop_review.quan_ly_phuong_tien.services;

import java.util.ArrayList;
import oop_review.oop_java_1.nhap_xuat_thong_tin_xe.Vehicle;
import oop_review.quan_ly_phuong_tien.models.PhuongTien;

public interface IServices {

    void add();

    void showList(ArrayList<PhuongTien> list); // triển khai ở lớp abstract

    void showList(); // triển khai ở lớp con

    void remove(int index);// triển khai ở lớp con

    void remove(ArrayList<PhuongTien> list, int index); // triển khai ở lớp abstract

    int searchByBiemKiemSoat(String bienKiemSoat);// triển khai ở lớp con

    int searchByBiemKiemSoat(ArrayList<PhuongTien> list, String bienKiemSoat);// triển khai ở lớp abstract
}
