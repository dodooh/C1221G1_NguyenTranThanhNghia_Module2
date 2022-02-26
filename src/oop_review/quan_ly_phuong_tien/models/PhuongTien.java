package oop_review.quan_ly_phuong_tien.models;

import oop_review.quan_ly_phuong_tien.services.IServices;

public class PhuongTien {

    private String bienKiemSoat;
    private HangSanXuat hangSanXuat;
    private int namSanXuat;
    private String chuSoHuu;

    PhuongTien() {

    }

    public PhuongTien(String bienKiemSoat, HangSanXuat hangSanXuat, int namSanXuat,
        String chuSoHuu) {
        this.bienKiemSoat = bienKiemSoat;
        this.hangSanXuat = hangSanXuat;
        this.namSanXuat = namSanXuat;
        this.chuSoHuu = chuSoHuu;
    }

    public String getBienKiemSoat() {
        return bienKiemSoat;
    }

    public void setBienKiemSoat(String bienKiemSoat) {
        this.bienKiemSoat = bienKiemSoat;
    }

    public HangSanXuat getHangSanXuat() {
        return hangSanXuat;
    }

    public void setHangSanXuat(HangSanXuat hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(int namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getChuSoHuu() {
        return chuSoHuu;
    }

    public void setChuSoHuu(String chuSoHuu) {
        this.chuSoHuu = chuSoHuu;
    }

    @Override
    public String toString() {
        return "PhuongTien{" +
            "bienKiemSoat='" + bienKiemSoat + '\'' +
            ", hangSanXuat=" + hangSanXuat +
            ", namSanXuat=" + namSanXuat +
            ", chuSoHuu='" + chuSoHuu + '\'' +
            '}';
    }
}
