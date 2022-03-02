package oop_review.oop_java_1.nhap_xuat_thong_tin_xe;


public class Vehicle {

    private final double THUE_THAP = 0.01;
    private final double THUE_VUA = 0.03;
    private final double THUE_CAO = 0.05;

    private String bienSoXe;
    private int dungTich;
    private long giaXe;

    public Vehicle(String bienSoXe, int dungTich, long giaXe) {
        this.bienSoXe = bienSoXe;
        this.dungTich = dungTich;
        this.giaXe = giaXe;
    }

    Vehicle() {
    }

    public String getBienSoXe() {
        return bienSoXe;
    }

    public void setBienSoXe(String bienSoXe) {
        this.bienSoXe = bienSoXe;
    }

    public int getDungTich() {
        return dungTich;
    }

    public void setDungTich(int dungTich) {
        this.dungTich = dungTich;
    }

    public long getGiaXe() {
        return giaXe;
    }

    public void setGiaXe(long giaXe) {
        this.giaXe = giaXe;
    }

    double tinhThue() {
        double rate = THUE_THAP;
        if (dungTich > 200) {
            rate = THUE_CAO;
        } else if (dungTich >= 100) {
            rate = THUE_VUA;
        }
        return rate * giaXe;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
            "bienSoXe='" + bienSoXe + '\'' +
            ", dungTich=" + dungTich +
            ", giaXe=" + String.format("%,d", giaXe) +
            '}';
    }
}
