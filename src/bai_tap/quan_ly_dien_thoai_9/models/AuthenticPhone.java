package bai_tap.quan_ly_dien_thoai_9.models;

import bai_tap.quan_ly_dien_thoai_9.models.enums.WarrantyRange;

public class AuthenticPhone extends Phone {

    private int warrantyTime;
    private WarrantyRange warrantyRange;

    public AuthenticPhone(int phoneID, String phoneName, double price, int quantity, String manufacture, int warrantyTime,
        WarrantyRange warrantyRange) {
        super(phoneID, phoneName, price, quantity, manufacture);
        this.warrantyTime = warrantyTime;
        this.warrantyRange = warrantyRange;
    }

    @Override
    public String toString() {
        return "AuthenticPhone{" +
            super.toString() +
            ", warrantyTime=" + warrantyTime +
            ", warrantyRange=" + warrantyRange +
            '}';
    }


    @Override
    public String toCSVFormat() {
        return super.toCSVFormat() + "," + warrantyTime + "," + warrantyRange;
    }

    public int getWarrantyTime() {
        return warrantyTime;
    }

    public void setWarrantyTime(int warrantyTime) {
        this.warrantyTime = warrantyTime;
    }

    public WarrantyRange getWarrantyRange() {
        return warrantyRange;
    }

    public void setWarrantyRange(WarrantyRange warrantyRange) {
        this.warrantyRange = warrantyRange;
    }
}
