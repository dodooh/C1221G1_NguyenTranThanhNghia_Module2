package ss2_vong_lap.bai_tap.hien_thi_cac_loai_hinh;

import java.util.Scanner;

public class HienThiCacLoaiHinh {

    public static void main(String[] args) {
        int choice = -1;
        final int SIZE = 5;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Menu");
            System.out.println("1. Draw the rectangle");
            System.out.println("2. Draw the top-left square triangle");
            System.out.println("3. Draw the top-right square triangle");
            System.out.println("4. Draw the bottom-left square triangle");
            System.out.println("5. Draw the bottom-right square triangle");
            System.out.println("6. Draw the isosceles triangle rectangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    for(int i = 0; i < SIZE; i++) {
                        for(int j = 0; j < SIZE * 2; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    for (int i = SIZE; i >= 1; i--) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    for (int i = SIZE; i >= 1; i--) {
                        for (int j = 1; j <= SIZE; j++) {
                            if (j > SIZE - i) {
                                System.out.print("* ");
                            } else {
                                System.out.print("  ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    for (int i = 1; i <= SIZE; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 5:
                    for (int i = 1; i <= SIZE; i++) {
                        for (int j = 1; j <= SIZE; j++) {
                            if (j > SIZE - i) {
                                System.out.print("* ");
                            } else {
                                System.out.print("  ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 6:
                    for (int i = 1; i <= SIZE; i++) {
                        for (int j = 1; j <= SIZE + i - 1; j++) {
                            if (j > SIZE - i) {
                                System.out.print("* ");
                            } else {
                                System.out.print("  ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
