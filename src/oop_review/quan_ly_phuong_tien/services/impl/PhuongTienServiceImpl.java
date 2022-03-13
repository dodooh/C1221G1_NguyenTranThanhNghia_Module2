package oop_review.quan_ly_phuong_tien.services.impl;


import java.util.List;
import oop_review.quan_ly_phuong_tien.models.PhuongTien;
import oop_review.quan_ly_phuong_tien.services.IServices;

public abstract class PhuongTienServiceImpl implements IServices {

    @Override
    public void showList(List<PhuongTien> list) {
        for (PhuongTien vehicle : list) {
            System.out.println(vehicle);
        }
    }

    @Override
    public void remove(List<PhuongTien> list, PhuongTien phuongTien) {
        list.remove(phuongTien);
    }

    protected int searchByBienKiemSoat(List<PhuongTien> list, String bienKiemSoat) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getBienKiemSoat().equals(bienKiemSoat)) {
                return i;
            }
        }
        return -1;
    }
}
