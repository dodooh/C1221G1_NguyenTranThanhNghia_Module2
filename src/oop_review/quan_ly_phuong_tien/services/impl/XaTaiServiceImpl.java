package oop_review.quan_ly_phuong_tien.services.impl;


import java.util.ArrayList;
import java.util.List;
import oop_review.quan_ly_phuong_tien.models.PhuongTien;
import oop_review.quan_ly_phuong_tien.services.IServices;

import static oop_review.quan_ly_phuong_tien.utils.ReadAndWriteFile.writePhuongTienListToCSV;
import static oop_review.quan_ly_phuong_tien.utils.ReadAndWriteFile.readXeTaiListFromFile;

public class XaTaiServiceImpl extends PhuongTienServiceImpl implements IServices {

    static private final String XE_TAI_CSV_FILE = "src/oop_review/quan_ly_phuong_tien/data/xeTai.csv";
    static List<PhuongTien> xeTais = new ArrayList<>();

    static {
        xeTais = readXeTaiListFromFile(XE_TAI_CSV_FILE);
    }

    @Override
    public PhuongTien get(int index) {
        return xeTais.get(index);
    }

    @Override
    public void add(PhuongTien newPhuongTien) {
        xeTais.add(newPhuongTien);
        writePhuongTienListToCSV(xeTais, XE_TAI_CSV_FILE, false);
        System.out.println("Thêm thành công: " + newPhuongTien);
    }

    @Override
    public void showList() {
        this.showList(xeTais);
    }

    @Override
    public void remove(PhuongTien phuongTien) {
        remove(xeTais, phuongTien);
        writePhuongTienListToCSV(xeTais, XE_TAI_CSV_FILE, false);
        System.out.println("Xóa Thành Công!!");
    }

    @Override
    public int searchByBienKiemSoat(String bienKiemSoat) {
        return searchByBienKiemSoat(xeTais, bienKiemSoat);
    }
}
