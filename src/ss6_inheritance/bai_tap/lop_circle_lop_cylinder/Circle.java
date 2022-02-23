package ss6_inheritance.bai_tap.lop_circle_lop_cylinder;

public class Circle {
    protected double radius ;
    protected String color;

    Circle() {
        radius = 0.0;
        color = "red";
    }

    Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" +
            "radius=" + radius +
            ", color='" + color + '\'' +
            '}';
    }
}
