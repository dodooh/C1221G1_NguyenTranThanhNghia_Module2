package case_study.furama_resort.controllers.people_controllers.impl;

import static case_study.furama_resort.utils.ReadInputFromKeyBoard.askUserToInputValidData;
import static oop_review.quan_ly_phuong_tien.controllers.MainController.scanner;

import case_study.furama_resort.controllers.people_controllers.IPeopleController;
import case_study.furama_resort.models.people_models.Customer;
import case_study.furama_resort.models.people_models.Person;
import case_study.furama_resort.models.enums.CustomerType;
import case_study.furama_resort.services.people_services.ICustomerService;
import case_study.furama_resort.services.people_services.impl.CustomerServiceImpl;
import case_study.furama_resort.utils.EnumUtils;
import case_study.furama_resort.utils.ValidatorInputLibrary;

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
        String name = askUserToInputValidData("Name", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
        String dayOfBirth = askUserToInputValidData("Day Of Birth", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
        boolean isMale = 1 == Integer.parseInt(askUserToInputValidData("Gender", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER));
        String nationalID = askUserToInputValidData("National ID", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
        String phoneNumber = askUserToInputValidData("Phone Number", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
        String email = askUserToInputValidData("Email", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
        String customerID = askUserToInputValidData("Customer ID", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
        CustomerType customerType = getCustomerTypeFromInput();
        String address = askUserToInputValidData("Address ID", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
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
                    String newName = askUserToInputValidData("New Name", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
                    object.setName(newName);
                    break;
                case 2:
                    String newDOB = askUserToInputValidData("New Day Of Birth", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
                    object.setDayOfBirth(newDOB);
                    break;
                case 3:
                    boolean newGender = 1 == Integer.parseInt(askUserToInputValidData("New Gender", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER));
                    object.setMale(newGender);
                    break;
                case 4:
                    String nationalID = askUserToInputValidData("New National ID", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
                    object.setNationalID(nationalID);
                    break;
                case 5:
                    String phoneNumber = askUserToInputValidData("New Phone Number", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
                    object.setPhoneNumber(phoneNumber);
                    break;
                case 6:
                    String email = askUserToInputValidData("New Email", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
                    object.setEmail(email);
                    break;
                case 8:
                    CustomerType customerType = getCustomerTypeFromInput();
                    ((Customer) object).setCustomerType(customerType);
                    break;
                case 9:
                    String address = askUserToInputValidData("Address ID", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
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