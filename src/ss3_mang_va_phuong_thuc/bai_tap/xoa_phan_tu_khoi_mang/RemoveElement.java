package ss3_mang_va_phuong_thuc.bai_tap.xoa_phan_tu_khoi_mang;

import java.util.Scanner;

public class RemoveElement {

    public static void main(String[] args) {
        int[] array = {10, 4, 6, 7, 8, 6, 0, 0, 0, 0};
        System.out.println("Nhập giá trị muốn xóa: ");
        Scanner scanner = new Scanner(System.in);
        int X = Integer.parseInt(scanner.nextLine());
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == X) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.printf("Không tìm thấy giá trị %d trong mảng", X);
        } else {
            System.out.printf("Vị trí tìm thấy của %d trong mảng là %d\n", X, index);
//            for (int i = index; i < array.length - 1; i++) {
//                array[i] = array[i + 1];
//            }
            System.arraycopy(array, index + 1, array, index, array.length - 1 - index);
            System.out.print("Mảng sau khi xóa là: ");
            for (int item : array) {
                System.out.printf("%-3d", item);
            }
        }
    }
}
