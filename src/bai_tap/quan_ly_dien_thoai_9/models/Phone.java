package bai_tap.quan_ly_dien_thoai_9.models;

public abstract class Phone {

    private int phoneID;
    private String phoneName;
    private double price;
    private int quantity;
    private String manufacture;

    public Phone(int phoneID, String phoneName, double price, int quantity, String manufacture) {
        this.phoneID = phoneID;
        this.phoneName = phoneName;
        this.price = price;
        this.quantity = quantity;
        this.manufacture = manufacture;
    }

    @Override
    public String toString() {
        return
            "phoneID=" + phoneID +
                ", phoneName='" + phoneName + '\'' +
                ", price=" + String.format("%.0f", price) +
                ", quantity=" + quantity +
                ", manufacture='" + manufacture + '\'';
    }

    public String toCSVFormat() {
        return phoneID + "," +
            phoneName + "," +
            price + "," +
            quantity + "," +
            manufacture;
    }


    public int getPhoneID() {
        return phoneID;
    }

    public void setPhoneID(int phoneID) {
        this.phoneID = phoneID;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }
}
