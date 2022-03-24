package ss3_mang_va_phuong_thuc.bai_tap.dem_so_lan_xuat_hien_cua_ky_tu_trong_chuoi;

import java.util.Scanner;

public class CharCount {

    public static void main(String[] args) {
        String str = "This is a test string.";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập kí tự muốn đếm: ");
        char c = scanner.next().charAt(0);
        int count = 0;
        for (char x : str.toCharArray()) {
            if (x == c) {
                count++;
            }
        }
        System.out.println("Ký tự " + c + " xuất hiện " + count + " lần trong mảng.");
    }
}
