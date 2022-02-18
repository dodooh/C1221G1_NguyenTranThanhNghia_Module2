package ss4_lop_va_doi_tuong.bai_tap.lop_stop_watch;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Tạo mảng có 100,000 phần tử ngẫu nhiên
        final int SIZE = 100000;
        int[] arr = getRandomArray(SIZE);
        System.out.println("Mảng ban đầu là: " + Arrays.toString(arr));

        StopWatch sw = new StopWatch();
        sw.start();

        // Insertion Sort
        selectionSort(arr);

        sw.stop();

        System.out.println("Mảng sau sắp xếp là: " + Arrays.toString(arr));
        long time = sw.getElapsedTime();
        System.out.println("Insertion Sort tốn: " + time + "ms");
    }

    private static int[] getRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size) + 1;
        }
        return arr;
    }

    private static void selectionSort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            int min = i;
            for (int j = i + 1; j < size; j++) {
                min = arr[j] < arr[min] ? j : min;
            }
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
}
