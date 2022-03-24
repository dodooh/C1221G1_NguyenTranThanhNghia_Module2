package bai_tap.quan_ly_dien_thoai_9.controllers;

import java.util.Scanner;

public class MainController {

    public static final String NUMBER_FORMAT_WARNING = "!!!PLEASE ENTER A NUMBER!!!";
    public static final String INVALID_INDEX_WARNING = "!!!ENTER A VALID INDEX PLEASE!!!";
    public static final String YOUR_CHOICE = "Your choice: ";
    public static Scanner scanner = new Scanner(System.in);
    private final PhoneController phoneController = new PhoneController();

    public void displayMainMenu() {
        String MAIN_MENU_STR = "=======CELLPHONES MANAGEMENT=======\n"
            + "1. Add New\n"
            + "2. Delete\n"
            + "3. Display list\n"
            + "4. Search\n"
            + "0. Exit";
        do {
            System.out.println(MAIN_MENU_STR);
            try {
                System.out.print(YOUR_CHOICE);
                int chooseMenu = Integer.parseInt(scanner.nextLine());
                switch (chooseMenu) {
                    case 1:
                        phoneController.add();
                        break;
                    case 2:
                        phoneController.remove();
                        break;
                    case 3:
                        phoneController.display();
                        break;
                    case 4:
                        phoneController.search();
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
