package oop_review.quan_ly_phuong_tien.models;

public class Oto extends PhuongTien {
    public enum KieuXe {
        XE_KHACH,
        XE_DU_LICH
    }

    private int soChoNgoi;
    private KieuXe kieuXe;

    public Oto(String bienKiemSoat, HangSanXuat hangSanXuat, int namSanXuat, String chuSoHuu,
        int soChoNgoi, KieuXe kieuXe) {
        super(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu);
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    public KieuXe getKieuXe() {
        return kieuXe;
    }

    public void setKieuXe(KieuXe kieuXe) {
        this.kieuXe = kieuXe;
    }

    @Override
    public String toString() {
        return "Oto{" +
            super.toString() +
            ", soChoNgoi=" + soChoNgoi +
            ", kieuXe='" + kieuXe + '\'' +
            '}';
    }
    @Override
    public String getCSVFormat() {
        return getBienKiemSoat() + "," + getHangSanXuat().getTenHangSanXuat() + "," + getNamSanXuat()
            + "," + getChuSoHuu() + "," + getSoChoNgoi() + "," + getKieuXe().name();
    }
}
