package case_study.furama_resort.models;

public class Customer extends Person{
    public static final String[] CUSTOMER_LEVEL = {"Diamond", "Platinum", "Gold", "Silver", "Member"};

    private String customerType;
    private String address;

    public Customer(String name, String dayOfBirth, boolean isMale, String nationalID, String phoneNumber, String email, String id,
        String customerID, String customerType, String address) {
        super(name, dayOfBirth, isMale, nationalID, phoneNumber, email, id);
        this.customerType = customerType;
        this.address = address;
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

    @Override
    public String toString() {
        return "Customer{" +
            super.toString() +
            ", customerType='" + customerType + '\'' +
            ", address='" + address + '\'' +
            '}';
    }
}
