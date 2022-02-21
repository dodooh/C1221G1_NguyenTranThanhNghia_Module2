package ss5_access_modifier_static.bai_tap.access_modifier;

public class TestCircle {

    public static void main(String[] args) {
        Circle c = new Circle(2.5);
        System.out.println("Radius = " + c.getRadius());
        System.out.println("Area = " + c.getArea());
    }
}
