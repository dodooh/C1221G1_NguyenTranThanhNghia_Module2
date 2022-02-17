package ss3_mang_va_phuong_thuc.bai_tap.them_phan_tu_vao_mang;

import java.util.Scanner;

public class InsertElement {

    public static void main(String[] args) {
        int[] array = {10, 4, 6, 7, 8, 6, 0, 0, 0, 0};
        System.out.println("Nhập giá trị X muốn thêm: ");
        Scanner scanner = new Scanner(System.in);
        int X = Integer.parseInt(scanner.nextLine());
        int index;
        do {
            System.out.println("Nhập vị trí index muốn chèn: ");
            index = Integer.parseInt(scanner.nextLine());
            if (index < 0 || index > array.length) {
                System.out.println("Vị trí không hợp lệ. Nhập lại");
            }
        } while (index < 0 || index > array.length);
        System.arraycopy(array, index, array, index + 1, array.length - 1 - index);
        array[index] = X;
        System.out.print("Mảng sau khi thêm là: ");
        for(int item : array) {
            System.out.printf("%-3d",item);
        }
    }
}
