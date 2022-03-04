package oop_review.quan_ly_phuong_tien.models;

public class Oto extends PhuongTien {

    private int soChoNgoi;
    private String kieuXe;

    public Oto(PhuongTien phuongTien,int soChoNgoi, String kieuXe ){
        super(phuongTien);
        this.soChoNgoi = soChoNgoi;
        this.kieuXe = kieuXe;
    }
    public Oto(String bienKiemSoat, HangSanXuat hangSanXuat, int namSanXuat, String chuSoHuu,
        int soChoNgoi, String kieuXe) {
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

    public String getKieuXe() {
        return kieuXe;
    }

    public void setKieuXe(String kieuXe) {
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
}
