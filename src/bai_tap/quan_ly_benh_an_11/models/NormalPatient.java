package bai_tap.quan_ly_benh_an_11.models;

import static bai_tap.quan_ly_benh_an_11.utils.ValidatorInputLibrary.simpleDateFormat;

import java.util.Date;

public class NormalPatient extends Patient {

    private double cost;

    public NormalPatient(int serial, String recordID, String patientID, String patientName, Date dateIn, Date dateOut,
        String reason, double cost) {
        super(serial, recordID, patientID, patientName, dateIn, dateOut, reason);
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "NormalPatient{" +
            super.toString() +
            "cost=" + String.format("%,.0f", cost) +
            '}';
    }

    @Override
    public String toCSVFormat() {
        return super.toCSVFormat() + "," + String.format("%.0f", cost);
    }

    @Override
    public String toTableFormat() {
        return super.toTableFormat() + String.format(" %-10.0f |", cost);
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
