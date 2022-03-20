package case_study.furama_resort.models;

public class Contract implements CSVable {

    private int contractNumber;
    private Booking booking;
    private double deposit;
    private double totalCost;
    private Customer customer;

    public Contract(int contractNumber, Booking booking, double deposit, double totalCost, Customer customer) {
        this.contractNumber = contractNumber;
        this.booking = booking;
        this.deposit = deposit;
        this.totalCost = totalCost;
        this.customer = customer;
    }

    public Contract(Contract another) {
        this.contractNumber = another.getContractNumber();
        this.booking = another.getBooking();
        this.deposit = another.getDeposit();
        this.totalCost = another.getTotalCost();
        this.customer = another.getCustomer();
    }

    public int getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Contract{" + "contractNumber=" + contractNumber + ", bookingID='" + booking.getBookingID() + '\''
            + ", deposit=" + String.format("%,.0f", deposit) + ", totalCost=" + String.format("%,.0f", totalCost)
            + ", customerID='" + customer.getCustomerID() + '\'' + '}';
    }

    @Override
    public String toCSVFormat() {
        return contractNumber + "," + booking.getBookingID() + "," + String.format("%.0f", deposit) + ","
            + String.format("%.0f", totalCost) + "," + customer.getCustomerID();
    }
}
