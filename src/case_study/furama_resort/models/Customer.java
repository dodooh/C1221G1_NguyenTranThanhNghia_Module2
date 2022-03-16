package case_study.furama_resort.models;

import case_study.furama_resort.models.enums.CustomerType;

public class Customer extends Person {

    public static final String[] CUSTOMER_LEVEL = {"Diamond", "Platinum", "Gold", "Silver", "Member"};

    private CustomerType customerType;
    private String address;

    public Customer(String name, String dayOfBirth, boolean isMale, String nationalID, String phoneNumber, String email, String id,
        CustomerType customerType, String address) {
        super(name, dayOfBirth, isMale, nationalID, phoneNumber, email, id);
        this.customerType = customerType;
        this.address = address;
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
            super.toString() +
            ", customerType='" + customerType + '\'' +
            ", address='" + address + '\'' +
            '}';
    }
}
