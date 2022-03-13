package oop_review.quan_ly_phuong_tien.controllers.impl;

import static oop_review.quan_ly_phuong_tien.controllers.MainController.scanner;

import oop_review.quan_ly_phuong_tien.models.HangSanXuat;
import oop_review.quan_ly_phuong_tien.models.Oto;
import oop_review.quan_ly_phuong_tien.models.PhuongTien;
import oop_review.quan_ly_phuong_tien.utils.Validator;

public class OtoControllerImpl extends PhuongTienControllerImpl {

    private Oto.KieuXe kieuXe;

    @Override
    public PhuongTien inputPhuongTien() {
        String chuSoHuu = getChuSoHuuFromInput();
        int namSanXuat = getNamSanXuatFromInput();
        HangSanXuat hangSanXuat = getHangSanXuatFromInput();
        kieuXe = getKieuXeFromInput();
        int soChoNgoi = getSoChoNgoiFromInput();
        String bienKiemSoat = getBienKiemSoatFromInput();
        return new Oto(
            bienKiemSoat,
            hangSanXuat,
            namSanXuat,
            chuSoHuu,
            soChoNgoi,
            kieuXe
        );
    }

    private Oto.KieuXe getKieuXeFromInput() {
        // Hard code
        System.out.println("[1] - Xe khach\n[2] - Xe Du Lich");
        System.out.print("Bạn chọn: ");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            return Oto.KieuXe.XE_KHACH;
        } else {
            return Oto.KieuXe.XE_DU_LICH;
        }
    }

    @Override
    protected String getBienKiemSoatFromInput() {
        String bienSoXe;
        do {
            System.out.println("Nhập biển số xe ô tô: 'XXY-XXX.XX (X : 0÷9 , Y=A nếu xe du lịch, Y=B nếu xe khách)'");
            bienSoXe = scanner.nextLine();
            if (!Validator.isValidOto(bienSoXe, kieuXe)) {
                System.err.println("Biển số xe ô tô không hợp lệ");
            } else {
                break;
            }
        } while (true);
        return bienSoXe;
    }

    private int getSoChoNgoiFromInput() {
        String soChoNgoi;
        do {
            System.out.print("Nhập số chỗ ngồi cho xe: ");
            soChoNgoi = scanner.nextLine();
            if (!Validator.isValidNumber(soChoNgoi)) {
                System.err.println("Số chỗ ngồi không hợp lệ");
            } else {
                break;
            }
        } while (true);

        return Integer.parseInt(soChoNgoi);
    }
}
