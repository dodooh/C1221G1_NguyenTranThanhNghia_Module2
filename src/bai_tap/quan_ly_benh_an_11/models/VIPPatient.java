package bai_tap.quan_ly_benh_an_11.models;

import static bai_tap.quan_ly_benh_an_11.utils.ValidatorInputLibrary.simpleDateFormat;

import bai_tap.quan_ly_benh_an_11.models.enums.VIPType;
import java.util.Date;

public class VIPPatient extends Patient {

    private VIPType vipType;
    private Date dayExpired;

    public VIPPatient(int serial, String recordID, String patientID, String patientName, Date dateIn, Date dateOut, String reason,
        VIPType vipType, Date dayExpired) {
        super(serial, recordID, patientID, patientName, dateIn, dateOut, reason);
        this.vipType = vipType;
        this.dayExpired = dayExpired;
    }

    @Override
    public String toString() {
        return "VIPPatient{" +
            super.toString() +
            "vipType=" + vipType +
            ", dayExpired=" + simpleDateFormat.format(dayExpired) +
            '}';
    }

    @Override
    public String toCSVFormat() {
        return super.toCSVFormat() + "," + vipType + "," + simpleDateFormat.format(dayExpired);
    }

    @Override
    public String toTableFormat() {
        return super.toTableFormat() + String.format(" %-8s | %-10s |", vipType, simpleDateFormat.format(dayExpired));
    }

    public VIPType getVipType() {
        return vipType;
    }

    public void setVipType(VIPType vipType) {
        this.vipType = vipType;
    }

    public Date getDayExpired() {
        return dayExpired;
    }

    public void setDayExpired(Date dayExpired) {
        this.dayExpired = dayExpired;
    }
}
