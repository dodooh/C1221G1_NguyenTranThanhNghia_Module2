package ss6_inheritance.bai_tap.lop_triangle;

public class Application {

    public static void main(String[] args) {
        Triangle triangle = new Triangle(4.5, 6, 7.8);
        System.out.println("Dien tich hinh tam giac: " + triangle.getArea());
        System.out.println("Chu vi hinh tam giac: " + triangle.getPerimeter());
        System.out.println(triangle);
    }
}
