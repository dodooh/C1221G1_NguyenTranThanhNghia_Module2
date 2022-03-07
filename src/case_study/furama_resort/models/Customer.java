package case_study.furama_resort.models;

public class Customer extends Person{
    public static final String[] CUSTOMER_LEVEL = {"Diamond", "Platinum", "Gold", "Silver", "Member"};

    private String customerID;
    private String customerType;
    private String address;

    public Customer(String name, String dayOfBirth, boolean isMale, String nationalID, String phoneNumber, String email, String customerID,
        String customerType, String address) {
        super(name, dayOfBirth, isMale, nationalID, phoneNumber, email);
        this.customerID = customerID;
        this.customerType = customerType;
        this.address = address;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
