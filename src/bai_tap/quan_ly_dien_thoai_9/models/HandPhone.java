package bai_tap.quan_ly_dien_thoai_9.models;

import bai_tap.quan_ly_dien_thoai_9.models.enums.Status;

public class HandPhone extends Phone {

    private String fromNation;
    private Status status;

    public HandPhone(int phoneID, String phoneName, double price, int quantity, String manufacture, String fromNation,
        Status status) {
        super(phoneID, phoneName, price, quantity, manufacture);
        this.fromNation = fromNation;
        this.status = status;
    }

    @Override
    public String toString() {
        return "HandPhone{" +
            super.toString() +
            ", fromNation='" + fromNation + '\'' +
            ", status=" + status +
            '}';
    }

    @Override
    public String toCSVFormat() {
        return super.toCSVFormat() + "," + fromNation + "," + status;
    }

    public String getFromNation() {
        return fromNation;
    }

    public void setFromNation(String fromNation) {
        this.fromNation = fromNation;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
