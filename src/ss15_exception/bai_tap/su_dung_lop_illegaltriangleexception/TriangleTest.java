package ss15_exception.bai_tap.su_dung_lop_illegaltriangleexception;

import java.util.Scanner;

public class TriangleTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag;
        do {
            flag = false;
            try {
                System.out.print("side1 = ");
                double side1 = Double.parseDouble(scanner.nextLine());
                System.out.print("side2 = ");
                double side2 = Double.parseDouble(scanner.nextLine());
                System.out.print("side3 = ");
                double side3 = Double.parseDouble(scanner.nextLine());
                Shape triangle = new Triangle(side1, side2, side3);
                System.out.println(triangle);
                System.out.printf("Area = %.2f\n", triangle.getArea());
                System.out.printf("Perimeter = %.2f\n", triangle.getPerimeter());
            } catch (IllegalTriangleException e) {
                System.out.println(e.getMessage());
                System.out.println("Nhập lại!!");
                flag = true;
            } catch (NumberFormatException e) {
                System.out.println("Input must be Number!");
                e.printStackTrace();
                flag = true;
            }
        } while (flag);
    }
}
