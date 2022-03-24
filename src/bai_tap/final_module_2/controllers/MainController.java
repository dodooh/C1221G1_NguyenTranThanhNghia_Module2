package bai_tap.final_module_2.controllers;

import bai_tap.final_module_2.services.impl.TeacherServiceImpl;
import java.util.Scanner;

public class MainController {

    public static final String NUMBER_FORMAT_WARNING = "!!!PLEASE ENTER A NUMBER!!!";
    public static final String INVALID_INDEX_WARNING = "!!!ENTER A VALID INDEX PLEASE!!!";
    public static final String YOUR_CHOICE = "Your choice: ";
    public static Scanner scanner = new Scanner(System.in);
    private final StudentController studentController = new StudentController();
    private final TeacherServiceImpl teacherService = new TeacherServiceImpl();

    public void displayMainMenu() {
        String MAIN_MENU_STR = "=======STUDENT MANAGEMENT PROGRAM=======\n"
            + "1. Add New Student\n"
            + "2. Delete Student\n"
            + "3. Display List Student\n"
            + "4. Display Teacher Information\n"
            + "5. Search Student\n"
            + "0. Exit";
        do {
            System.out.println(MAIN_MENU_STR);
            try {
                System.out.print(YOUR_CHOICE);
                int chooseMenu = Integer.parseInt(scanner.nextLine());
                switch (chooseMenu) {
                    case 1:
                        studentController.add();
                        break;
                    case 2:
                        studentController.remove();
                        break;
                    case 3:
                        studentController.display();
                        break;
                    case 4:
                        teacherService.display();
                        break;
                    case 5:
                        studentController.search();
                        break;
                    case 0:
                        System.out.println("Exit Program");
                        System.exit(1);
                    default:
                        System.err.println(INVALID_INDEX_WARNING);
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(NUMBER_FORMAT_WARNING);
            }
        } while (true);
    }

}
