package ss3_mang_va_phuong_thuc.bai_tap.tong_2_duong_cheo_cua_ma_tran;

import java.util.Scanner;

public class SumOfDiagonal {

    public static void main(String[] args) {
//        double[][] arr = {{0.4, 0.6, 0.8, 1.2}, {2.1, 5.6, 3.6, 2.6}, {4.3, 2.4, 3.5, 1.6},
//            {4.3, 2.4, 3.5, 1.6}};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số dòng & cột cho ma trận hình vuông");
        int size = scanner.nextInt();
        double[][] arr = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.println("Nhập phần tử thứ " + i + "-" + j);
                arr[i][j] = scanner.nextDouble();
            }
        }
        double sum = 0d;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
        }
        System.out.println(sum);

    }
}
