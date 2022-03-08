package ss15_exception.bai_tap.su_dung_lop_illegaltriangleexception;

public class IllegalTriangleException extends Exception{

    public IllegalTriangleException() {
    }

    public IllegalTriangleException(String message) {
        super("IllegalTriangleException: " + message);
    }
}
