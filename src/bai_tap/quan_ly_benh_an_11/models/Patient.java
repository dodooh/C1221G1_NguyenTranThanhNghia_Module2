package bai_tap.quan_ly_benh_an_11.models;

import static bai_tap.quan_ly_benh_an_11.utils.ValidatorInputLibrary.simpleDateFormat;

import java.util.Date;

public abstract class Patient {

    private int serial;
    private String recordID;
    private String patientID;
    private String patientName;
    private Date dateIn;
    private Date dateOut;
    private String reason;

    public Patient(int serial, String recordID, String patientID, String patientName, Date dateIn, Date dateOut, String reason) {
        this.serial = serial;
        this.recordID = recordID;
        this.patientID = patientID;
        this.patientName = patientName;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.reason = reason;
    }

    @Override
    public String toString() {
        return
            "serial=" + serial +
                ", recordID='" + recordID + '\'' +
                ", patientID='" + patientID + '\'' +
                ", patientName='" + patientName + '\'' +
                ", dateIn=" + simpleDateFormat.format(dateIn) +
                ", dateOut=" + simpleDateFormat.format(dateOut) +
                ", reason='" + reason + '\'';
    }

    public String toCSVFormat() {
        return
            serial + "," +
                recordID + "," +
                patientID + "," +
                patientName + "," +
                simpleDateFormat.format(dateIn) + "," +
                simpleDateFormat.format(dateOut) + "," +
                reason;
    }

    public String toTableFormat() {
        return String.format(" %-3d | %-8s | %-9s | %-20s | %-10s | %-10s | %-20s |",
            serial,
            recordID,
            patientID,
            patientName,
            simpleDateFormat.format(dateIn),
            simpleDateFormat.format(dateOut),
            reason
        );
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getRecordID() {
        return recordID;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
