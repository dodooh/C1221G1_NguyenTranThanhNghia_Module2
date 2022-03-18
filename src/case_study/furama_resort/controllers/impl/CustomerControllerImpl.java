package case_study.furama_resort.controllers.impl;

import static case_study.furama_resort.utils.ReadInputFromKeyBoard.inputValidData;
import static oop_review.quan_ly_phuong_tien.controllers.MainController.scanner;

import case_study.furama_resort.controllers.IPeopleController;
import case_study.furama_resort.models.Customer;
import case_study.furama_resort.models.Person;
import case_study.furama_resort.models.enums.CustomerType;
import case_study.furama_resort.services.ICustomerService;
import case_study.furama_resort.services.impl.CustomerServiceImpl;
import case_study.furama_resort.utils.EnumUtils;
import case_study.furama_resort.utils.ValidatorInputLibrary;

public class CustomerControllerImpl implements IPeopleController {

    private static CustomerControllerImpl instance;

    private CustomerControllerImpl() {
    }

    public static CustomerControllerImpl getInstance() {
        if (instance == null) {
            instance = new CustomerControllerImpl();
        }
        return instance;
    }

    public static final String EXIT_CASE = "n";
    ICustomerService customerService = CustomerServiceImpl.getInstance();

    @Override
    public void create() {
        String name = inputValidData("Name", ValidatorInputLibrary.STANDARD_NAME);
        String dayOfBirth = inputValidData("Day Of Birth (dd/mm/yyyy)", ValidatorInputLibrary.BIRTHDAY_FORMAT);
        boolean isMale = 1 == Integer.parseInt(inputValidData("Gender (1. Male, 2.Female)", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER));
        String nationalID = inputValidData("National ID", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
        String phoneNumber = inputValidData("Phone Number (0XXXXXXXXX)", ValidatorInputLibrary.PHONE_NUMBER);
        String email = inputValidData("Email (abczyx@gmail.com)", ValidatorInputLibrary.EMAIL_FORMAT);
        String customerID = inputValidData("Customer ID", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
        CustomerType customerType = getCustomerTypeFromInput();
        String address = inputValidData("Address ID", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
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
        customerService.displayList(CustomerServiceImpl.customerList);
    }

    @Override
    public void edit() {
        System.out.println("----------CUSTOMER EDITING MODE-----------");
        this.display();
        do {
            try {
                System.out.print("\nEnter Index of Customer to Edit: ");
                int index = Integer.parseInt(scanner.nextLine()); // Chua validator
                Person objectToEdit = CustomerServiceImpl.customerList.get(index);
                editing(objectToEdit);
                customerService.edit(index, objectToEdit);
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("!!!Please Enter A Valid Index!!!");
            }
        } while (true);


    }

    private void editing(Person object) {
        System.out.println(object);
        String menu = "[1] - Name,\n"
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
                    String newName = inputValidData("New Name", ValidatorInputLibrary.STANDARD_NAME);
                    object.setName(newName);
                    break;
                case 2:
                    String newDOB = inputValidData("New Day Of Birth", ValidatorInputLibrary.BIRTHDAY_FORMAT);
                    object.setDayOfBirth(newDOB);
                    break;
                case 3:
                    boolean newGender = 1 == Integer.parseInt(
                        inputValidData("New Gender (1. Male, 2.Female)", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER));
                    object.setMale(newGender);
                    break;
                case 4:
                    String nationalID = inputValidData("New National ID", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
                    object.setNationalID(nationalID);
                    break;
                case 5:
                    String phoneNumber = inputValidData("New Phone Number", ValidatorInputLibrary.PHONE_NUMBER);
                    object.setPhoneNumber(phoneNumber);
                    break;
                case 6:
                    String email = inputValidData("New Email (abczyx@gmail.com)", ValidatorInputLibrary.EMAIL_FORMAT);
                    object.setEmail(email);
                    break;
                case 7:
                    CustomerType customerType = getCustomerTypeFromInput();
                    ((Customer) object).setCustomerType(customerType);
                    break;
                case 8:
                    String address = inputValidData("Address ID", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
                    ((Customer) object).setAddress(address);
                    break;
                default:
                    System.out.println("!!!Invalid input!!!");
            }
            System.out.print("Keep Editing?(y/n) ");
            String s = scanner.nextLine();
            if (EXIT_CASE.equalsIgnoreCase(s)) {
                break;
            }
        } while (true);
    }
    private CustomerType getCustomerTypeFromInput() {
        int choice;
        System.out.println("Enter Customer Type");
        EnumUtils.displayMenu(CustomerType.class);
        do {

            System.out.print("\nYour choice:");
            choice = Integer.parseInt(scanner.nextLine());
            if (choice < 0 || choice >= CustomerType.values().length) {
                System.out.println("Invalid choice");
            } else {
                break;
            }
        } while (true);
        return CustomerType.values()[choice];
    }

}