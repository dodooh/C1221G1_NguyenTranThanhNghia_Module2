package oop_review.quan_ly_phuong_tien.services.impl;

import static oop_review.quan_ly_phuong_tien.services.impl.HangSanXuatServiceImpl.hangSanXuats;
import static oop_review.quan_ly_phuong_tien.services.impl.OtoServiceImpl.scanner;

import java.util.ArrayList;
import java.util.Scanner;
import oop_review.quan_ly_phuong_tien.models.PhuongTien;
import oop_review.quan_ly_phuong_tien.models.XeMay;
import oop_review.quan_ly_phuong_tien.models.XeTai;
import oop_review.quan_ly_phuong_tien.services.IServices;

public class XeMayServiceImpl extends PhuongTienServiceImpl implements IServices {

    static ArrayList<PhuongTien> xeMays = new ArrayList<>();

    static {
        xeMays.add(new XeMay("43-K1-678.56", hangSanXuats[0], 2019, "Nguyễn Văn A", 100));
        xeMays.add(new XeMay("43-H1-345.89", hangSanXuats[1], 2019, "Nguyễn Văn B", 150));
        xeMays.add(new XeMay("43-AK-765.23", hangSanXuats[0], 2019, "Nguyễn Văn C", 50));
    }

    @Override
    public void add() {
        super.add();
        System.out.println("Nhập công suất cho xe: ");
        int congSuat = Integer.parseInt(scanner.nextLine());
        xeMays.add(new XeMay(super.phuongTien,congSuat));
    }

    public void showList() {
        showList(xeMays);
    }

    @Override
    public void remove(int index) {
        remove(xeMays,index);
    }

    @Override
    public int searchByBiemKiemSoat(String bienKiemSoat) {
        return searchByBiemKiemSoat(xeMays,bienKiemSoat);
    }
}
