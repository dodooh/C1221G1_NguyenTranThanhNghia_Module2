package case_study.furama_resort.utils;

import static oop_review.quan_ly_phuong_tien.controllers.MainController.scanner;

import oop_review.quan_ly_phuong_tien.utils.Validator;

public class ValidatorInput {

    private static boolean isMatch(String input, String regex) {
        return input.matches(regex);
    }
    public static String askUserToInputField(String fieldName, String regex) {
        String input;
        do {
            System.out.printf("Enter %s: ", fieldName);
            input = scanner.nextLine();
            if (isMatch(input, regex)) { // Validator
                System.err.printf("%s is invalid. Retry!\n");
            } else {
                break;
            }
        } while (true);
        return input;
    }

}
