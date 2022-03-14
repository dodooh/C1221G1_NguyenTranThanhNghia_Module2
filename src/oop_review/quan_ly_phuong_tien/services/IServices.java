package oop_review.quan_ly_phuong_tien.services;

import java.util.ArrayList;
import java.util.List;
import oop_review.quan_ly_phuong_tien.models.PhuongTien;

public interface IServices {

    void add(PhuongTien newPhuongTien);

    PhuongTien get(int index);

    void showList(); // triển khai ở lớp con

    void remove(PhuongTien phuongTien);// triển khai ở lớp con

    void remove(List<PhuongTien> list, PhuongTien phuongTien); // triển khai ở lớp abstract

    int searchByBienKiemSoat(String bienKiemSoat);// triển khai ở lớp con

//    int searchByBienKiemSoat(ArrayList<PhuongTien> list, String bienKiemSoat);// triển khai ở lớp abstract
}
