package ss3_mang_va_phuong_thuc.bai_tap.gop_mang;

public class ConcatenateTwoArray {

    public static void main(String[] args) {
        int[] array1 = {10, 4, 6, 7, 8, 6, 4, 1, 7, 8, 2};
        int[] array2 = {7, 7, 7, 1, 4, 5, 2, 1, 9, 3, 6};
        System.out.print("Mảng 1 là: ");
        for (int item : array1) {
            System.out.printf("%-3d", item);
        }
        System.out.println();
        System.out.print("Mảng 2 là: ");
        for (int item : array2) {
            System.out.printf("%-3d", item);
        }
        int[] array3 = new int[array1.length + array2.length];
        int i = 0;
        for (; i < array1.length; i++) {
            array3[i] = array1[i];
        }
        for (; i < array3.length; i++) {
            array3[i] = array2[i - array1.length];
        }
        System.out.println();
        System.out.print("Mảng 3 là: ");
        for (int item : array3) {
            System.out.printf("%-3d", item);
        }
    }
}
