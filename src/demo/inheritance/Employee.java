package demo.inheritance;

public class Employee extends Person {

    //    public int age;
    public Employee() {
        this("Employee overloading its tasks");
//        super();
        this.age = 10;
        super.age = 14;
        super.say();
        System.out.println("Employee performing its tasks!" + this.age + " and " + super.age);
    }

    //    public static void say() {
//        System.out.println("Say from EMPLOYEE class");
//    }
    public Employee(String s) {
        System.out.println(s);
    }
}
