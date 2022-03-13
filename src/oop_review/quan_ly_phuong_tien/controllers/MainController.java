package oop_review.quan_ly_phuong_tien.controllers;

import java.util.Scanner;
import oop_review.quan_ly_phuong_tien.controllers.impl.OtoControllerImpl;
import oop_review.quan_ly_phuong_tien.controllers.impl.XeMayControllerImpl;
import oop_review.quan_ly_phuong_tien.controllers.impl.XeTaiControllerImpl;
import oop_review.quan_ly_phuong_tien.models.PhuongTien;
import oop_review.quan_ly_phuong_tien.services.IServices;
import oop_review.quan_ly_phuong_tien.services.impl.OtoServiceImpl;
import oop_review.quan_ly_phuong_tien.services.impl.XaTaiServiceImpl;
import oop_review.quan_ly_phuong_tien.services.impl.XeMayServiceImpl;
import oop_review.quan_ly_phuong_tien.utils.NotFoundVehicelException;

public class MainController {

    public static Scanner scanner = new Scanner(System.in);
    IServices otoService = new OtoServiceImpl();
    IServices xeMayService = new XeMayServiceImpl();
    IServices xeTaiService = new XaTaiServiceImpl();
    IController xeMayController = new XeMayControllerImpl();
    IController otoController = new OtoControllerImpl();
    IController xeTaiController = new XeTaiControllerImpl();

    public void showMainMenu() {
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
                    try {
                        removePhuongTien();
                    } catch (NotFoundVehicelException e) {
                        e.getMessage();
                    }
                    break;
                default:
                    System.out.println("Thoát chương trình");
                    System.exit(0);
            }
        } while (true);
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
                xeTaiService.add(xeTaiController.inputPhuongTien());
                break;
            case 2:
                otoService.add(otoController.inputPhuongTien());
                break;
            case 3:
                xeMayService.add(xeMayController.inputPhuongTien());
                break;
        }
    }

    private void removePhuongTien() throws NotFoundVehicelException {
        System.out.println("Nhập biển số xe muốn xóa: ");
        String bienKiemSoat = scanner.nextLine();
        PhuongTien phuongTien = null;
        int indexInOtos = otoService.searchByBienKiemSoat(bienKiemSoat);
        int indexInXeMays = xeMayService.searchByBienKiemSoat(bienKiemSoat);
        int indexInXeTais = xeTaiService.searchByBienKiemSoat(bienKiemSoat);
        if (indexInOtos != -1) {
            phuongTien = otoService.get(indexInOtos);
            if (otoController.askToRemove(phuongTien)) {
                otoService.remove(phuongTien);
            }
        } else if (indexInXeMays != -1) {
            phuongTien = xeMayService.get(indexInXeMays);
            if (xeMayController.askToRemove(phuongTien)) {
                xeMayService.remove(phuongTien);
            }
        } else if (indexInXeTais != -1) {
            phuongTien = xeTaiService.get(indexInXeTais);
            if (xeTaiController.askToRemove(phuongTien)) {
                xeTaiService.remove(phuongTien);
            }
        } else {
            throw new NotFoundVehicelException();
        }
    }
}
