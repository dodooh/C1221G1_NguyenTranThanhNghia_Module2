package ss11_stack_queue.bai_tap.demerging_su_dung_queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Date;
import java.util.Queue;

public class Demerging {

    public static void main(String[] args) {
        NhanSu[] nhanSus = new NhanSu[]{
            new NhanSu("Nguyen Van A", "Nam", new Date("02/05/1995"), "Ha Noi"),
            new NhanSu("Nguyen Van B", "Nam", new Date("03/30/1994"), "Ha Tay"),
            new NhanSu("Nguyen Van C", "Nam", new Date("12/26/1993"), "Da Nang"),
            new NhanSu("Tran Thi D", "Nu", new Date("03/02/1994"), "Cao Bang"),
            new NhanSu("Tran Thi E", "Nu", new Date("09/08/1995"), "Ha Giang"),
            new NhanSu("Tran Thi F", "Nu", new Date("11/25/1996"), "Vinh Long"),
        };

        System.out.println("Mảng lúc đầu: ");
        displayArray(nhanSus);

        System.out.println("Mảng sau khi sortByDate: ");
        SortByDate sortImpl = new SortByDate();
        Arrays.sort(nhanSus,sortImpl);
        displayArray(nhanSus);

        System.out.println("Mảng sau khi sortByDate và sortByGioiTinh");
        sortByGioiTinh(nhanSus);
        displayArray(nhanSus);

    }

    private static <T> void displayArray(T[] array) {
        for (T ele : array) {
            System.out.println(ele);
        }
    }

    private static void sortByGioiTinh(NhanSu[] array) {
        Queue<NhanSu> namQueue = new ArrayDeque<>();
        Queue<NhanSu> nuQueue = new ArrayDeque<>();
        for (NhanSu ele : array) {
            if (ele.getGioiTinh().equals("Nam")) {
                namQueue.add(ele);
            } else {
                nuQueue.add(ele);
            }
        }
        int i = 0;
        while (!nuQueue.isEmpty()) {
            array[i++] = nuQueue.poll();
        }
        while (!namQueue.isEmpty()) {
            array[i++] = namQueue.poll();
        }

    }
}
