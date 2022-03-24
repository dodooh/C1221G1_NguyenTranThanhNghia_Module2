package bai_tap.quan_ly_dien_thoai_9.controllers;

import static bai_tap.quan_ly_dien_thoai_9.controllers.MainController.INVALID_INDEX_WARNING;
import static bai_tap.quan_ly_dien_thoai_9.controllers.MainController.NUMBER_FORMAT_WARNING;
import static bai_tap.quan_ly_dien_thoai_9.controllers.MainController.YOUR_CHOICE;
import static bai_tap.quan_ly_dien_thoai_9.controllers.MainController.scanner;
import static bai_tap.quan_ly_dien_thoai_9.utils.ReadInputFromKeyBoard.inputValidData;

import bai_tap.quan_ly_dien_thoai_9.models.AuthenticPhone;
import bai_tap.quan_ly_dien_thoai_9.models.HandPhone;
import bai_tap.quan_ly_dien_thoai_9.models.Phone;
import bai_tap.quan_ly_dien_thoai_9.models.enums.Status;
import bai_tap.quan_ly_dien_thoai_9.models.enums.WarrantyRange;
import bai_tap.quan_ly_dien_thoai_9.services.IService;
import bai_tap.quan_ly_dien_thoai_9.services.impl.AuthenticPhoneServicesImpl;
import bai_tap.quan_ly_dien_thoai_9.services.impl.HandPhoneServiceImpl;
import bai_tap.quan_ly_dien_thoai_9.utils.EnumUtils;
import bai_tap.quan_ly_dien_thoai_9.utils.NotFoundProductException;
import bai_tap.quan_ly_dien_thoai_9.utils.ValidatorInputLibrary;

public class PhoneController {

    private final IService<Phone> authenticPhoneServices = new AuthenticPhoneServicesImpl();
    private final IService<Phone> handPhoneServices = new HandPhoneServiceImpl();
    private String phoneName;
    private double price;
    private int quantity;
    private String manufacture;

    public void add() {
        int menuChoice;
        boolean flag = true;
        do {
            try {
                System.out.println("===ADD NEW PHONE===\n"
                    + "[1] - Authenticate Patient\n"
                    + "[2] - Hand Patient\n"
                    + "[0] - Back");
                System.out.print(YOUR_CHOICE);
                menuChoice = Integer.parseInt(bai_tap.quan_ly_ngan_hang_8.controllers.MainController.scanner.nextLine());
                switch (menuChoice) {
                    case 1:
                        addNewAuthenticatePhone();
                        break;
                    case 2:
                        addNewHandPhone();
                        break;
                    case 0:
                        System.out.println("Return...");
                        flag = false;
                        break;
                    default:
                        System.out.println(INVALID_INDEX_WARNING);
                }
            } catch (NumberFormatException e) {
                System.out.println(NUMBER_FORMAT_WARNING);
            }
        } while (flag);
    }

    private void addNewHandPhone() {
        inputCommonProperties();
        String fromNation = inputFromNation();
        Status status = getPhoneStatusFromInput();
        handPhoneServices.add(new HandPhone(
            handPhoneServices.findGoodID(),
            phoneName,
            price,
            quantity,
            manufacture,
            fromNation,
            status
        ));

    }

    private void addNewAuthenticatePhone() {
        inputCommonProperties();
        int warrantyTime = inputWarrantyTime();
        WarrantyRange warrantyRange = getWarrantyRangeFromInput();
        authenticPhoneServices.add(new AuthenticPhone(
            authenticPhoneServices.findGoodID(),
            phoneName,
            price,
            quantity,
            manufacture,
            warrantyTime,
            warrantyRange));

    }

