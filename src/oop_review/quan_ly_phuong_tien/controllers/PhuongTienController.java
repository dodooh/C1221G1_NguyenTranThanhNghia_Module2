package oop_review.quan_ly_phuong_tien.controllers;

import java.util.Scanner;
import oop_review.quan_ly_phuong_tien.services.IServices;
import oop_review.quan_ly_phuong_tien.services.impl.OtoImpl;

public class PhuongTienController {

    Scanner scanner = new Scanner(System.in);
    IServices otoService = new OtoImpl();

    public void showMainMenu() {

        boolean flag = true;
        do {
            System.out.println(" CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG ");
            System.out.println("Chọn chức năng: ");
            System.out.println("1. Thêm mới phương tiện.");
            System.out.println("2. Hiển thị phương tiện");
            System.out.println("3. Xóa phương tiện");
            System.out.println("4. Thoát");
            System.out.println("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    //chức năng thêm ới
                    break;
                case 2:
                    showDisplayList();
                    //chức năng hiện thi

                    break;
                case 3:
                    //chức năng thêm sửa
                    break;
            }
        } while (flag);
    }

    private void showDisplayList() {
        System.out.println("Chọn loại phương tiện: ");
        System.out.println("1. Hiện thị xe tải.");
        System.out.println("2. Hiện thị ôtô. ");
        System.out.println("3. Hiện  xe máy.");
        System.out.println("4. Quay lại");
        System.out.println("Nhập lựa chọn: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                //chức năng thêm ới
                break;
            case 2:
                otoService.showList();
                //chức năng hiện thi

                break;
            case 3:
                //chức năng thêm sửa
                break;
        }
    }
}
