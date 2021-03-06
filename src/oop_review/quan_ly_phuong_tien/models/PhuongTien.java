package oop_review.quan_ly_phuong_tien.models;

import oop_review.quan_ly_phuong_tien.services.IServices;

public abstract class PhuongTien {


    private String bienKiemSoat;
    private HangSanXuat hangSanXuat;
    private int namSanXuat;
    private String chuSoHuu;

    PhuongTien() {

    }

    protected PhuongTien(PhuongTien origin) {
        this.bienKiemSoat = origin.bienKiemSoat;
        this.hangSanXuat = origin.hangSanXuat;
        this.namSanXuat = origin.namSanXuat;
        this.chuSoHuu = origin.chuSoHuu;
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
        return "bienKiemSoat='" + getBienKiemSoat() + '\'' +
            ", hangSanXuat='" + getHangSanXuat().getTenHangSanXuat() + '\'' +
            ", namSanXuat=" + getNamSanXuat() +
            ", chuSoHuu='" + getChuSoHuu() + '\'';
    }

    public abstract String getCSVFormat();
}
