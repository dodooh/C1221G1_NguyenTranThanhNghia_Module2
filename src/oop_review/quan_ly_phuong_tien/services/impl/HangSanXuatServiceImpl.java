package oop_review.quan_ly_phuong_tien.services.impl;

import oop_review.quan_ly_phuong_tien.models.HangSanXuat;

public class HangSanXuatServiceImpl {

    public static final HangSanXuat[] hangSanXuats = new HangSanXuat[7];

    static {
        hangSanXuats[0] = new HangSanXuat("HSX-001", "Yamaha", "Nhật Bản");
        hangSanXuats[1] = new HangSanXuat("HSX-002", "Honda", "Nhật Bản");
        hangSanXuats[2] = new HangSanXuat("HSX-003", "Dongfeng", "Trung Quốc");
        hangSanXuats[3] = new HangSanXuat("HSX-004", "Huyndai", "Hàn Quốc");
        hangSanXuats[4] = new HangSanXuat("HSX-005", "Ford", "Mỹ");
        hangSanXuats[5] = new HangSanXuat("HSX-006", "Toyota", "Nhật Bản");
        hangSanXuats[6] = new HangSanXuat("HSX-007", "Hino", "Nhật Bản");
    }

    public static HangSanXuat findByName(String name) {
        for (HangSanXuat hangSanXuat : hangSanXuats) {
            if (hangSanXuat.getTenHangSanXuat().equals(name)) {
                return hangSanXuat;
            }
        }
        return null;
    }
}