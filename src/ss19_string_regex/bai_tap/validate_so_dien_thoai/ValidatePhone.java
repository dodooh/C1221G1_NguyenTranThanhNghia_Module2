package ss19_string_regex.bai_tap.validate_so_dien_thoai;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatePhone {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern p = Pattern.compile("^\\(\\d{2}\\)-\\(0\\d{9}\\)");
        Matcher m;
        char y;
        do {
            System.out.print("Nhập vào số điện thoại: ");
            String phone = scanner.nextLine();
            m = p.matcher(phone);
            System.out.println(m.matches());
            System.out.print("Continue (y/n): ");
            y = scanner.nextLine().charAt(0);
        } while (y != 'n');
    }
}
