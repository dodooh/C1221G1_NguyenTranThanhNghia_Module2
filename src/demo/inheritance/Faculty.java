package demo.inheritance;

public class Faculty extends Employee {

    public Faculty() {
        System.out.println("Faculty performing its tasks");
    }

    public void say() {
        System.out.println("Say from FACULTY class");
    }

    public static void main(String[] args) {
//        Person f = new Faculty();
//        Faculty f2 = new Faculty();
        int x = 1023;
        byte b = (byte) x;
        System.out.println(b);
//        f.say();
//        f2.say();
    }
}
