package case_study.furama_resort.controllers.people_controllers.impl;

import static case_study.furama_resort.utils.ValidatorInput.askUserToInputField;
import static oop_review.quan_ly_phuong_tien.controllers.MainController.scanner;

import case_study.furama_resort.controllers.people_controllers.IPeopleController;
import case_study.furama_resort.models.people_models.Customer;
import case_study.furama_resort.models.people_models.Person;
import case_study.furama_resort.models.enums.CustomerType;
import case_study.furama_resort.services.people_services.ICustomerService;
import case_study.furama_resort.services.people_services.impl.CustomerServiceImpl;
import case_study.furama_resort.utils.EnumUtils;
import case_study.furama_resort.utils.ValidatorInput;

public class CustomerControllerImpl implements IPeopleController {

    ICustomerService customerService = new CustomerServiceImpl();

    private CustomerType getCustomerTypeFromInput() {
        System.out.println("Enter Customer Type");
        EnumUtils.displayMenu(CustomerType.class);
        int choice = Integer.parseInt(scanner.nextLine());
        return CustomerType.values()[choice];
    }

    @Override
    public void create() {
        String name = askUserToInputField("Name", ValidatorInput.IS_NOT_AN_EMPTY_STRING);
        String dayOfBirth = askUserToInputField("Day Of Birth", ValidatorInput.IS_NOT_AN_EMPTY_STRING);
        boolean isMale = 1 == Integer.parseInt(askUserToInputField("Gender", ValidatorInput.IS_NOT_AN_EMPTY_STRING));
        String nationalID = askUserToInputField("National ID", ValidatorInput.IS_NOT_AN_EMPTY_STRING);
        String phoneNumber = askUserToInputField("Phone Number", ValidatorInput.IS_NOT_AN_EMPTY_STRING);
        String email = askUserToInputField("Email", ValidatorInput.IS_NOT_AN_EMPTY_STRING);
        String customerID = askUserToInputField("Customer ID", ValidatorInput.IS_NOT_AN_EMPTY_STRING);
        CustomerType customerType = getCustomerTypeFromInput();
        String address = askUserToInputField("Address ID", ValidatorInput.IS_NOT_AN_EMPTY_STRING);
        customerService.add(new Customer(name,
            dayOfBirth,
            isMale,
            nationalID,
            phoneNumber,
            email,
            customerID,
            customerType,
            address));
    }

    @Override
    public void display() {
        customerService.displayList(CustomerServiceImpl.customerList);    }

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
                    String newName = askUserToInputField("New Name", ValidatorInput.IS_NOT_AN_EMPTY_STRING);
                    object.setName(newName);
                    break;
                case 2:
                    String newDOB = askUserToInputField("New Day Of Birth", ValidatorInput.IS_NOT_AN_EMPTY_STRING);
                    object.setDayOfBirth(newDOB);
                    break;
                case 3:
                    boolean newGender = 1 == Integer.parseInt(askUserToInputField("New Gender", ValidatorInput.IS_NOT_AN_EMPTY_STRING));
                    object.setMale(newGender);
                    break;
                case 4:
                    String nationalID = askUserToInputField("New National ID", ValidatorInput.IS_NOT_AN_EMPTY_STRING);
                    object.setNationalID(nationalID);
                    break;
                case 5:
                    String phoneNumber = askUserToInputField("New Phone Number", ValidatorInput.IS_NOT_AN_EMPTY_STRING);
                    object.setPhoneNumber(phoneNumber);
                    break;
                case 6:
                    String email = askUserToInputField("New Email", ValidatorInput.IS_NOT_AN_EMPTY_STRING);
                    object.setEmail(email);
                    break;
                case 8:
                    CustomerType customerType = getCustomerTypeFromInput();
                    ((Customer) object).setCustomerType(customerType);
                    break;
                case 9:
                    String address = askUserToInputField("Address ID", ValidatorInput.IS_NOT_AN_EMPTY_STRING);
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