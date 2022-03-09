package demo.set;


import java.util.Objects;

public class Student  {
    private int id;
    private int age;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student(int id,int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
            "id=" + id +
            ", age=" + age +
            ", name='" + name + '\'' +
            '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
//
//    @Override
//    public boolean equals(Object o) {
//        Student otherStudent = (Student) o;
//        return this.getId() == otherStudent.getId() ;
//    }
//
//    @Override
//    public int hashCode() {
//        return 12;
//    }

//    @Override
//    public int compareTo(Student otherStudent) {
//        // this (Student)
//        // otherStudent (Student)
//
////        if (this.getAge() > otherStudent.getAge()) {
////            return -99;
////        } else if (this.getAge() < otherStudent.getAge() ) {
////            return 100;
////        } else {
////            return 0;
////        }
//        return this.getAge() - otherStudent.getAge();
//    }

    @Override
    public boolean equals(Object o) {
        Student otherStudent = (Student) o;
        return this.getId() == otherStudent.getId() && this.getName().equals(otherStudent.getName());
    }

    @Override
    public int hashCode() {
        return 5;
    }
}
