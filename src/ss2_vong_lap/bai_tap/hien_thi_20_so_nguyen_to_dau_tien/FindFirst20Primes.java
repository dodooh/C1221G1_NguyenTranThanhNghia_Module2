package ss2_vong_lap.bai_tap.hien_thi_20_so_nguyen_to_dau_tien;

import java.util.Scanner;

public class FindFirst20Primes {

    public static void main(String[] args) {
        System.out.println("Primes");
        System.out.println("Enter numbers of Primes: ");
        Scanner scanner = new Scanner(System.in);
        int numbers = Integer.parseInt(scanner.nextLine());
        int count = 0;
        int n = 2;
        while (count < numbers) {
            boolean flag = true;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                count++;
                System.out.printf("%d - ", n);
            }
            n++;
        }

    }
}
