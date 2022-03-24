package oop_review.oop_java_2.bai2_quan_ly_sach;

public class TapChi extends TaiLieu {

    private int soPhatHanh;
    private int thangPhatHanh;

    public TapChi(int maTaiLieu, String tenNhaXuatBan, int soBanPhatHanh, int soPhatHanh,
        int thangPhatHanh) {
        super(maTaiLieu, tenNhaXuatBan, soBanPhatHanh);
        this.soPhatHanh = soPhatHanh;
        this.thangPhatHanh = thangPhatHanh;
    }

    public int getSoPhatHanh() {
        return soPhatHanh;
    }

    public void setSoPhatHanh(int soPhatHanh) {
        this.soPhatHanh = soPhatHanh;
    }

    public int getThangPhatHanh() {
        return thangPhatHanh;
    }

    public void setThangPhatHanh(int thangPhatHanh) {
        this.thangPhatHanh = thangPhatHanh;
    }

    @Override
    public String toString() {
        return "TapChi{ " + super.toString() +
            ", soPhatHanh=" + soPhatHanh +
            ", thangPhatHanh=" + thangPhatHanh +
            '}';
    }
}
