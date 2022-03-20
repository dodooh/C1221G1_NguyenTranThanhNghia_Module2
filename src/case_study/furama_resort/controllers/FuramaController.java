package case_study.furama_resort.controllers;

import java.util.Scanner;

public class FuramaController {

    public static final String INVALID_INDEX_WARNING = "!!!ENTER A VALID INDEX PLEASE!!!";
    private final Scanner scanner = new Scanner(System.in);
    private final EmployeeController employeeController = EmployeeController.getInstance();
    private final CustomerController customerController = CustomerController.getInstance();
    private final FacilityController facilityController = FacilityController.getInstance();
    private final BookingController bookingController = BookingController.getInstance();
    private final ContractController contractController = ContractController.getInstance();
    private final PromotionController promotionController = PromotionController.getInstance();
    private int chooseMenu;

    public void displayMainMenu() {
        do {
            System.out.println("===========Main Menu:===========\n" +
                "1.\tEmployee Management\n" +
                "2.\tCustomer Management\n" +
                "3.\tFacility Management \n" +
                "4.\tBooking Management\n" +
                "5.\tPromotion Management\n" +
                "0.\tExit");
            try {
                System.out.print("Your choice: ");
                chooseMenu = Integer.parseInt(scanner.nextLine());
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
                        System.err.println(INVALID_INDEX_WARNING);
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
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
                "0.\tReturn main menu");
            try {
                System.out.print("Your choice: ");
                chooseMenu = Integer.parseInt(scanner.nextLine());
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
                    case 0:
                        System.out.println("Back To Main Menu");
                        flag = false;
                        break;
                    default:
                        System.out.println(INVALID_INDEX_WARNING);
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
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
                "0.\tReturn main menu");
            try {
                System.out.print("Your choice: ");
                chooseMenu = Integer.parseInt(scanner.nextLine());
                switch (chooseMenu) {
                    case 1:
                        customerController.display();
                        break;
                    case 2:
                        customerController.create();
                        break;
                    case 3:
                        customerController.edit();
                        break;
                    case 0:
                        System.out.println("Back To Main Menu");
                        flag = false;
                        break;
                    default:
                        System.out.println(INVALID_INDEX_WARNING);
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
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
                "0.\tReturn main menu");
            try {
                System.out.print("Your choice: ");
                chooseMenu = Integer.parseInt(scanner.nextLine());
                switch (chooseMenu) {
                    case 1:
                        facilityController.display();
                        break;
                    case 2:
                        facilityController.create();
                        break;
                    case 3:
                        facilityController.showMaintenanceList();
                        break;
                    case 0:
                        System.out.println("Back To Main Menu");
                        flag = false;
                        break;
                    default:
                        System.out.println(INVALID_INDEX_WARNING);
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }

        } while (flag);
    }

    private void showBookingManagementMenu() {
        boolean flag = true;

        do {
            System.out.println("===========Booking Management===========\n" +
                "1.\tAdd new booking\n" +
                "2.\tDisplay list bookings\n" +
                "3.\tCreate new contracts\n" +
                "4.\tDisplay list contracts\n" +
                "5.\tEdit contracts\n" +
                "0.\tReturn main menu");
            try {
                System.out.print("Your choice: ");
                chooseMenu = Integer.parseInt(scanner.nextLine());
                switch (chooseMenu) {
                    case 1:
                        bookingController.create();
                        break;
                    case 2:
                        bookingController.display();
                        break;
                    case 3:
                        contractController.create();
                        break;
                    case 4:
                        contractController.display();
                        break;
                    case 5:
                        contractController.edit();
                        break;
                    case 0:
                        System.out.println("Back To Main Menu");
                        flag = false;
                        break;
                    default:
                        System.out.println(INVALID_INDEX_WARNING);
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }

        } while (flag);
    }

    private void showPromotionManagementMenu() {

        boolean flag = true;

        do {
            System.out.println("===========Promotion Management===========\n" +
                "1.\tDisplay list customers use service by year\n" +
                "2.\tDisplay list customers get voucher\n" +
                "0.\tReturn main menu");
            try {
                System.out.print("Your choice: ");
                chooseMenu = Integer.parseInt(scanner.nextLine());
                switch (chooseMenu) {
                    case 1:
                        promotionController.displayCustomerListByYear();
                        break;
                    case 2:
                        promotionController.giveVoucher();
                        break;
                    case 0:
                        System.out.println("Back To Main Menu");
                        flag = false;
                        break;
                    default:
                        System.out.println(INVALID_INDEX_WARNING);
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }

        } while (flag);
    }
}
