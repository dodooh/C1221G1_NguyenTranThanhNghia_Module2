package case_study.furama_resort.controllers;

import java.util.Scanner;

public class FuramaController {

    private final Scanner scanner = new Scanner(System.in);

    public void displayMainMenu() {
        boolean flag = true;

        do {
            System.out.println("===========Main Menu:===========\n" +
                "1.\tEmployee Management\n" +
                "2.\tCustomer Management\n" +
                "3.\tFacility Management \n" +
                "4.\tBooking Management\n" +
                "5.\tPromotion Management\n" +
                "6.\tExit");
            System.out.println("Chọn chức năng: ");
            int chooseMenu = Integer.parseInt(scanner.nextLine());
            switch (chooseMenu) {
                case 1:
                    showEmployeeManagementMenu();
                    //chức năng thêm ới
                    break;
                case 2:
                    showCustomerManagementMenu();
                    //chức năng hiện thi

                    break;
                case 3:
                    showFacilityManagementMenu();
                    //chức năng thêm sửa
                    break;
                case 4:
                    showBookingManagementMenu();
                    //xóa
                    break;
                case 5:
                    showPromotionManagementMenu();
                    //chức năng tìm kiếm
                    break;
                default:
                    flag = false;
            }
        } while (flag);
    }

    private void showEmployeeManagementMenu() {
        boolean flag = true;

        do {
            System.out.println("===========Employee Management===========\n" +
                "1.\tDisplay list employees\n" +
                "2.\tAdd new employee\n" +
                "3.\tEdit employee\n" +
                "4.\tReturn main menu");
            System.out.println("Chọn chức năng: ");
            int chooseMenu = Integer.parseInt(scanner.nextLine());
            switch (chooseMenu) {
                case 1:
                    //chức năng thêm ới
                    break;
                case 2:
                    //chức năng hiện thi

                    break;
                case 3:
                    //chức năng thêm sửa
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
            System.out.println("Chọn chức năng: ");
            int chooseMenu = Integer.parseInt(scanner.nextLine());
            switch (chooseMenu) {
                case 1:
                    //chức năng thêm ới
                    break;
                case 2:
                    //chức năng hiện thi

                    break;
                case 3:
                    //chức năng thêm sửa
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
            System.out.println("Chọn chức năng: ");
            int chooseMenu = Integer.parseInt(scanner.nextLine());
            switch (chooseMenu) {
                case 1:
                    //chức năng thêm ới
                    break;
                case 2:
                    //chức năng hiện thi

                    break;
                case 3:
                    //chức năng thêm sửa
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
            System.out.println("Chọn chức năng: ");
            int chooseMenu = Integer.parseInt(scanner.nextLine());
            switch (chooseMenu) {
                case 1:
                    //chức năng thêm ới
                    break;
                case 2:
                    //chức năng hiện thi
                    break;
                case 3:
                    //chức năng thêm sửa
                    break;
                case 4:
                    //xóa
                    break;
                case 5:
                    //chức năng tìm kiếm
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
            System.out.println("Chọn chức năng: ");
            int chooseMenu = Integer.parseInt(scanner.nextLine());
            switch (chooseMenu) {
                case 1:
                    //chức năng thêm ới
                    break;
                case 2:
                    //chức năng hiện thi

                    break;
                default:
                    flag = false;
            }
        } while (flag);
    }
}
