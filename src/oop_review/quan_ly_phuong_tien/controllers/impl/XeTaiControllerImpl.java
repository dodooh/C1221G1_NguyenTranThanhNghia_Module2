package oop_review.quan_ly_phuong_tien.controllers.impl;

import static oop_review.quan_ly_phuong_tien.controllers.MainController.scanner;

import oop_review.quan_ly_phuong_tien.models.PhuongTien;
import oop_review.quan_ly_phuong_tien.models.XeTai;
import oop_review.quan_ly_phuong_tien.utils.Validator;

public class XeTaiControllerImpl extends PhuongTienControllerImpl {

    @Override
    public PhuongTien inputPhuongTien() {
        return new XeTai(
            getBienKiemSoatFromInput(),
            getHangSanXuatFromInput(),
            getNamSanXuatFromInput(),
            getChuSoHuuFromInput(),
            getTaiTrongFromInput()
        );
    }

    @Override
    protected String getBienKiemSoatFromInput() {
        String bienSoXe;
        do {
            System.out.print("Nhập biển số xe tải: 'XXC-XXX.XX'");
            bienSoXe = scanner.nextLine();
            if (!Validator.isValidXeTai(bienSoXe)) {
                System.err.println("Biển số xe tải không hợp lệ");
            } else {
                break;
            }
        } while (true);
        return bienSoXe;
    }

    private int getTaiTrongFromInput() {
        String taiTrong;
        do {
            System.out.print("Nhập tải trọng cho xe: ");
            taiTrong = scanner.nextLine();
            if (!Validator.isValidNumber(taiTrong)) {
                System.err.println("Tải trọng không hợp lệ");
            } else {
                break;
            }
        } while (true);

        return Integer.parseInt(taiTrong);
    }
}
