package oop_review.quan_ly_phuong_tien.controllers.impl;


import static oop_review.quan_ly_phuong_tien.controllers.MainController.scanner;

import oop_review.quan_ly_phuong_tien.models.PhuongTien;
import oop_review.quan_ly_phuong_tien.models.XeMay;
import oop_review.quan_ly_phuong_tien.utils.Validator;

public class XeMayControllerImpl extends PhuongTienControllerImpl {

    @Override
    public PhuongTien inputPhuongTien() {
        return new XeMay(
            getBienKiemSoatFromInput(),
            getHangSanXuatFromInput(),
            getNamSanXuatFromInput(),
            getChuSoHuuFromInput(),
            getCongSuatFromInput()
        );
    }

    @Override
    protected String getBienKiemSoatFromInput() {
        String bienSoXe;
        do {
            System.out.print("Nhập biển số xe máy: 'XX-YZ-XXX.XX (X : 0÷9, Y= (Chữ cái in hoa), Z =(0÷9) hoặc (Chữ cái in Hoa).'");
            bienSoXe = scanner.nextLine();
            if (!Validator.isValidXeMay(bienSoXe)) {
                System.err.println("Biển số xe máy không hợp lệ");
            } else {
                break;
            }
        } while (true);
        return bienSoXe;
    }

    private int getCongSuatFromInput() {
        String congSuat;
        do {
            System.out.println("Nhập công suất cho xe: ");
            congSuat = scanner.nextLine();
            if (!Validator.isValidNumber(congSuat)) {
                System.err.println("Công suất không hợp lệ");
            } else {
                break;
            }
        } while (true);

        return Integer.parseInt(congSuat);
    }
}
