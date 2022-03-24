package bai_tap.final_module_2.models;

import bai_tap.final_module_2.models.enums.Gender;
import bai_tap.final_module_2.services.impl.ClassServiceImpl;
import java.util.Date;

public class Student extends Person {

    private int studentID;
    private String classID;

    public Student(String name, Date dOB, Gender gender, String phoneNumber, int studentID,
        String classID) {
        super(name, dOB, gender, phoneNumber);
        this.studentID = studentID;
        this.classID = classID;
    }

    @Override
    public String toString() {
        return "Student{" +
            "studentID='" + studentID + '\'' +
            super.toString() +
            ", classID='" + ClassServiceImpl.getClassNameByClassID(classID) + '\'' +
            '}';
    }

    @Override
    public String toCSVFormat() {
        return studentID + "," + super.toCSVFormat() + "," + classID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }
}
