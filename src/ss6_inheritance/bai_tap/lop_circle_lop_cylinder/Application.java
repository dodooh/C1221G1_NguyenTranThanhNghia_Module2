package ss6_inheritance.bai_tap.lop_circle_lop_cylinder;

public class Application {

    public static void main(String[] args) {
        Circle circleFather = new Circle(3.2, "pink");
        System.out.println(circleFather);
        Cylinder cylinder = new Cylinder(2.3, "red", 5.0);
        System.out.println(cylinder);
        cylinder.setColor("blue");
        cylinder.setRadius(5.6);
        //        ((Cylinder) circle).setHeight(9.3);
        System.out.println(cylinder);
//        System.out.println(cylinderExplicit);
        System.out.println("The tich hinh tru: " + cylinder.getVolume());
    }
}
