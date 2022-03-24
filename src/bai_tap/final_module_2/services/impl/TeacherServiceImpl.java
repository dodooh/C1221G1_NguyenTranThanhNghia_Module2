package bai_tap.final_module_2.services.impl;

import bai_tap.final_module_2.models.Person;
import bai_tap.final_module_2.models.Teacher;
import bai_tap.final_module_2.utils.ReadWriteCSVFile;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TeacherServiceImpl {

    private static final String TEACHER_FILE_PATH = "src/bai_tap/final_module_2/data/teachers.csv";
    private static List<Person> teacherList = new ArrayList<>();

    static {
        try {
            teacherList = ReadWriteCSVFile.readTeacherListFromCSVFile(TEACHER_FILE_PATH);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Person> getTeacherList() {
        return teacherList;
    }

    public void display() {
        Collections.sort(teacherList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return ((Teacher) o1).getTeacherID() - ((Teacher) o2).getTeacherID();
            }
        });
        System.out.println("=========Student List==========");
        if (teacherList != null && teacherList.size() != 0) {
            int index = 0;
            for (Person student : teacherList) {
                System.out.printf("[%d] - %s\n", index++, student);
            }
        } else {
            System.out.println("!!!Student List IS EMPTY!!!");
        }
    }
}
