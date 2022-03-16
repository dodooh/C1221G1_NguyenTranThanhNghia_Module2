package case_study.furama_resort.utils;

import static oop_review.quan_ly_phuong_tien.controllers.MainController.scanner;

public class ValidatorInput {

    public static final String IS_NOT_AN_EMPTY_STRING = "\\w*";

    private static boolean isMatch(String input, String regex) {
        return input.matches(regex);
    }
    public static String askUserToInputField(String fieldName, String regex) {
        String input;
        do {
            System.out.printf("Enter %s: ", fieldName);
            input = scanner.nextLine();
            if (!isMatch(input, regex)) { // Validator
                System.err.printf("%s is invalid. Retry!\n",fieldName);
            } else {
                break;
            }
        } while (true);
        return input;
    }

}