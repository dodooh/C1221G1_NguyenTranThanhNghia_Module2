package case_study.furama_resort.controllers.impl;

import static case_study.furama_resort.utils.ReadInputFromKeyBoard.inputValidData;
import static oop_review.quan_ly_phuong_tien.controllers.MainController.scanner;

import case_study.furama_resort.controllers.IPeopleController;
import case_study.furama_resort.models.Employee;
import case_study.furama_resort.models.Person;
import case_study.furama_resort.models.enums.EmployeeLevel;
import case_study.furama_resort.models.enums.EmployeePosition;
import case_study.furama_resort.services.IEmployeeService;
import case_study.furama_resort.services.impl.EmployeeServiceImpl;
import case_study.furama_resort.utils.EnumUtils;
import case_study.furama_resort.utils.ValidatorInputLibrary;

public class EmployeeControllerImpl implements IPeopleController {
    private static EmployeeControllerImpl instance;

    private EmployeeControllerImpl() {
    }

    public static EmployeeControllerImpl getInstance() {
        if (instance == null) {
            instance = new EmployeeControllerImpl();
        }
        return instance;
    }
    public static final String EXIT_CASE = "n";
    IEmployeeService employeeService = new EmployeeServiceImpl();

    private EmployeeLevel getEmployeeLevelFromInput() {
        int choice;
        System.out.println("Enter Employee Level");
        EnumUtils.displayMenu(EmployeeLevel.class);
        do {

            System.out.print("\nYour choice:");
            choice = Integer.parseInt(scanner.nextLine());
            if (choice < 0 || choice >= EmployeeLevel.values().length) {
                System.out.print("Invalid choice");
            } else {
                break;
            }
        } while (true);
        return EmployeeLevel.values()[choice];
    }

    private EmployeePosition getEmployeePositionFromInput() {
        int choice;
        System.out.println("Enter Employee Position");
        EnumUtils.displayMenu(EmployeePosition.class);
        do {

            System.out.print("\nYour choice:");
            choice = Integer.parseInt(scanner.nextLine());
            if (choice < 0 || choice >= EmployeePosition.values().length) {
                System.out.print("Invalid choice");
            } else {
                break;
            }
        } while (true);
        return EmployeePosition.values()[choice];
    }

    public void create() {
        String name = inputValidData("Name", ValidatorInputLibrary.STANDARD_NAME);
        String dayOfBirth = inputValidData("Day Of Birth (dd/mm/yyyy)", ValidatorInputLibrary.BIRTHDAY_FORMAT);
        boolean isMale = 1 == Integer.parseInt(inputValidData("Gender (1. Male, 2.Female)", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER));
        String nationalID = inputValidData("National ID", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
        String phoneNumber = inputValidData("Phone Number (0XXXXXXXXX)", ValidatorInputLibrary.PHONE_NUMBER);
        String email = inputValidData("Email (abczyx@gmail.com)", ValidatorInputLibrary.EMAIL_FORMAT);
        String employeeID = inputValidData("Employee ID", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
        EmployeeLevel level = getEmployeeLevelFromInput();
        EmployeePosition position = getEmployeePositionFromInput();
        double salary = Double.parseDouble(inputValidData("Salary", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER));
        employeeService.add(new Employee(
            name,
            dayOfBirth,
            isMale,
            nationalID,
            phoneNumber,
            email,
            employeeID,
            level,
            position,
            salary));
    }

    @Override
    public void display() {
        employeeService.displayList(EmployeeServiceImpl.employeeList);
    }

    @Override
    public void edit() {
        System.out.println("----------EDITING MODE-----------");
        this.display();
        do {
            try {
                System.out.print("\nEnter Index of Employee to Edit: ");
                int index = Integer.parseInt(scanner.nextLine()); // Chua validator
                Person objectToEdit = EmployeeServiceImpl.employeeList.get(index);
                editing(objectToEdit);
                employeeService.edit(index, objectToEdit);
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("!!!Please Enter A Valid Index!!!");
            }
        } while (true);
    }

    private void editing(Person object) {
        System.out.println(object);
        String menu =
            "[1] - Name,\n"
                + "[2] - Day Of Birth,\n"
                + "[3] - Gender,\n"
                + "[4] - National ID,\n"
                + "[5] - Phone Number,\n"
                + "[6] - Email,\n"
                + "[7] - ID,\n"
                + "[8] - Level,\n"
                + "[9] - Position,\n"
                + "[10]- Salary";
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
                    boolean newGender = 1 == Integer.parseInt(inputValidData("New Gender (1. Male, 2.Female)", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER));
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
                    EmployeeLevel level = getEmployeeLevelFromInput();
                    ((Employee) object).setLevel(level);
                    break;
                case 8:
                    EmployeePosition position = getEmployeePositionFromInput();
                    ((Employee) object).setPosition(position);
                    break;
                case 9:
                    double salary = Double.parseDouble(inputValidData("New Salary", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER));
                    ((Employee) object).setSalary(salary);
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
}
