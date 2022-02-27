package oop_review.oop_java_2.bai1_quan_ly_can_bo;

public class CanBo {

    private String hoTen;
    private int namSinh;
    private boolean isMale;
    private String diaChi;

    public CanBo() {
    }

    public CanBo(String hoTen, int namSinh, boolean isMale, String diaChi) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.isMale = isMale;
        this.diaChi = diaChi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return
            "hoTen='" + hoTen + '\'' +
                ", namSinh='" + namSinh + '\'' +
                ", Nam=" + isMale +
                ", diaChi='" + diaChi + '\'';
    }
}
