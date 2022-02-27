package oop_review.quan_ly_phuong_tien.models;

public class XeTai extends PhuongTien {

    private int taiTrong;

    public XeTai(String bienKiemSoat, HangSanXuat hangSanXuat, int namSanXuat,
        String chuSoHuu, int taiTrong) {
        super(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu);
        this.taiTrong = taiTrong;
    }

    public int getTaiTrong() {
        return taiTrong;
    }

    public void setTaiTrong(int taiTrong) {
        this.taiTrong = taiTrong;
    }

    @Override
    public String toString() {
        return "XeTai{" +
            super.toString() +
            ", congSuat=" + taiTrong +
            '}';
    }
}
