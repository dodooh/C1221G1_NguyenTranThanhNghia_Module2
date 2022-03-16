package case_study.furama_resort.models;

public class Contract {

    private int contractNumber;
    private String bookingID;
    private double deposit;
    private double totalCost;
    private String customerID;

    public Contract(int contractNumber, String bookingID, double deposit, double totalCost, String customerID) {
        this.contractNumber = contractNumber;
        this.bookingID = bookingID;
        this.deposit = deposit;
        this.totalCost = totalCost;
        this.customerID = customerID;
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "Contract{" +
            "contractNumber=" + contractNumber +
            ", bookingID='" + bookingID + '\'' +
            ", deposit=" + deposit +
            ", totalCost=" + totalCost +
            ", customerID='" + customerID + '\'' +
            '}';
    }
}
