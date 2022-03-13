package oop_review.quan_ly_phuong_tien.services.impl;


import static oop_review.quan_ly_phuong_tien.utils.ReadAndWriteFile.writePhuongTienListToCSV;

import java.util.ArrayList;
import java.util.List;
import oop_review.quan_ly_phuong_tien.models.PhuongTien;
import oop_review.quan_ly_phuong_tien.services.IServices;
import oop_review.quan_ly_phuong_tien.utils.ReadAndWriteFile;

public class XeMayServiceImpl extends PhuongTienServiceImpl implements IServices {
    static private final String XE_MAY_CSV_FILE = "src/oop_review/quan_ly_phuong_tien/data/xeMay.csv";
    static List<PhuongTien> xeMays = new ArrayList<>();

    static {
        xeMays = ReadAndWriteFile.readXeMayListFromFile(XE_MAY_CSV_FILE);
    }

    @Override
    public void add(PhuongTien newPhuongTien) {
        xeMays.add(newPhuongTien);
        writePhuongTienListToCSV(xeMays,XE_MAY_CSV_FILE,false);
        System.out.println("Thêm thành công: " + newPhuongTien);
    }

    @Override
    public PhuongTien get(int index) {
        return xeMays.get(index);
    }

    public void showList() {
        showList(xeMays);
    }

    @Override
    public void remove(PhuongTien phuongTien) {

        remove(xeMays, phuongTien);
        writePhuongTienListToCSV(xeMays,XE_MAY_CSV_FILE,false);
        System.out.println("Xóa Thành Công!!");
    }

    @Override
    public int searchByBienKiemSoat(String bienKiemSoat) {
        return searchByBienKiemSoat(xeMays, bienKiemSoat);
    }

}
