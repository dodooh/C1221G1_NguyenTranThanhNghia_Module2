package case_study.furama_resort.controllers.impl;

import static oop_review.quan_ly_phuong_tien.controllers.MainController.scanner;

import case_study.furama_resort.controllers.ICustomerController;
import case_study.furama_resort.models.Customer;
import case_study.furama_resort.models.Employee;
import case_study.furama_resort.models.Person;
import case_study.furama_resort.models.enums.CustomerType;
import case_study.furama_resort.models.enums.EmployeeLevel;
import case_study.furama_resort.models.enums.EmployeePosition;
import case_study.furama_resort.services.ICustomerService;
import case_study.furama_resort.services.impl.CustomerServiceImpl;
import case_study.furama_resort.utils.EnumUtils;

public class CustomerControllerImpl extends PeopleControllerImpl implements ICustomerController {

    ICustomerService customerService = new CustomerServiceImpl();

    private CustomerType getCustomerTypeFromInput() {
        System.out.println("Enter Customer Type");
        EnumUtils.displayMenu(CustomerType.class);
        int choice = Integer.parseInt(scanner.nextLine());
        return CustomerType.values()[choice];
    }

    @Override
    public void create() {
        String name = getNameFromInput();
        String dayOfBirth = getDayOfBirthFromInput();
        boolean isMale = getGenderFromInput();
        String nationalID = getNationalIDFromInput();
        String phoneNumber = getPhoneNumberFromInput();
        String email = getEmailFromInput();
        String ID = getIDFromInput();
        CustomerType customerType = getCustomerTypeFromInput();
        String address = getAddressFromInput();
        customerService.add(new Customer(name,
            dayOfBirth,
            isMale,
            nationalID,
            phoneNumber,
            email,
            ID,
            customerType,
            address));
    }

    private String getAddressFromInput() {
        String address;
        do {
            System.out.print("Enter Address: ");
            address = scanner.nextLine();
            if (false) { // Validator
                System.err.println("Address is invalid. Retry!");
            } else {
                break;
            }
        } while (true);
        return address;
    }

    @Override
    public void display() {
        display(CustomerServiceImpl.customerList);
    }

    @Override
    public void edit() {
        System.out.println("----------CUSTOMER EDITING MODE-----------");
        this.display();
        System.out.print("\nEnter Index of Customer to Edit: ");
        int index = Integer.parseInt(scanner.nextLine()); // Chua validator
        Person objectToEdit = CustomerServiceImpl.customerList.get(index);
        editing(objectToEdit);
        customerService.edit(index, objectToEdit);
    }

    private void editing(Person object) {
        System.out.println(object);
        String menu = "[1] Name,\n"
            + "[2] - Day Of Birth,\n"
            + "[3] - Gender,\n"
            + "[4] - National ID,\n"
            + "[5] - Phone Number,\n"
            + "[6] - Email,\n"
            + "[7] - ID,\n"
            + "[8] - Customer Type,\n"
            + "[9] - Address,\n";
        do {
            System.out.println(menu);
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    String newName = getNameFromInput();
                    object.setName(newName);
                    break;
                case 2:
                    String newDOB = getDayOfBirthFromInput();
                    object.setDayOfBirth(newDOB);
                    break;
                case 3:
                    boolean newGender = getGenderFromInput();
                    object.setMale(newGender);
                    break;
                case 4:
                    String nationalID = getNationalIDFromInput();
                    object.setNationalID(nationalID);
                    break;
                case 5:
                    String phoneNumber = getPhoneNumberFromInput();
                    object.setPhoneNumber(phoneNumber);
                    break;
                case 6:
                    String email = getEmailFromInput();
                    object.setEmail(email);
                    break;
                case 7:
                    String id = getIDFromInput();
                    object.setId(id);
                    break;
                case 8:
                    CustomerType customerType = getCustomerTypeFromInput();
                    ((Customer) object).setCustomerType(customerType);
                    break;
                case 9:
                    String address = getAddressFromInput();
                    ((Customer) object).setAddress(address);
                    break;
                default:
                    System.err.println("Invalid input");
            }
            System.out.print("Keep Editting?(y/n) ");
            String s = scanner.nextLine();
            if ("n".equalsIgnoreCase(s)) {
                break;
            }
        } while (true);
    }
}