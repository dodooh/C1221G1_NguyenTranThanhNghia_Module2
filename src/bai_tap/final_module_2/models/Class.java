package bai_tap.final_module_2.models;

public class Class {

    private String classID;
    private String className;
    private String teacherID;

    public Class(String classID, String className, String teacherID) {
        this.classID = classID;
        this.className = className;
        this.teacherID = teacherID;
    }

    @Override
    public String toString() {
        return "Class{" +
            "classID='" + classID + '\'' +
            ", className='" + className + '\'' +
            ", teacherID='" + teacherID + '\'' +
            '}';
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }
}
