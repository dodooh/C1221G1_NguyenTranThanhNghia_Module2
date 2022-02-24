package ss7_abstract_interface.thuc_hanh.implement_interface_comparator_cho_lop_hinh_hoc;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {

    @Override
    public int compare(Circle c1, Circle c2) {
        return Double.compare(c1.getRadius(), c2.getRadius());
    }
}
