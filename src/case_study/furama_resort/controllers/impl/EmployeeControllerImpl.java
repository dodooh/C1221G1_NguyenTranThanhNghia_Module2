package case_study.furama_resort.controllers.impl;

import static oop_review.quan_ly_phuong_tien.controllers.MainController.scanner;

import case_study.furama_resort.controllers.IEmployeeController;
import case_study.furama_resort.models.Employee;
import case_study.furama_resort.models.Person;
import case_study.furama_resort.models.enums.EmployeeLevel;
import case_study.furama_resort.models.enums.EmployeePosition;
import case_study.furama_resort.services.IEmployeeService;
import case_study.furama_resort.services.impl.EmployeeServiceImpl;
import case_study.furama_resort.utils.EnumUtils;

public class EmployeeControllerImpl extends PeopleControllerImpl implements IEmployeeController {

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

    private double getSalaryFromInput() {
        String salary = "";
        do {
            System.out.print("Enter Salary: ");
            salary = scanner.nextLine();
            if (false) { // Validator
                System.err.println("Salary is invalid. Retry!");
            } else {
                break;
            }
        } while (true);
        return Double.parseDouble(salary);
    }

    public void create() {
        String name = getNameFromInput();
        String dayOfBirth = getDayOfBirthFromInput();
        boolean isMale = getGenderFromInput();
        String nationalID = getNationalIDFromInput();
        String phoneNumber = getPhoneNumberFromInput();
        String email = getEmailFromInput();
        String ID = getIDFromInput();
        EmployeeLevel level = getEmployeeLevelFromInput();
        EmployeePosition position = getEmployeePositionFromInput();
        double salary = getSalaryFromInput();
        employeeService.add(new Employee(
            name,
            dayOfBirth,
            isMale,
            nationalID,
            phoneNumber,
            email,
            ID,
            level,
            position,
            salary));
    }

    @Override
    public void display() {
        super.display(EmployeeServiceImpl.employeeList);
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
                    EmployeeLevel level = getEmployeeLevelFromInput();
                    ((Employee) object).setLevel(level);
                    break;
                case 9:
                    EmployeePosition position = getEmployeePositionFromInput();
                    ((Employee) object).setPosition(position);
                    break;
                case 10:
                    double salary = getSalaryFromInput();
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
