package ss7_abstract_interface.bai_tap.trien_khai_interface_resizeable;

public class ResizeableTest {

    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(4, 8);
        Square square = new Square(10);

        Shape[] shapes = new Shape[]{circle, rectangle, square};

        for (Shape shape : shapes) {
            System.out.println("Area Before Resize :");
            System.out.println(shape.getArea());
            double random = 1.0 + Math.random() * 100;
            shape.resize(random);
            System.out.println("Area After Resize :");
            System.out.println(shape.getArea());
        }

    }
}