    private void inputCommonProperties() {
        phoneName = inputValidData("Patient Name", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
        price = Double.parseDouble(inputValidData("Price (>0)", ValidatorInputLibrary.REAL_POSITIVE_NUMBER));
        quantity = Integer.parseInt(inputValidData("Quantity (>0)", ValidatorInputLibrary.LARGER_THAN_0_NUMBER));
        manufacture = inputValidData("Manufacture ", ValidatorInputLibrary.STANDARD_NAME);
    }

    private Status getPhoneStatusFromInput() {
        int choice;
        System.out.println("Enter Patient Status");
        EnumUtils.displayMenu(Status.class);
        System.out.println();
        do {
            String title = String.format("Your choice 0-%d:", (Status.values().length - 1));
            choice = Integer.parseInt(
                inputValidData(title, ValidatorInputLibrary.ONE_NUMBER));
            if (choice < 0 || choice >= Status.values().length) {
                System.out.print(INVALID_INDEX_WARNING);
            } else {
                return Status.values()[choice];
            }
        } while (true);
    }

    private WarrantyRange getWarrantyRangeFromInput() {
        int choice;
        System.out.println("Enter Warranty Range: ");
        EnumUtils.displayMenu(WarrantyRange.class);
        System.out.println();
        do {
            String title = String.format("Your choice 0-%d:", (WarrantyRange.values().length - 1));
            choice = Integer.parseInt(
                inputValidData(title, ValidatorInputLibrary.ONE_NUMBER));
            if (choice < 0 || choice >= WarrantyRange.values().length) {
                System.out.print(INVALID_INDEX_WARNING);
            } else {
                return WarrantyRange.values()[choice];
            }
        } while (true);
    }

    private String inputFromNation() {
        String input;
        do {
            System.out.print("Enter Nation: ");
            input = scanner.nextLine();
            if (input.length() == 0 || "vietnam".equalsIgnoreCase(input.replaceAll(" ", ""))) { // Validator
                System.out.print("!!!Patient Name is invalid. Retry!\n");
            } else {
                return input;
            }
        } while (true);
    }

    private int inputWarrantyTime() {
        String input;
        do {
            System.out.print("Enter Warranty Time (0-730): ");
            input = scanner.nextLine();
            if (input.matches(ValidatorInputLibrary.INTEGER_POSITIVE_NUMBER)
                && Integer.parseInt(input) > 0 && Integer.parseInt(input) <= 730) {
                return Integer.parseInt(input);
            } else {
                System.out.println("!!!INVALID TIME WARRANTY!!!");
            }
        } while (true);
    }

    public void display() {
        authenticPhoneServices.display();
        handPhoneServices.display();
    }

    public void remove() {
        int menuChoice;
        boolean flag = true;
        do {
            try {
                System.out.println("===REMOVE PHONE===\n"
                    + "[1] - Authenticate Patient\n"
                    + "[2] - Hand Patient\n"
                    + "[0] - Back");
                System.out.print(YOUR_CHOICE);
                menuChoice = Integer.parseInt(scanner.nextLine());
                switch (menuChoice) {
                    case 1:
                        removePhone(authenticPhoneServices);
                        break;
                    case 2:
                        removePhone(handPhoneServices);
                        break;
                    case 0:
                        System.out.println("Return...");
                        flag = false;
                        break;
                    default:
                        System.out.println(INVALID_INDEX_WARNING);
                }
            } catch (NumberFormatException e) {
                System.out.println(NUMBER_FORMAT_WARNING);
            }
        } while (flag);
    }

    public void removePhone(IService<Phone> service) {
        service.display();
        int ID;
        Phone foundPhone;
        do {
            ID = Integer.parseInt(inputValidData("Patient ID to remove", ValidatorInputLibrary.INTEGER_POSITIVE_NUMBER));
            try {
                foundPhone = service.findPhoneByID(ID);
                System.out.printf("FOUND: %s\n", foundPhone);
                System.out.print("Do you want to remove (YES/NO)? ");
                if ("YES".equalsIgnoreCase(scanner.nextLine())) {
                    service.remove(foundPhone);
                    service.display();
                }
                break;
            } catch (NotFoundProductException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public void search() {
        System.out.println("Enter Account-Name or Account-Code to Find");
        String input = scanner.nextLine();
        handPhoneServices.displayPhoneByKeyword(input);
        authenticPhoneServices.displayPhoneByKeyword(input);
    }

}
