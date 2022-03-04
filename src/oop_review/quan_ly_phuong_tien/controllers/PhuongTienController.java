package oop_review.quan_ly_phuong_tien.controllers;

import java.util.Scanner;
import oop_review.quan_ly_phuong_tien.services.IServices;
import oop_review.quan_ly_phuong_tien.services.impl.OtoServiceImpl;
import oop_review.quan_ly_phuong_tien.services.impl.XaTaiServiceImpl;
import oop_review.quan_ly_phuong_tien.services.impl.XeMayServiceImpl;

public class PhuongTienController {

    Scanner scanner = new Scanner(System.in);
    IServices otoService = new OtoServiceImpl();
    IServices xeMayService = new XeMayServiceImpl();
    IServices xeTaiService = new XaTaiServiceImpl();

    public void showMainMenu() {

        boolean flag = true;
        do {
            System.out.println("========CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG=========");
            System.out.println("Chọn chức năng: ");
            System.out.println("1. Thêm mới phương tiện.");
            System.out.println("2. Hiển thị phương tiện");
            System.out.println("3. Xóa phương tiện");
            System.out.println("4. Thoát");
            System.out.println("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    showAddNewMenu();
                    break;
                case 2:
                    showDisplayList();
                    break;
                case 3:
                    removePhuongTien();
                    break;
                default:
                    flag = false;
            }
        } while (flag);
    }

    // HIển thị menu hiển thị danh sách
    private void showDisplayList() {
        System.out.println("Chọn loại phương tiện: ");
        System.out.println("1. Hiện thị xe tải.");
        System.out.println("2. Hiện thị ôtô. ");
        System.out.println("3. Hiện xe máy.");
        System.out.println("4. Quay lại");
        System.out.println("Nhập lựa chọn: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                xeTaiService.showList();
                break;
            case 2:
                otoService.showList();
                break;
            case 3:
                xeMayService.showList();
                break;
        }
    }

    // HIển thị menu thêm mới
    private void showAddNewMenu() {
        System.out.println("Thêm mới phương tiện: ");
        System.out.println("1. Thêm xe tải.");
        System.out.println("2. Thêm ôtô. ");
        System.out.println("3. Thêm xe máy.");
        System.out.println("4. Quay lại");
        System.out.println("Nhập lựa chọn: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                xeTaiService.add();
                break;
            case 2:
                otoService.add();
                break;
            case 3:
                xeMayService.add();
                break;
        }
    }

    private void removePhuongTien() {
        System.out.println("Nhập biển số xe muốn xóa: ");
        String bienKiemSoat = scanner.nextLine();
        int indexOfXeTai = xeTaiService.searchByBiemKiemSoat(bienKiemSoat);
        int indexOfXeMay = xeMayService.searchByBiemKiemSoat(bienKiemSoat);
        int indexOfOto = otoService.searchByBiemKiemSoat(bienKiemSoat);
        if (indexOfXeTai != -1) {
            xeTaiService.remove(indexOfXeTai);
        } else if (indexOfXeMay != -1) {
            xeMayService.remove(indexOfXeMay);
        } else if (indexOfOto != -1) {
            otoService.remove(indexOfOto);
        } else {
            System.out.println("Không tìm thấy biển kiểm soát trong hệ thống!");
        }
    }
}
