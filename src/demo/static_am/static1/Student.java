package demo.static_am.static1;

public class Student {

    int id;  // variable, property, truownfg, thuoc tinh, instance variable
    double diem; // 0.0
    String lop; // null
    String mon; // null
    static String school;
    static {
        school = "Codegym";
        System.out.println("Khoi lenh static chay");
    }
    Student() {
        System.out.println("khoi lenh constructor chay");
    }
    Student(double diem, String lop, String mon) {
        this.diem = diem;
        this.lop = lop;
        this.mon = mon;
    }
    Student(int id, double diem, String lop, String mon) {
        this.id = id;
        this.diem = diem;
        this.lop = lop;
        this.mon = mon;
    }
    static void say() {
        System.out.println("Toi hoc o " + school);
    }
    void say2() {
        System.out.println("Day la method nonstatic" + this.diem);
    }
    @Override
    public String toString() {
        return "Student{" +
            "id=" + id +
            ", diem=" + diem +
            ", lop='" + lop + '\'' +
            '}';
    }

}
