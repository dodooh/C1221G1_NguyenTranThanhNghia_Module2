package oop_review.quan_ly_phuong_tien.services.impl;

import java.util.ArrayList;
import java.util.Scanner;
import oop_review.quan_ly_phuong_tien.models.Oto;
import oop_review.quan_ly_phuong_tien.models.PhuongTien;
import oop_review.quan_ly_phuong_tien.services.IServices;

import static oop_review.quan_ly_phuong_tien.services.impl.HangSanXuatServiceImpl.hangSanXuats;

public class OtoServiceImpl extends PhuongTienServiceImpl implements IServices {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<PhuongTien> otos = new ArrayList<>();

    static {
        otos.add( new Oto("43A-212.56", hangSanXuats[5], 2019, "Nguyễn Văn A", 5, "Du lịch"));
        otos.add( new Oto("43B-453.88", hangSanXuats[3], 2020, "Nguyễn Văn B", 45, "Xe khách"));
        otos.add( new Oto("43B-453.89", hangSanXuats[4], 2020, "Nguyễn Văn C", 16, "Xe khách"));
    }

    @Override
    public void add() {
        super.add();
        System.out.println("Nhập số chỗ ngồi: ");
        int soChoNgoi = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập kiểu xe: ");
        String kieuXe = scanner.nextLine();
        otos.add(new Oto(super.phuongTien,soChoNgoi,kieuXe));
    }

    @Override
    public void showList() {
        this.showList(otos);
    }

    @Override
    public void remove(int index) {
        remove(otos,index);

    }

    @Override
    public int searchByBiemKiemSoat(String bienKiemSoat) {
        return searchByBiemKiemSoat(otos,bienKiemSoat);
    }


}
