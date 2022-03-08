package ss15_exception.bai_tap.su_dung_lop_illegaltriangleexception;

public class Triangle extends Shape {

    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException {
        setSide1(side1);
        setSide2(side2);
        setSide3(side3);
        checkValidTriangle();
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) throws IllegalTriangleException {
        if (side1 <= 0) {
            throw new IllegalTriangleException("Side 1 <= 0");
        }
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) throws IllegalTriangleException {
        if (side2 <= 0) {
            throw new IllegalTriangleException("Side 2 <= 0");
        }
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) throws IllegalTriangleException {
        if (side3 <= 0) {
            throw new IllegalTriangleException("Side 3 <= 0");
        }
        this.side3 = side3;
    }

    private void checkValidTriangle() throws IllegalTriangleException {
        if (side1 > side3 + side2 || side2 > side3 + side1 || side3 > side1 + side2) {
            throw new IllegalTriangleException("Sum of two sides must be greater than the other side");
        }
    }

    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public String toString() {
        return "Triangle{" +
            ", side2=" + side2 +
            "side1=" + side1 +
            ", side3=" + side3 +
            ", color=" + super.getColor() +
            ", filled=" + super.isFilled() +
            '}';
    }
}
