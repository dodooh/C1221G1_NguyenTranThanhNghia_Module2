package ss19_string_regex.bai_tap.validate_ten_lop_hoc;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateClassName {

    public static void main(String[] args) {
        // C0318G
        // M0318G, P0323A
        Scanner scanner = new Scanner(System.in);
        Pattern p = Pattern.compile("^[CAP]\\d{4}[GHIKLM]");
        char y;
        do {
            System.out.print("Nhập vào tên lớp: ");
            String lop1 = scanner.nextLine();
            Matcher m = p.matcher(lop1);
            System.out.println(m.matches());
            System.out.print("Continue (y/n): ");
            y = scanner.nextLine().charAt(0);
        } while (y != 'n');
    }

}
