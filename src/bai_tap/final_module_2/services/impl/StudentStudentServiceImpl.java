package bai_tap.final_module_2.services.impl;

import bai_tap.final_module_2.models.Person;
import bai_tap.final_module_2.models.Student;
import bai_tap.final_module_2.services.IStudentService;
import bai_tap.final_module_2.utils.NotFoundStudentException;
import bai_tap.final_module_2.utils.ReadWriteCSVFile;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class StudentStudentServiceImpl implements IStudentService<Person> {

    private static final String STUDENT_FILE_PATH = "src/bai_tap/final_module_2/data/students.csv";
    private static List<Person> studentList = new ArrayList<>();

    static {
        try {
            studentList = ReadWriteCSVFile.readStudentListFromCSVFile(STUDENT_FILE_PATH);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Person> getStudentList() {
        return studentList;
    }

    @Override
    public int findGoodID() {
        if (studentList.size() == 0) {
            return 1;
        } else {
            Student s = (Student) studentList.get(studentList.size() - 1);
            return s.getStudentID() + 1;
        }
    }

    @Override
    public void add(Person student) {
        studentList.add(student);
        ReadWriteCSVFile.writeListToCSVFile(studentList, STUDENT_FILE_PATH);
        System.out.println("✔ Add successfully");
    }

    @Override
    public void display() {
        System.out.println("=========Student List==========");
        if (studentList != null && studentList.size() != 0) {
            int index = 0;
            for (Person student : studentList) {
                System.out.printf("[%d] - %s\n", index++, student);
            }
        } else {
            System.out.println("!!!Student List IS EMPTY!!!");
        }
    }

    @Override
    public void remove(Person student) {
        studentList.remove(student);
        ReadWriteCSVFile.writeListToCSVFile(studentList, STUDENT_FILE_PATH);
        System.out.println("✔ Remove Successfully");
    }

    @Override
    public Student findStudentByID(int ID) throws NotFoundStudentException {
        if (studentList.isEmpty()) {
            return null;
        }
        for (Person student : studentList) {
            if (ID == ((Student) student).getStudentID()) {
                return ((Student) student);
            }
        }
        throw new NotFoundStudentException("!!!STUDENT IS NOT EXIST!!!!");
    }

    @Override
    public void findStudentByName(String keywords) {
        if (studentList.isEmpty()) {
            System.out.println("Student List is Empty");
        }
        boolean isFound = false;
        for (Person student : studentList) {
            if (student.getName().contains(keywords)) {
                System.out.println(student);
                isFound = true;
            }
        }
        if (!isFound) {
            System.out.println("!!!NOT FOUND!!!");
        }
    }

    public boolean hasThisPhoneNumber(String phoneNumber) {
        if (studentList.isEmpty()) {
            return false;
        }
        for (Person student : studentList) {
            if (phoneNumber.equals(student.getPhoneNumber())) {
                return true;
            }
        }
        return false;
    }
}
