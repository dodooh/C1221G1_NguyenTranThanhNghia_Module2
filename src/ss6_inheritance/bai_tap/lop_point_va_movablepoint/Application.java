package ss6_inheritance.bai_tap.lop_point_va_movablepoint;

public class Application {

    public static void main(String[] args) {
        MovablePoint movablePoint = new MovablePoint(1, 1, 3, 3);
        System.out.println(movablePoint.move());
        System.out.println(movablePoint);
        movablePoint.move();
        System.out.println(movablePoint);
        movablePoint.setSpeed(6.0f, 6.0f);
        System.out.println(movablePoint.move());
    }
}
