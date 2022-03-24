package bai_tap.final_module_2.utils;

import static bai_tap.final_module_2.controllers.MainController.scanner;
import static bai_tap.final_module_2.utils.ValidatorInputLibrary.simpleDateFormat;

import bai_tap.final_module_2.controllers.MainController;
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

    public static Date inputValidDateTime(String title, Date dateToCompare) {
        Date date;
        do {
            String s = String.format("Enter %s (dd/mm/yyyy): ", title);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            try {
                date = formatter.parse(inputValidData(s, ValidatorInputLibrary.BIRTHDAY_FORMAT));
                if (date.compareTo(dateToCompare) > 0) {
                    System.out.printf("!!!%s must not exceed %s\n", title, simpleDateFormat.format(dateToCompare));
                } else {
                    System.out.printf("%s Approved\n", simpleDateFormat.format(date));
                    return date;
                }
            } catch (ParseException e) {
                System.out.println("!!!INVALID DATE TIME FORMAT!!!!");
            }
        } while (true);
    }


}
