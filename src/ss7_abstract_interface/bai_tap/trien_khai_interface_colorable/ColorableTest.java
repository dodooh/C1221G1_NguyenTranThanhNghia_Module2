package ss7_abstract_interface.bai_tap.trien_khai_interface_colorable;


public class ColorableTest {

    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(4,8);
        Square square = new Square(10);

        Shape[] shapes = new Shape[]{circle,rectangle,square};

        for (Shape shape : shapes) {
            System.out.println(shape.getArea());
            if (shape instanceof IColorable) {
                ((IColorable) shape).howToColor();
            }
        }

    }
}
