package ss15_exception.thuc_hanh.su_dung_lop_arrayindexoutofboundsexception;

import java.util.Random;

public class ArrayExample {

    public Integer[] createRandom() {
        Random rd = new Random();
        Integer[] arr = new Integer[100];
        System.out.println("Danh sách phần tử của mảng: ");
        for (int i = 0; i < 100; i++) {
            arr[i] = rd.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        return arr;
    }
}
