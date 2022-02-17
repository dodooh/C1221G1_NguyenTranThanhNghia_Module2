package ss3_mang_va_phuong_thuc.bai_tap.them_phan_tu_vao_mang;

import java.util.Scanner;

public class InsertElement {

    public static void main(String[] args) {
        int[] array = {10, 4, 6, 7, 8, 6, 0, 0, 0, 0};
        System.out.println("Nhập giá trị X muốn thêm: ");
        Scanner scanner = new Scanner(System.in);
        int X = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vị trí index muốn chèn: ");
        int index = Integer.parseInt(scanner.nextLine());

    }
}
