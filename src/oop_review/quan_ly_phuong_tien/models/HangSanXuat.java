package oop_review.quan_ly_phuong_tien.models;

public final class HangSanXuat {

    private final String maHangSanXuat;
    private final String tenHangSanXuat;
    private final String tenQuocGia;

    public HangSanXuat(String maHangSanXuat, String tenHangSanXuat, String tenQuocGia) {
        this.maHangSanXuat = maHangSanXuat;
        this.tenHangSanXuat = tenHangSanXuat;
        this.tenQuocGia = tenQuocGia;
    }

    public String getMaHangSanXuat() {
        return maHangSanXuat;
    }

    public String getTenHangSanXuat() {
        return tenHangSanXuat;
    }

    public String getTenQuocGia() {
        return tenQuocGia;
    }
}
