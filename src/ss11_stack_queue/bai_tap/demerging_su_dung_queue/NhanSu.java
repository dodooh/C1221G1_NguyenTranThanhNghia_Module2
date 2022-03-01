package ss11_stack_queue.bai_tap.demerging_su_dung_queue;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NhanSu {

    static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    private String hoTen;
    private String gioiTinh;
    private Date namSinh;
    private String diaChi;

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Date namSinh) {
        this.namSinh = namSinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public NhanSu(String hoTen, String gioiTinh, Date namSinh, String diaChi) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.namSinh = namSinh;
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "NhanSu{" +
            "hoTen='" + hoTen + '\'' +
            ", gioiTinh='" + gioiTinh + '\'' +
            ", namSinh=" + DATE_FORMAT.format(namSinh) +
            ", diaChi='" + diaChi + '\'' +
            '}';
    }
}
