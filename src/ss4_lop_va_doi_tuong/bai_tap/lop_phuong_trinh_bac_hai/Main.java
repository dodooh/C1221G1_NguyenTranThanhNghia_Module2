package ss4_lop_va_doi_tuong.bai_tap.lop_phuong_trinh_bac_hai;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a, b, c: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);

        System.out.print("The equation has ");
        if (quadraticEquation.getDiscriminant() < 0) {
            System.out.println("no real roots");
        } else if (quadraticEquation.getDiscriminant() > 0) {
            System.out.printf("two roots %.4f and %.4f", quadraticEquation.getRoot1(),
                quadraticEquation.getRoot2());
        } else {
            System.out.printf("one root %.4f", quadraticEquation.getRoot1());
        }
    }
}
