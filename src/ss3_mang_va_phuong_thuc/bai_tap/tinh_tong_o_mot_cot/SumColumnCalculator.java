package ss3_mang_va_phuong_thuc.bai_tap.tinh_tong_o_mot_cot;

import java.util.Scanner;

public class SumColumnCalculator {

    public static void main(String[] args) {
//        double[][] arr = {{0.4, 0.6, 0.8, 1.2}, {2.1, 5.6, 3.6, 2.6}, {4.3, 2.4, 3.5, 1.6}};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số dòng cho ma trận");
        int row = scanner.nextInt();
        System.out.println("Nhập số cột cho ma trận");
        int col = scanner.nextInt();
        double[][] arr = new double[row][col];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println("Nhập phần tử thứ " + i + "-" + j);
                arr[i][j] = scanner.nextDouble();
            }
        }
        do {
            System.out.println("Nhập vào cột cần tính tổng: ");
            col = scanner.nextInt();
            if (col < 0 || col > arr[0].length) {
                System.err.println("Không hợp lệ. nhập lại");
            }
        } while (col < 0 || col > arr[0].length);
        double sum = 0d;
        for (double[] doubles : arr) {
            sum += doubles[col];
        }
        System.out.println("Tổng của cột " + col + " là: " + sum);
    }
}
