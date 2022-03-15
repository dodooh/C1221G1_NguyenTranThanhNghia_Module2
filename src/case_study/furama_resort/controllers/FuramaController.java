package case_study.furama_resort.controllers;

import case_study.furama_resort.controllers.impl.EmployeeController;
import java.util.Scanner;

public class FuramaController {
    EmployeeController employeeController = new EmployeeController();
    private final Scanner scanner = new Scanner(System.in);

    public void displayMainMenu() {
        do {
            System.out.println("===========Main Menu:===========\n" +
                "1.\tEmployee Management\n" +
                "2.\tCustomer Management\n" +
                "3.\tFacility Management \n" +
                "4.\tBooking Management\n" +
                "5.\tPromotion Management\n" +
                "6.\tExit");
            System.out.print("Choose a function: ");
            int chooseMenu = Integer.parseInt(scanner.nextLine());
            switch (chooseMenu) {
                case 1:
                    showEmployeeManagementMenu();
                    break;
                case 2:
                    showCustomerManagementMenu();
                    break;
                case 3:
                    showFacilityManagementMenu();
                    break;
                case 4:
                    showBookingManagementMenu();
                    break;
                case 5:
                    showPromotionManagementMenu();
                    break;
                case 0:
                    System.out.println("Exit Program");
                    System.exit(1);
                default:
                    System.err.println("Invalid Input");
                    break;
            }

        } while (true);
    }

    private void showEmployeeManagementMenu() {
        boolean flag = true;
        do {
            System.out.println("===========Employee Management===========\n" +
                "1.\tDisplay list employees\n" +
                "2.\tAdd new employee\n" +
                "3.\tEdit employee\n" +
                "4.\tReturn main menu");
            System.out.print("Choose a function: ");
            int chooseMenu = Integer.parseInt(scanner.nextLine());
            switch (chooseMenu) {
                case 1:
                    employeeController.display();
                    break;
                case 2:
                    employeeController.create();
                    break;
                case 3:
                    employeeController.edit();
                    break;
                default:
                    flag = false;
            }
        } while (flag);
    }

    private void showCustomerManagementMenu() {
        boolean flag = true;
        do {
            System.out.println("===========Customer Management===========\n" +
                "1.\tDisplay list customers\n" +
                "2.\tAdd new customer\n" +
                "3.\tEdit customer\n" +
                "4.\tReturn main menu");
            System.out.print("Choose a function: ");
            int chooseMenu = Integer.parseInt(scanner.nextLine());
            switch (chooseMenu) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    flag = false;
            }
        } while (flag);
    }

    private void showFacilityManagementMenu() {
        boolean flag = true;
        do {
            System.out.println("===========Facility Management===========\n" +
                "1.\tDisplay list facility\n" +
                "2.\tAdd new facility\n" +
                "3.\tDisplay list facility maintenance\n" +
                "4.\tReturn main menu");
            System.out.print("Choose a function: ");
            int chooseMenu = Integer.parseInt(scanner.nextLine());
            switch (chooseMenu) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    flag = false;
            }
        } while (flag);
    }

    private void showBookingManagementMenu() {
        boolean flag = true;

        do {
            System.out.println("===========Booking Management===========\n" +
                "1.\tAdd new facility\n" +
                "2.\tDisplay list booking\n" +
                "3.\tCreate new contracts\n" +
                "4.\tDisplay list contracts\n" +
                "5.\tEdit contracts\n" +
                "6.\tReturn main menu");
            System.out.print("Choose a function: ");
            int chooseMenu = Integer.parseInt(scanner.nextLine());
            switch (chooseMenu) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    flag = false;
            }
        } while (flag);
    }
    private void showPromotionManagementMenu() {

        boolean flag = true;

        do {
            System.out.println("===========Promotion Management===========\n" +
                "1.\tDisplay list customers use service\n" +
                "2.\tDisplay list customers get voucher\n" +
                "3.\tReturn main menu");
            System.out.print("Choose a function: ");
            int chooseMenu = Integer.parseInt(scanner.nextLine());
            switch (chooseMenu) {
                case 1:
                    break;
                case 2:
                    break;
                default:
                    flag = false;
            }
        } while (flag);
    }
}
