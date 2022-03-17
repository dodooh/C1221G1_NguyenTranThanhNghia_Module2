package case_study.furama_resort.controllers.people_controllers.impl;

import static case_study.furama_resort.utils.ReadInputFromKeyBoard.askUserToInputValidData;
import static oop_review.quan_ly_phuong_tien.controllers.MainController.scanner;

import case_study.furama_resort.controllers.people_controllers.IPeopleController;
import case_study.furama_resort.models.people_models.Employee;
import case_study.furama_resort.models.people_models.Person;
import case_study.furama_resort.models.enums.EmployeeLevel;
import case_study.furama_resort.models.enums.EmployeePosition;
import case_study.furama_resort.services.people_services.IEmployeeService;
import case_study.furama_resort.services.people_services.impl.EmployeeServiceImpl;
import case_study.furama_resort.utils.EnumUtils;
import case_study.furama_resort.utils.ValidatorInputLibrary;

public class EmployeeControllerImpl implements IPeopleController {

    IEmployeeService employeeService = new EmployeeServiceImpl();

    private EmployeeLevel getEmployeeLevelFromInput() {
        System.out.println("Enter Employee Level");
        EnumUtils.displayMenu(EmployeeLevel.class);
        int choice = Integer.parseInt(scanner.nextLine());
        return EmployeeLevel.values()[choice];
    }

    private EmployeePosition getEmployeePositionFromInput() {
        System.out.println("Enter Employee Position");
        EnumUtils.displayMenu(EmployeePosition.class);
        int choice = Integer.parseInt(scanner.nextLine());
        return EmployeePosition.values()[choice];
    }

    public void create() {
        String name = askUserToInputValidData("Name", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
        String dayOfBirth = askUserToInputValidData("Day Of Birth", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
        boolean isMale = 1 == Integer.parseInt(askUserToInputValidData("Gender", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER));
        String nationalID = askUserToInputValidData("National ID", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
        String phoneNumber = askUserToInputValidData("Phone Number", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
        String email = askUserToInputValidData("Email", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
        String employeeID = askUserToInputValidData("Employee ID", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
        EmployeeLevel level = getEmployeeLevelFromInput();
        EmployeePosition position = getEmployeePositionFromInput();
        double salary = Double.parseDouble(askUserToInputValidData("Salary", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER));
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
        System.out.print("\nEnter Index of Employee to Edit: ");
        int index = Integer.parseInt(scanner.nextLine());  // Chua validator
        Person objectToEdit = EmployeeServiceImpl.employeeList.get(index);
        editing(objectToEdit);
        employeeService.edit(index, objectToEdit);
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
            + "[8] - Level,\n"
            + "[9] - Position,\n"
            + "[10]- Salary";
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
                case 7:
                    String employeeID = askUserToInputValidData("New Employee ID", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
                    ((Employee) object).setEmployeeID(employeeID);
                    break;
                case 8:
                    EmployeeLevel level = getEmployeeLevelFromInput();
                    ((Employee) object).setLevel(level);
                    break;
                case 9:
                    EmployeePosition position = getEmployeePositionFromInput();
                    ((Employee) object).setPosition(position);
                    break;
                case 10:
                    double salary = Double.parseDouble(askUserToInputValidData("New Salary", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER));
                    ((Employee) object).setSalary(salary);
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
