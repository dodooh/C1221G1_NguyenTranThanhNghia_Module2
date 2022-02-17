package ss3_mang_va_phuong_thuc.bai_tap.tim_min_trong_mang;

import java.util.Scanner;

public class FindMin {

    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập kích thước cho mảng:");
        size = scanner.nextInt();
        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + " : ");
            array[i] = scanner.nextInt();
            i++;
        }
        System.out.print("Mảng nhập vào là: ");
        for (int k : array) {
            System.out.print(k + "\t");
        }
        int min = array[0];
        for (int j = 1; j < array.length; j++) {
            if (array[j] < min) {
                min = array[j];
            }
        }
        System.out.println("\nGiá trị nhỏ nhất trong mảng là: " + min);
    }
}
