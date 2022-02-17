package ss3_mang_va_phuong_thuc.bai_tap.tim_max_trong_mang_2_chieu;

import java.util.Scanner;

public class FindMaxIn2DArray {

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
        int x = 0;
        int y = 0;
        double max = arr[x][y];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        System.out.println("Giá trị lớn nhất là " + max + " ở vị trí " + x + "-" + y);
    }
}
