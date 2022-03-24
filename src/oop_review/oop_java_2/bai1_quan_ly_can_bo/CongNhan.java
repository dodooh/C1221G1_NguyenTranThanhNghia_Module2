package oop_review.oop_java_2.bai1_quan_ly_can_bo;

public class CongNhan extends CanBo {

    private int bac;

    public CongNhan() {
        this.bac = 1;
    }

    public CongNhan(String hoTen, int namSinh, boolean isMale, String diaChi, int bac) {
        super(hoTen, namSinh, isMale, diaChi);
        this.bac = bac;
    }

    public int getBac() {
        return bac;
    }

    public void setBac(int bac) {
        this.bac = bac;
    }

    @Override
    public String toString() {
        return "CongNhan{" +
            super.toString() +
            ", bac=" + bac +
            '}';
    }
}
