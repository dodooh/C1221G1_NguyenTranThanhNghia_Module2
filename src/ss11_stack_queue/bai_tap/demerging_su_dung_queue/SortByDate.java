package ss11_stack_queue.bai_tap.demerging_su_dung_queue;

import java.util.Comparator;

public class SortByDate implements Comparator<NhanSu> {

    @Override
    public int compare(NhanSu o1, NhanSu o2) {
        return o1.getNamSinh().compareTo(o2.getNamSinh());
    }
}
