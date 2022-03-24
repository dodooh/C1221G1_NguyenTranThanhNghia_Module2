package oop_review.oop_java_2.bai2_quan_ly_sach;

import java.util.Date;

public class Bao extends TaiLieu {

    private Date ngayPhatHanh;

    public Bao(int maTaiLieu, String tenNhaXuatBan, int soBanPhatHanh, Date ngayPhatHanh) {
        super(maTaiLieu, tenNhaXuatBan, soBanPhatHanh);
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public Date getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(Date ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

    @Override
    public String toString() {
        return "Bao{ " +
            super.toString() +
            ", ngayPhatHanh=" + ngayPhatHanh +
            '}';
    }
}
