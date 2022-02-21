package ss5_access_modifier_static.bai_tap.xay_dung_lop_chi_ghi;

public class Test {

    public static void main(String[] args) {
        Student st = new Student();
        st.setClasses("C12");
        st.setName("Nguyen");
        System.out.println("Name: " + st.getName());
        System.out.println("Class: " + st.getClasses());
    }
}
