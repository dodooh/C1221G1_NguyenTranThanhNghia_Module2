package demo.inheritance;

public class Person {

    public int age;

    public Person() {
        age = 0;
        System.out.println("Person performing its tasks!" + age);
    }

    public void say() {
        System.out.println("Say from PERSON class");
    }
}