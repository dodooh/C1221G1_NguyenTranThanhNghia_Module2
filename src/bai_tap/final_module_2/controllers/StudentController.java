package bai_tap.final_module_2.controllers;

import static bai_tap.final_module_2.controllers.MainController.INVALID_INDEX_WARNING;
import static bai_tap.final_module_2.controllers.MainController.scanner;
import static bai_tap.final_module_2.utils.ReadInputFromKeyBoard.inputValidData;
import static bai_tap.final_module_2.utils.ReadInputFromKeyBoard.inputValidDateTime;

import bai_tap.final_module_2.models.Class;
import bai_tap.final_module_2.models.Student;
import bai_tap.final_module_2.models.enums.Gender;
import bai_tap.final_module_2.services.impl.ClassServiceImpl;
import bai_tap.final_module_2.services.impl.StudentStudentServiceImpl;
import bai_tap.final_module_2.utils.EnumUtils;
import bai_tap.final_module_2.utils.NotFoundStudentException;
import bai_tap.final_module_2.utils.ValidatorInputLibrary;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class StudentController {

    private final StudentStudentServiceImpl studentService = new StudentStudentServiceImpl();
    private final ClassServiceImpl classService = new ClassServiceImpl();

    public void add() {
        Date todayDate = null;
        try {
            todayDate = bai_tap.quan_ly_benh_an_11.utils.ValidatorInputLibrary.simpleDateFormat.parse(
                bai_tap.quan_ly_benh_an_11.utils.ValidatorInputLibrary.simpleDateFormat.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String name = inputValidData("Student Name (3-40 characters)", ValidatorInputLibrary.NAME_FORMAT);
        Date dOb = inputValidDateTime("Day Of Birth (dd/MM/yyyy)", todayDate);
        Gender gender = getGenderFromInput();
        String phoneNumber = inputPhoneNumberFromInput();
        String classID = inputClassIDFromInput();

        studentService.add(new Student(
            name,
            dOb,
            gender,
            phoneNumber,
            studentService.findGoodID(),
            classID

        ));
    }

    private String inputClassIDFromInput() {
        System.out.println("Enter Class");
        List<Class> classList = classService.getClassList();
        int i = 0;
        for (Class cl : classList) {
            System.out.printf("[%d] - [%s]\n", i++, cl);
        }
        int choice = -1;
        do {
            try {
                System.out.printf("Enter class INDEX 0-%d: ", classList.size());
                choice = Integer.parseInt(scanner.nextLine());
                return classList.get(choice).getClassID();
            } catch (NumberFormatException e) {
                System.out.println("!!!Invalid Format. Try again!!!");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("!!!Invalid Index. Try again!!!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        } while (true);
    }

    private String inputPhoneNumberFromInput() {
        String phoneNumber = null;
        do {
            phoneNumber = inputValidData("Phone Number (10 numbers start with 090/091)", ValidatorInputLibrary.PHONE_NUMBER);
            if (studentService.hasThisPhoneNumber(phoneNumber)) {
                System.out.println("!!!Phone number already being used!!!");
            } else {
                return phoneNumber;
            }
        } while (true);
    }


    private Gender getGenderFromInput() {
        int choice;
        System.out.println("Enter Gender");
        EnumUtils.displayMenu(Gender.class);
        System.out.println();
        do {
            String title = String.format("Your choice 0-%d:", (Gender.values().length - 1));
            choice = Integer.parseInt(inputValidData(title, ValidatorInputLibrary.ONE_NUMBER));
            if (choice < 0 || choice >= Gender.values().length) {
                System.out.print(INVALID_INDEX_WARNING);
            } else {
                return Gender.values()[choice];
            }
        } while (true);
    }


    public void display() {
        studentService.display();
    }


    public void remove() {
        studentService.display();
        int ID;
        Student foundStudent;
        do {
            ID = Integer.parseInt(inputValidData("Student ID to remove", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER));
            try {
                foundStudent = studentService.findStudentByID(ID);
                System.out.printf("FOUND: %s\n", foundStudent);
                System.out.print("Do you want to remove (YES/NO)? ");
                if ("YES".equalsIgnoreCase(scanner.nextLine())) {
                    studentService.remove(foundStudent);
                    studentService.display();
                }
                break;
            } catch (NotFoundStudentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public void search() {
        System.out.print("Enter Student-Name to Find: ");
        String input = scanner.nextLine();
        studentService.findStudentByName(input);
    }
}
