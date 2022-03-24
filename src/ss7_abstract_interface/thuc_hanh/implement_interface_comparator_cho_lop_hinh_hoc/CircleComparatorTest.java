package ss7_abstract_interface.thuc_hanh.implement_interface_comparator_cho_lop_hinh_hoc;

import java.util.Arrays;
import java.util.Comparator;

public class CircleComparatorTest {

    public static void main(String[] args) {
        Circle[] circles = new Circle[3];
        circles[0] = new Circle(3.6);
        circles[1] = new Circle();
        circles[2] = new Circle(3.5, "indigo", false);

        System.out.println("Pre-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
//        System.out.println("abc".compareTo("abe"));
        Comparator circleComparator = new CircleComparator();
        Arrays.sort(circles, circleComparator);

        System.out.println("After-sorted:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }
    }
}