package ss5_access_modifier_static.bai_tap.xay_dung_lop_chi_ghi;

public class Student {
    private String name;
    private String classes;

    public Student() {
        name = "John";
        classes = "CO2";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    String getName() {
        return name;
    }

    protected String getClasses() {
        return classes;
    }
}
