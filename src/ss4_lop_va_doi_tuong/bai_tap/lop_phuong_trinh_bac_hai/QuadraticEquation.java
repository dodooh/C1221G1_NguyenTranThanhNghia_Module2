package ss4_lop_va_doi_tuong.bai_tap.lop_phuong_trinh_bac_hai;

public class QuadraticEquation {
    // UML diagram
    /*******************************************************
     *                 QuadraticEquation                    *
     --------------------------------------------------------
     * -a: double                                           *
     * -b: double                                           *
     * -c: double                                           *
     * +QuadraticEquation(a: double, b: double, c: double) *
     * +getA(): double                                      *
     * +getB(): double                                      *
     * +getC(): double                                      *
     * +getDiscriminant(): double                           *
     * +getRoot1(): double                                  *
     * +getRoot2(): double                                  *
     *******************************************************/

    private double a,b,c;

    QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant() {
        return Math.pow(b, 2) - 4 * a * c;
    }

    public double getRoot1() {
        return getDiscriminant() < 0 ? 0 :
            ((-b) + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
    }

    public double getRoot2() {
        return getDiscriminant() < 0 ? 0 :
            ((-b) - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
    }

}
