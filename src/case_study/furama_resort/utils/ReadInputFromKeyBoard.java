package case_study.furama_resort.utils;

import static case_study.furama_resort.utils.ValidatorInputLibrary.isMatch;
import static oop_review.quan_ly_phuong_tien.controllers.MainController.scanner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadInputFromKeyBoard {

    public static String inputValidData(String fieldName, String regex) {
        String input;
        do {
            System.out.printf("Enter %s: ", fieldName);
            input = scanner.nextLine();
            if (!isMatch(input, regex)) { // Validator
                System.out.printf("!!!%s is invalid. Retry!\n", fieldName);
            } else {
                break;
            }
        } while (true);
        return input;
    }

    public static Date inputValidStartDateTime() {
        Date date;
        String userInput = "";
        do {
            System.out.print("Enter start date (dd/mm/yyyy)");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            try {
                userInput = scanner.nextLine();
                date = formatter.parse(userInput);
                System.out.println("Date: " + date);
                return date;
            } catch (ParseException e) {
                System.out.println("!!!INVALID DATE TIME FORMAT!!!!");
            }
        } while (true);
    }

    public static Date inputValidEndDateTime(Date startDate) {
        Date date;
        String userInput = "";
        do {
            System.out.print("Enter end date (dd/mm/yyyy)");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            try {
                userInput = scanner.nextLine();
                date = formatter.parse(userInput);
                if (date.compareTo(startDate) <= 0) {
                    System.out.println("!!!END DATE MUST BE AFTER START DATE");
                } else {
                    System.out.println("Date: " + date);
                    return date;
                }
            } catch (ParseException e) {
                System.out.println("!!!INVALID DATE TIME FORMAT!!!!");
            }
        } while (true);
    }
}
