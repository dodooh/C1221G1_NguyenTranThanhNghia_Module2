package oop_review.quan_ly_phuong_tien.services.impl;

import java.util.List;
import oop_review.quan_ly_phuong_tien.models.HangSanXuat;
import oop_review.quan_ly_phuong_tien.utils.ReadAndWriteFile;

public class HangSanXuatServiceImpl {
    static private final String HANG_SAN_XUAT_CSV_FILE = "src/oop_review/quan_ly_phuong_tien/data/hangSanXuat.csv";
    public static List<HangSanXuat> hangSanXuats;

    static {
        hangSanXuats = ReadAndWriteFile.readHangSanXuatListFromFile(HANG_SAN_XUAT_CSV_FILE);
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