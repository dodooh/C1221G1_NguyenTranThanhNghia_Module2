package oop_review.oop_java_2.bai1_quan_ly_can_bo;

import java.util.Comparator;

public class ComparatorCanBo implements Comparator<CanBo> {

    @Override
    public int compare(CanBo o1, CanBo o2) {
        if (o1 != null && o2 != null) {
            return o1.getHoTen().compareTo(o2.getHoTen());
        }
        return 0;
    }
}
