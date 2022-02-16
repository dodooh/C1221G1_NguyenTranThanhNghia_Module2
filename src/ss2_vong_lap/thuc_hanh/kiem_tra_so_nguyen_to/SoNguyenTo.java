package ss2_vong_lap.thuc_hanh.kiem_tra_so_nguyen_to;

import java.util.Scanner;

public class SoNguyenTo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number:");
        int number = scanner.nextInt();
        boolean check = true;
        if (number < 2){
            check = false;
        } else {
            int i = 2;
            while (i <= Math.sqrt(number)) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
        }
        if (check)
            System.out.println(number + " is a prime");
        else
            System.out.println(number + " is not a prime");
    }
}
