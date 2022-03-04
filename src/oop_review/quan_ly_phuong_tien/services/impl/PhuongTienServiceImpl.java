package oop_review.quan_ly_phuong_tien.services.impl;

import static oop_review.quan_ly_phuong_tien.services.impl.HangSanXuatServiceImpl.hangSanXuats;

import java.util.ArrayList;
import java.util.Scanner;
import oop_review.oop_java_1.nhap_xuat_thong_tin_xe.Vehicle;
import oop_review.quan_ly_phuong_tien.models.PhuongTien;
import oop_review.quan_ly_phuong_tien.services.IServices;

public abstract class PhuongTienServiceImpl implements IServices {
    protected PhuongTien phuongTien;
    static Scanner scanner = new Scanner(System.in);


    @Override
    public void add() {
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
        phuongTien = new PhuongTien(bienSoXe,hangSanXuats[hangSanXuatIndex - 1],namSanXuat,chuSoHuu);
    }

    @Override
    public void showList(ArrayList<PhuongTien> list) {
        for (PhuongTien vehicle : list) {
            System.out.println(vehicle);
        }
    }


    @Override
    public void remove(ArrayList<PhuongTien> list,int index) {
        System.out.println("Tìm thấy!!" + list.get(index));
        System.out.println("Bạn có đồng ý xóa: ");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.println("Bạn chọn: ");
        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        if (choice == 1) {
            list.remove(index);
            System.out.println("Đã xóa thành công");
        } else {
            System.out.println("Không xóa! Quay về menu chính");
        }

    }

    @Override
    public int searchByBiemKiemSoat(ArrayList<PhuongTien> list, String bienKiemSoat) {
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).getBienKiemSoat().equals(bienKiemSoat)) {
                return i;
            }
        }
        return -1;
    }
}
