package oop_review.quan_ly_phuong_tien.services.impl;

import static oop_review.quan_ly_phuong_tien.services.impl.HangSanXuatServiceImpl.hangSanXuats;

import java.util.ArrayList;
import java.util.Scanner;
import oop_review.quan_ly_phuong_tien.models.PhuongTien;
import oop_review.quan_ly_phuong_tien.models.XeTai;
import oop_review.quan_ly_phuong_tien.services.IServices;

public class XaTaiServiceImpl extends PhuongTienServiceImpl implements IServices {

    static ArrayList<PhuongTien> xeTais = new ArrayList<>();

    static {
        xeTais.add(new XeTai("43C-012.34", hangSanXuats[3], 2019, "Nguyễn Văn A", 3));
        xeTais.add(new XeTai("43C-47.678", hangSanXuats[2], 2020, "Nguyễn Văn B", 9));
        xeTais.add(new XeTai("43C-45.235", hangSanXuats[6], 2021, "Nguyễn Văn C", 12));
    }

    @Override
    public void add() {
        super.add();
        System.out.println("Nhập tải trọng cho xe: ");
        int taiTrong = Integer.parseInt(scanner.nextLine());
        xeTais.add(new XeTai(super.phuongTien,taiTrong));
    }

    @Override
    public void showList() {
        this.showList(xeTais);
    }

    @Override
    public void remove(int index) {
        remove(xeTais,index);
    }

    @Override
    public int searchByBiemKiemSoat(String bienKiemSoat) {
        return searchByBiemKiemSoat(xeTais,bienKiemSoat);
    }
}
