package oop_review.quan_ly_phuong_tien.services.impl;

import static oop_review.quan_ly_phuong_tien.services.impl.HangSanXuatImpl.hangSanXuats;

import java.util.Scanner;
import oop_review.quan_ly_phuong_tien.models.XeMay;
import oop_review.quan_ly_phuong_tien.models.XeTai;
import oop_review.quan_ly_phuong_tien.services.IServices;

public class XaTaiImpl implements IServices {

    static XeTai[] xeTais = new XeTai[10];

    static {
        xeTais[0] = new XeTai("43C-012.34", hangSanXuats[3], 2019, "Nguyễn Văn A", 3);
        xeTais[1] = new XeTai("43C-47.678", hangSanXuats[2], 2020, "Nguyễn Văn B", 9);
        xeTais[2] = new XeTai("43C-45.235", hangSanXuats[6], 2021, "Nguyễn Văn C", 12);
    }

    @Override
    public void add() {
        int i = 0;
        while (xeTais[i] != null) {
            i++;
        }
        xeTais[i] = getNewXeTai();
        System.out.println("Thêm thành công: " + xeTais[i]);
    }

    private XeTai getNewXeTai() {
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
        System.out.println("Nhập tải trọng cho xe: ");
        int taiTrong = Integer.parseInt(scanner.nextLine());
        return new XeTai(bienSoXe, hangSanXuats[hangSanXuatIndex - 1], namSanXuat, chuSoHuu,
            taiTrong);
    }

    @Override
    public void showList() {
        int i = 0;
        while (xeTais[i] != null) {
            System.out.println(xeTais[i]);
            i++;
        }
    }

    @Override
    public void remove(int index) {
        System.out.println("Bạn có đồng ý xóa: ");
        System.out.println(xeTais[index]);
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
        for (int i = index; i < xeTais.length - 1; i++) {
            xeTais[i] = xeTais[i + 1];
        }
    }

    @Override
    public int searchByBiemKiemSoat(String bienKiemSoat) {
        int i = 0;
        while (xeTais[i] != null) {
            if (xeTais[i].getBienKiemSoat().equals(bienKiemSoat)) {
                return i;
            }
            i++;
        }
        return -1;
    }
}
