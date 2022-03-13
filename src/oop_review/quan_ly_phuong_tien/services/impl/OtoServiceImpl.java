package oop_review.quan_ly_phuong_tien.services.impl;

import java.util.ArrayList;
import java.util.List;
import oop_review.quan_ly_phuong_tien.models.PhuongTien;
import oop_review.quan_ly_phuong_tien.services.IServices;
import static oop_review.quan_ly_phuong_tien.utils.ReadAndWriteFile.writePhuongTienListToCSV;
import static oop_review.quan_ly_phuong_tien.utils.ReadAndWriteFile.readOtoListFromFile;

public class OtoServiceImpl extends PhuongTienServiceImpl implements IServices {

    static private final String OTO_CSV_FILE = "src/oop_review/quan_ly_phuong_tien/data/oto.csv";
    static List<PhuongTien> otos = new ArrayList<>();

    static {
        otos = readOtoListFromFile(OTO_CSV_FILE);
    }

    @Override
    public void add(PhuongTien newPhuongTien) {
        otos.add(newPhuongTien);
        writePhuongTienListToCSV(otos, OTO_CSV_FILE, false);
        System.out.println("Thêm thành công: " + newPhuongTien);
    }

    @Override
    public PhuongTien get(int index) {
        return otos.get(index);
    }

    @Override
    public void showList() {
        this.showList(otos);
    }

    @Override
    public void remove(PhuongTien phuongTien) {
        remove(otos, phuongTien);
        writePhuongTienListToCSV(otos, OTO_CSV_FILE, false);
        System.out.println("Xóa thành công!!");
    }

    @Override
    public int searchByBienKiemSoat(String bienKiemSoat) {
        return searchByBienKiemSoat(otos, bienKiemSoat);
    }


}
