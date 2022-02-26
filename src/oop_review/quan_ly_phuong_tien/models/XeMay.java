package oop_review.quan_ly_phuong_tien.models;

public class XeMay extends PhuongTien {

    private int congSuat;

    public XeMay(String bienKiemSoat, HangSanXuat hangSanXuat, int namSanXuat,
        String chuSoHuu, int congSuat) {
        super(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu);
        this.congSuat = congSuat;
    }

    public int getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(int congSuat) {
        this.congSuat = congSuat;
    }
}
