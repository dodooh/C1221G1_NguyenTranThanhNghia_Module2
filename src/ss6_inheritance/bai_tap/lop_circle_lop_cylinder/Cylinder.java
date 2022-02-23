package ss6_inheritance.bai_tap.lop_circle_lop_cylinder;

public class Cylinder extends Circle {

    private double height;

    Cylinder() {
        super();
        this.height = 0.0;
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return super.getArea() * this.height;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
            "radius=" + getRadius() +
            ", color='" + getColor() + '\'' +
            ", height=" + getHeight() +
            '}';
    }
}
