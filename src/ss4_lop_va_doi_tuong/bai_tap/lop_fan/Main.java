package ss4_lop_va_doi_tuong.bai_tap.lop_fan;

public class Main {

    public static void main(String[] args) {

        Fan fan1 = new Fan();
        Fan fan2 = new Fan();

        fan1.setSpeed(Fan.SLOW);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.turnOn();

        fan2.setSpeed(Fan.MEDIUM);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.turnOff();

        System.out.println(fan1);
        System.out.println(fan2);
    }
}
