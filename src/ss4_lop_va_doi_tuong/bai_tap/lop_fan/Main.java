package ss4_lop_va_doi_tuong.bai_tap.lop_fan;

public class Main {

    public static void main(String[] args) {
        final int SLOW = 1;		// Fan speed slow
        final int MEDIUM = 2;	// Fan speed medium
        final int FAST = 3;		// Fan speed fast

        Fan fan1 = new Fan();
        Fan fan2 = new Fan();

        fan1.setSpeed(FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.turnOn();

        fan2.setSpeed(MEDIUM);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.turnOff();

        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
