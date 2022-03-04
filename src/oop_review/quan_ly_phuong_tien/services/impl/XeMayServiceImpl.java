package oop_review.quan_ly_phuong_tien.services.impl;

import static oop_review.quan_ly_phuong_tien.services.impl.HangSanXuatServiceImpl.hangSanXuats;

import java.util.Scanner;
import oop_review.quan_ly_phuong_tien.models.XeMay;
import oop_review.quan_ly_phuong_tien.services.IServices;

public class XeMayServiceImpl implements IServices {

    static XeMay[] xeMays = new XeMay[10];

    static {
        xeMays[0] = new XeMay("43-K1-678.56", hangSanXuats[0], 2019, "Nguyễn Văn A", 100);
        xeMays[1] = new XeMay("43-H1-345.89", hangSanXuats[1], 2019, "Nguyễn Văn B", 150);
        xeMays[2] = new XeMay("43-AK-765.23", hangSanXuats[0], 2019, "Nguyễn Văn C", 50);
    }

    @Override
    public void add() {
        int i = 0;
        while (xeMays[i] != null) {
            i++;
        }
        xeMays[i] = getNewXeMay();
        System.out.println("Thêm thành công: " + xeMays[i]);
    }

    private XeMay getNewXeMay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập biển số xe: ");
        String bienSoXe = scanner.nextLine();
        System.out.println("Nhập hãng xe. Chọn 1 trong số các hãng xe sau:");
        for (int j = 0; j < hangSanXuats.length; j++) {
            System.out.printf("%d. %s\n", j + 1, hangSanXuats[j].getTenHangSanXuat());
        }
        int hangSanXuatIndex = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập năm sản xuất: ");
        int namSanXuat = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên chủ sở hữu: ");
        String chuSoHuu = scanner.nextLine();
        System.out.println("Nhập công suất cho xe: ");
        int congSuat = Integer.parseInt(scanner.nextLine());
        return new XeMay(bienSoXe, hangSanXuats[hangSanXuatIndex - 1], namSanXuat, chuSoHuu,
            congSuat);
    }

    @Override
    public void showList() {
        int i = 0;
        while (xeMays[i] != null) {
            System.out.println(xeMays[i]);
            i++;
        }
    }

    @Override
    public void remove(int index) {
        System.out.println("Bạn có đồng ý xóa: ");
        System.out.println(xeMays[index]);
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("Bạn chọn: ");
        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        if (choice == 1) {
            removePhuongTien(index);
            System.out.println("Đã xóa thành công");
        } else {
            System.out.println("Không xóa! Quay về menu chính");
        }
    }

    private void removePhuongTien(int index) {
        for (int i = index; i < xeMays.length - 1; i++) {
            xeMays[i] = xeMays[i + 1];
        }
    }

    @Override
    public int searchByBiemKiemSoat(String bienKiemSoat) {
        int i = 0;
        while (xeMays[i] != null) {
            if (xeMays[i].getBienKiemSoat().equals(bienKiemSoat)) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
