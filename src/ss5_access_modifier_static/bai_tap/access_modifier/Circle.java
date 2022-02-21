package ss5_access_modifier_static.bai_tap.access_modifier;

public class Circle {
    private double radius;
    private String color;

    Circle() {
        radius = 1.0;
        color = "red";
    }
    Circle(double radius) {
        this.radius = radius;
        color = "red";
    }

    protected double getRadius() {
        return radius;
    }

    protected double getArea() {
        return radius * radius * Math.PI;
    }
}
