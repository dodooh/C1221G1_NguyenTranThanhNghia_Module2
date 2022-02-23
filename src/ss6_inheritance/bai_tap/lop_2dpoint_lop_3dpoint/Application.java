package ss6_inheritance.bai_tap.lop_2dpoint_lop_3dpoint;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        // Test Point 2D
        Point2D point2D = new Point2D(5.1f, 4.1f);
        System.out.println(point2D);
        point2D.setX(7.1f);
        point2D.setY(2.1f);
        System.out.println(point2D);
        System.out.println(Arrays.toString(point2D.getXY()));

        // Test Point 3D
        Point3D point3D = new Point3D(1.2f, 2.2f, 3.2f);
        System.out.println(point3D);
        point3D.setX(4.2f);
        point3D.setXYZ(5.2f, 6.2f, 7.2f);
        System.out.println(Arrays.toString(point3D.getXYZ()));
    }
}
