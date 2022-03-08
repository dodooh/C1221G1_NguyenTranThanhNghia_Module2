package ss15_exception.bai_tap.su_dung_lop_illegaltriangleexception;

public class TriangleTest {

    public static void main(String[] args) {
        // Bắt exception dùng hàm khởi tạo;
        System.out.println("Khởi tạo Triangle với 1 cạnh âm");
        try {
            Triangle triangle1 =new Triangle(4.5, -1, 6);
            System.out.println(triangle1); // KHÔNG ĐƯỢC THỰC THI
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println("Khởi tạo Triangle với 1 cạnh = 0");
        try {
            Triangle triangle2 =new Triangle(4.5, 1, 0);
            System.out.println(triangle2);  // KHÔNG ĐƯỢC THỰC THI
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println("Khởi tạo Triangle với độ dài 1 cạnh lớn hơn tổng độ dài 2 cạnh còn lại");
        try {
            Triangle triangle3 =new Triangle(4.5, 4.5, 10);
            System.out.println(triangle3);  // KHÔNG ĐƯỢC THỰC THI
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.println("Khởi tạo Triangle hợp lệ");
        try {
            Triangle triangle4 = new Triangle(2, 2, 2);
            System.out.println(triangle4);
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }
    }
}
