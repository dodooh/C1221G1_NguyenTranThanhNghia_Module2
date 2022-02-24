package ss7_abstract_interface.bai_tap.trien_khai_interface_resizeable;

public class ResizeableTest {

    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(4,8);
        Square square = new Square(10);

        int random = 1 + (int)(Math.random() * 100);
        System.out.println("Random number = " + random);
        circle.resize(random);
        System.out.println(circle);
        rectangle.resize(random);
        System.out.println(rectangle);
        square.resize(random);
        System.out.println(square);
        System.out.println(square.getArea());

    }
}
