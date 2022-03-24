package bai_tap.final_module_2.models;

import bai_tap.final_module_2.models.enums.Gender;
import java.util.Comparator;
import java.util.Date;

public class Teacher extends Person implements Comparator<Teacher> {

    private int teacherID;

    public Teacher(String name, Date dOB, Gender gender, String phoneNumber, int teacherID) {
        super(name, dOB, gender, phoneNumber);
        this.teacherID = teacherID;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    @Override
    public String toString() {
        return "Teacher{" +
            "teacherID='" + teacherID + '\'' +
            super.toString() +
            '}';
    }

    @Override
    public int compare(Teacher o1, Teacher o2) {
        return o1.getTeacherID() - o2.getTeacherID();
    }
}
