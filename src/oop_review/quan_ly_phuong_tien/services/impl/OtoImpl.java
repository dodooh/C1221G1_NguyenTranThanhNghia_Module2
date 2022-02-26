package oop_review.quan_ly_phuong_tien.services.impl;

import oop_review.quan_ly_phuong_tien.models.Oto;
import oop_review.quan_ly_phuong_tien.services.IServices;

import static oop_review.quan_ly_phuong_tien.services.impl.HangSanXuatImpl.hangSanXuats;

public class OtoImpl implements IServices {

    static Oto[] otos = new Oto[10];

    static {
        otos[0] = new Oto("43A-212.56", hangSanXuats[5], 2019, "Nguyễn Văn A", 5, "Du lịch");
        otos[1] = new Oto("43B-453.88", hangSanXuats[3], 2020, "Nguyễn Văn B", 45, "Xe khách");
        otos[2] = new Oto("43B-453.89", hangSanXuats[4], 2020, "Nguyễn Văn C", 16, "Xe khách");
    }

    @Override
    public void add() {

    }

    @Override
    public void showList() {
        int i = 0;
        while (otos[i] != null) {
            System.out.println(otos[i]);
            i++;
        }
    }

    @Override
    public void remove() {

    }


}
