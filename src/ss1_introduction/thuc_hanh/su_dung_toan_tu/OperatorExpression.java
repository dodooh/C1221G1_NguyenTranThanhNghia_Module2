package ss1_introduction.thuc_hanh.su_dung_toan_tu;

import java.util.Scanner;

public class OperatorExpression {

    public static void main(String[] args) {
        float width;
        float height;
        Scanner scanner = new Scanner(System.in);//Khai báo đối tượng Scanner

        System.out.println("Enter width: ");
        width = scanner.nextFloat();//Nhập chiều rộng

        System.out.println("Enter height: ");
        height = scanner.nextFloat();//Nhập chiều dài
        float area = width * height;

        System.out.println("Area is: " + area);
    }
}
