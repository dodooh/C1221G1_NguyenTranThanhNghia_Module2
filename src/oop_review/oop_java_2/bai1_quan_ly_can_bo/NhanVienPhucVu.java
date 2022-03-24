package oop_review.oop_java_2.bai1_quan_ly_can_bo;

public class NhanVienPhucVu extends CanBo {

    private String congViec;

    public NhanVienPhucVu(String congViec) {
        this.congViec = congViec;
    }

    public NhanVienPhucVu(String hoTen, int namSinh, boolean isMale, String diaChi,
        String congViec) {
        super(hoTen, namSinh, isMale, diaChi);
        this.congViec = congViec;
    }

    public String getCongViec() {
        return congViec;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }

    @Override
    public String toString() {
        return "NhanVienPhucVu{" +
            super.toString() +
            ", congViec='" + congViec + '\'' +
            '}';
    }
}
