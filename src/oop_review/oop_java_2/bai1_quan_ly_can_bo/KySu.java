package oop_review.oop_java_2.bai1_quan_ly_can_bo;

public class KySu extends CanBo {

    private String nganhDaoTao;

    public KySu(String nganhDaoTao) {
        this.nganhDaoTao = nganhDaoTao;
    }

    public KySu(String hoTen, int namSinh, boolean isMale, String diaChi,
        String nganhDaoTao) {
        super(hoTen, namSinh, isMale, diaChi);
        this.nganhDaoTao = nganhDaoTao;
    }

    public String getNganhDaoTao() {
        return nganhDaoTao;
    }

    public void setNganhDaoTao(String nganhDaoTao) {
        this.nganhDaoTao = nganhDaoTao;
    }

    @Override
    public String toString() {
        return "KySu{" +
            super.toString() +
            ", nganhDaoTao='" + nganhDaoTao + '\'' +
            '}';
    }
}
