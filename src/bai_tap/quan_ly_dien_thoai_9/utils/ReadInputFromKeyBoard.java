package bai_tap.quan_ly_dien_thoai_9.utils;

import static bai_tap.quan_ly_dien_thoai_9.controllers.MainController.scanner;

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


}
