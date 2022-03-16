package case_study.furama_resort.services.people_services.impl;

import case_study.furama_resort.models.people_models.Customer;
import case_study.furama_resort.models.people_models.Person;
import case_study.furama_resort.models.enums.CustomerType;
import case_study.furama_resort.services.people_services.ICustomerService;
import java.util.LinkedList;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService {

    public static List<Person> customerList = new LinkedList<>();

    static {
        customerList.add(new Customer("Phan", "20/01/1997", true, "200862169",
            "0935151766", "abc@gmail.com", "A101",
            CustomerType.DIAMOND, "Da Nang"));
        customerList.add(new Customer("Truong", "01/01/1997", true, "122323445",
            "093512342", "asdbc@gmail.com", "A151",
            CustomerType.SILVER, "Quang Nam"));
    }


    @Override
    public void edit(int index, Person person) {
        customerList.set(index, person);
    }


    @Override
    public void add(Person person) {
        customerList.add(person);
        System.out.println(person);
        System.out.println("Add Successfully!!");
    }
}
