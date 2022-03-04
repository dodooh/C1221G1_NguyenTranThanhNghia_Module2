package oop_review.quan_ly_phuong_tien.services.impl;

import java.util.Scanner;
import oop_review.quan_ly_phuong_tien.models.Oto;
import oop_review.quan_ly_phuong_tien.services.IServices;

import static oop_review.quan_ly_phuong_tien.services.impl.HangSanXuatServiceImpl.hangSanXuats;

public class OtoServiceImpl implements IServices {

    static Oto[] otos = new Oto[10];

    static {
        otos[0] = new Oto("43A-212.56", hangSanXuats[5], 2019, "Nguyễn Văn A", 5, "Du lịch");
        otos[1] = new Oto("43B-453.88", hangSanXuats[3], 2020, "Nguyễn Văn B", 45, "Xe khách");
        otos[2] = new Oto("43B-453.89", hangSanXuats[4], 2020, "Nguyễn Văn C", 16, "Xe khách");
    }

    @Override
    public void add() {
        int i = 0;
        while (otos[i] != null) {
            i++;
        }
        otos[i] = getNewOto();
        System.out.println("Thêm thành công: " + otos[i]);
    }

    private Oto getNewOto() {
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
        System.out.println("Nhập số chỗ ngồi: ");
        int soChoNgoi = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập kiểu xe: ");
        String kieuXe = scanner.nextLine();
        return new Oto(bienSoXe, hangSanXuats[hangSanXuatIndex - 1], namSanXuat, chuSoHuu,
            soChoNgoi, kieuXe);
    }

    @Override
    public void showList() {
        int i = 0;
        while (otos[i] != null) {
            System.out.println(otos[i]);
            i++;
        }
    }

    @Override
    public void remove(int index) {
        System.out.println("Bạn có đồng ý xóa: ");
        System.out.println(otos[index]);
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
        for (int i = index; i < otos.length - 1; i++) {
            otos[i] = otos[i + 1];
        }
    }

    @Override
    public int searchByBiemKiemSoat(String bienKiemSoat) {
        int i = 0;
        while (otos[i] != null) {
            if (otos[i].getBienKiemSoat().equals(bienKiemSoat)) {
                return i;
            }
            i++;
        }
        return -1;
    }


}
