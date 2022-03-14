package oop_review.quan_ly_phuong_tien.controllers.impl;


import static oop_review.quan_ly_phuong_tien.controllers.MainController.scanner;
import static oop_review.quan_ly_phuong_tien.services.impl.HangSanXuatServiceImpl.hangSanXuats;

import java.util.Scanner;
import oop_review.quan_ly_phuong_tien.controllers.IController;
import oop_review.quan_ly_phuong_tien.models.HangSanXuat;
import oop_review.quan_ly_phuong_tien.models.PhuongTien;
import oop_review.quan_ly_phuong_tien.utils.Validator;

public abstract class PhuongTienControllerImpl implements IController {

    @Override
    public boolean askToRemove(PhuongTien phuongTien) {
        System.out.println("Tìm thấy!!" + phuongTien);
        System.out.println("Bạn có đồng ý xóa: ");
        System.out.println("[1] - Yes");
        System.out.println("[2] - No");
        System.out.print("Bạn chọn: ");
        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        return choice == 1;
    }

    public abstract PhuongTien inputPhuongTien();

    protected String getChuSoHuuFromInput() {
        String chuSoHuu;
        do {
            System.out.print("Nhập tên chủ sở hữu: ");
            chuSoHuu = scanner.nextLine();
            if (!Validator.isRequired(chuSoHuu)) {
                System.err.println("Chủ sở hữu không hợp lệ. Nhập lại");
            } else {
                break;
            }
        } while (true);
        return chuSoHuu;
    }

    protected int getNamSanXuatFromInput() {
        int namSanXuat;
        do {
            System.out.print("Nhập năm sản xuất: ");
            namSanXuat = Integer.parseInt(scanner.nextLine());
            if (!Validator.isValidYear(namSanXuat)) {
                System.err.println("Năm sản xuất không hợp lệ. Nhập lại");
            } else {
                break;
            }
        } while (true);
        return namSanXuat;
    }

    protected HangSanXuat getHangSanXuatFromInput() {
        System.out.print("Chọn Hãng Sản Xuất");
        for (int j = 0; j < hangSanXuats.size(); j++) {
            System.out.printf("[%d] - %s\n", j + 1, hangSanXuats.get(j).getTenHangSanXuat());
        }
        int hangSanXuatIndex = Integer.parseInt(scanner.nextLine());
        return hangSanXuats.get(hangSanXuatIndex - 1);
    }

    protected abstract String getBienKiemSoatFromInput();
}
