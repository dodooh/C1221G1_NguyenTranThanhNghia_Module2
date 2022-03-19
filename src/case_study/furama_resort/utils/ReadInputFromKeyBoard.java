package case_study.furama_resort.utils;

import static oop_review.quan_ly_phuong_tien.controllers.MainController.scanner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadInputFromKeyBoard {

    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

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

    public static Date inputValidStartDateTime() {
        Date date;
        do {
            System.out.print("Enter start date (dd/mm/yyyy): ");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            try {
                date = formatter.parse(scanner.nextLine());
                if (date.compareTo(new Date()) < 0) {
                    System.out.println("!!!BOOKING DATE CAN NOT BE IN THE PAST!!!");
                } else {
                    System.out.println("Begin Date Approved: " + simpleDateFormat.format(date));
                    return date;
                }
            } catch (ParseException e) {
                System.out.println("!!!INVALID DATE TIME FORMAT!!!!");
            }
        } while (true);
    }

    public static Date inputValidEndDateTime(Date startDate) {
        Date date;
        do {
            System.out.print("Enter end date (dd/mm/yyyy): ");
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            try {
                date = formatter.parse(scanner.nextLine());
                if (date.compareTo(startDate) <= 0) {
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
