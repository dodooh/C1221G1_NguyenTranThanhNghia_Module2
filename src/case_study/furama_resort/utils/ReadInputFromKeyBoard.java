package case_study.furama_resort.utils;

import static case_study.furama_resort.utils.ValidatorInputLibrary.isMatch;
import static oop_review.quan_ly_phuong_tien.controllers.MainController.scanner;

public class ReadInputFromKeyBoard {

    public static String askUserToInputValidData(String fieldName, String regex) {
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
}
