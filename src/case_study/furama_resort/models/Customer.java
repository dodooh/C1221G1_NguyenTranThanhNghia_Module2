package case_study.furama_resort.models;

import case_study.furama_resort.models.enums.CustomerType;

public class Customer extends Person {

    private String customerID;
    private CustomerType customerType;
    private String address;

    public Customer(String name, String dayOfBirth, boolean isMale, String nationalID, String phoneNumber, String email,
        String customerID,
        CustomerType customerType, String address) {
        super(name, dayOfBirth, isMale, nationalID, phoneNumber, email);
        this.customerID = customerID;
        this.customerType = customerType;
        this.address = address;
    }

    public Customer(Customer anotherCustomer) {
        this.setName(anotherCustomer.getName());
        this.setDayOfBirth(anotherCustomer.getDayOfBirth());
        this.setMale(anotherCustomer.isMale());
        this.setNationalID(anotherCustomer.getNationalID());
        this.setPhoneNumber(anotherCustomer.getPhoneNumber());
        this.setEmail(anotherCustomer.getEmail());
        this.customerID = anotherCustomer.getCustomerID();
        this.customerType = anotherCustomer.getCustomerType();
        this.address = anotherCustomer.getAddress();
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
            "customerID=" + customerID +
            super.toString() +
            ", customerType='" + customerType + '\'' +
            ", address='" + address + '\'' +
            '}';
    }

    @Override
    public String toCSVFormat() {
        return super.toCSVFormat() + "," + customerID + "," + customerType + "," + address;
    }
}
