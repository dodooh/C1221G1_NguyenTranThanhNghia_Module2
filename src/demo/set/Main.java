package demo.set;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        // hashcode equals Set
        Student student2 = new Student(1002, 20, "A");
        Student student1 = new Student(1001, 10, "C");
        Student student4 = new Student(1002, 21, "F");
        Student student3 = new Student(1005, 14, "D");
        Student student5 = new Student(1002, 5, "I");
        List<Student> studentList = new ArrayList<>();
        studentList.add(student2);
        studentList.add(student1);
        studentList.add(student4);
        studentList.add(student3);
        studentList.add(student5);
        StudentComparator comparator = new StudentComparator();
        Collections.sort(studentList, comparator); // Comparator
        Collections.sort(studentList); // Comparable
        for (Student student : studentList) {
            System.out.println(student);
        }

    }
}
