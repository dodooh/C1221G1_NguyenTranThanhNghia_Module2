package bai_tap.quan_ly_ngan_hang_8.utils;


import static bai_tap.quan_ly_ngan_hang_8.controllers.MainController.scanner;
import static bai_tap.quan_ly_ngan_hang_8.utils.ValidatorInputLibrary.simpleDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadInputFromKeyBoard {

    public static String inputValidData(String fieldName, String regex) {
        String input;
        do {
            System.out.printf("Enter %s: ", fieldName);
            input = scanner.nextLine();
            if (!input.matches(regex)) { // Validator
                System.out.printf("!!!%s is invalid. Retry!\n", fieldName);
            } else {
                break;
            }
        } while (true);
        return input;
    }

    public static double inputValidMoney(String fieldName) {
        String input;
        do {
            System.out.printf("Enter %s: ", fieldName);
            input = scanner.nextLine();
            if (!input.matches(ValidatorInputLibrary.BALANCE)) { // Validator
                System.out.printf("!!!%s is invalid. Retry!!!\n", fieldName);
            }
            if (Double.parseDouble(input) <= 0) {
                System.out.printf("!!!%s cant be smaller than 0!!!\n", fieldName);
            } else {
                break;
            }
        } while (true);
        return Double.parseDouble(input);
    }

    public static Date inputValidCreatedDateTime() {
        Date date;
        do {
            System.out.print("Enter create date (dd/mm/yyyy): ");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            try {
                date = formatter.parse(scanner.nextLine());
                if (date.compareTo(new Date()) < 0) {
                    System.out.println("!!!CREATED DATE CAN NOT BE IN THE PAST!!!");
                } else {
                    System.out.println("Begin Date Approved: " + simpleDateFormat.format(date));
                    return date;
                }
            } catch (ParseException e) {
                System.out.println("!!!INVALID DATE TIME FORMAT!!!!");
            }
        } while (true);
    }

    public static Date inputValidStartSavingDateTime(Date createdDate) {
        Date date;
        do {
            System.out.print("Enter end date (dd/mm/yyyy): ");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            try {
                date = formatter.parse(scanner.nextLine());
                if (date.compareTo(createdDate) <= 0) {
                    System.out.println("!!!END DATE MUST BE AFTER START DATE");
                } else {
                    System.out.println("End Date Approved: " + simpleDateFormat.format(date));
                    return date;
                }
            } catch (ParseException e) {
                System.out.println("!!!INVALID DATE TIME FORMAT!!!!");
            }
        } while (true);
    }
}
