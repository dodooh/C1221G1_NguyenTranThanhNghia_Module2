package case_study.furama_resort.services.people_services.impl;

import case_study.furama_resort.models.people_models.Person;
import case_study.furama_resort.services.people_services.ICustomerService;
import case_study.furama_resort.utils.ReadWriteCSVFile;
import java.util.LinkedList;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService {

    private static final String CUSTOMER_FILE_PATH = "src/case_study/furama_resort/data/customer.csv";
    public static List<Person> customerList = new LinkedList<>();

    static {
        customerList = ReadWriteCSVFile.readCustomerListFromCSVFile(CUSTOMER_FILE_PATH);
    }


    @Override
    public void edit(int index, Person person) {
        customerList.set(index, person);
    }


    @Override
    public void displayList(List<Person> list) {
        System.out.println("=========CUSTOMER LIST==========");
        if (list != null && list.size() != 0) {
            int index = 0;
            for (Person item : list) {
                System.out.printf("[%d] = %s", index++, item);
                System.out.println();
            }
        } else {
            System.out.println("!!!Customer List not found.");
        }
    }

    @Override
    public void add(Person person) {
        customerList.add(person);
        System.out.println(person);
        System.out.println("Add Successfully!!");
    }
}
