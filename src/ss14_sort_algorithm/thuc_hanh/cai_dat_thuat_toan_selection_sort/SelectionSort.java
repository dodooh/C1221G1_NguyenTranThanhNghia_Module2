package ss14_sort_algorithm.thuc_hanh.cai_dat_thuat_toan_selection_sort;

import java.util.Arrays;

public class SelectionSort {

    static int[] list = {3, 4, 5, 2, 1};

    // codes below here
    public static void selectionSort(int[] list) {
        System.out.println(Arrays.toString(list));

        for (int i = 0; i < list.length - 1; i++) {
            /* Find the minimum in the list[i..list.length-1] */
            int currentMin = list[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            /* Swap list[i] with list[currentMinIndex] if necessary */
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
            System.out.println(Arrays.toString(list));

        }
    }

    public static void main(String[] args) {
        selectionSort(list);
        for (double v : list) {
            System.out.print(v + " ");
        }
    }
}
