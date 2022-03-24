package case_study.furama_resort.services.impl;

import case_study.furama_resort.models.Customer;
import case_study.furama_resort.models.Person;
import case_study.furama_resort.services.ICustomerService;
import case_study.furama_resort.utils.ReadWriteCSVFile;
import java.util.LinkedList;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService {

    private static final String CUSTOMER_FILE_PATH = "src/case_study/furama_resort/data/customer.csv";
    public static List<Person> customerList;
    private static CustomerServiceImpl instance;

    static {
        customerList = new LinkedList<>();
        customerList = ReadWriteCSVFile.readCustomerListFromCSVFile(CUSTOMER_FILE_PATH);
    }

    private CustomerServiceImpl() {
    }

    public static CustomerServiceImpl getInstance() {
        if (instance == null) {
            instance = new CustomerServiceImpl();
        }
        return instance;
    }

    @Override
    public Customer getCustomerByID(String id) {
        for (Person customer : customerList) {
            if (((Customer) customer).getCustomerID().equals(id)) {
                return (Customer) customer;
            }
        }
        return null;
    }

    public void edit(int index, Person person) {
        customerList.set(index, person);
        ReadWriteCSVFile.writeListToCSVFile(customerList, CUSTOMER_FILE_PATH);
        System.out.println("✓Edit Successfully");
    }

    @Override
    public void displayList() {
        System.out.println("=========Customer List==========");
        if (customerList != null && customerList.size() != 0) {
            int index = 0;
            for (Person item : customerList) {
                System.out.printf("[%d] - %s", index++, item);
                System.out.println();
            }
        } else {
            System.out.println("!!!CUSTOMER LIST IS EMPTY!!!");
        }
    }

    @Override
    public void add(Person person) {
        customerList.add(person);
        ReadWriteCSVFile.writeListToCSVFile(customerList, CUSTOMER_FILE_PATH);
        System.out.println(person);
        System.out.println("✓Add Successfully!!");
    }
}
