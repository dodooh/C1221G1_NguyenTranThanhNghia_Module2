package ss14_sort_algorithm.thuc_hanh.cai_dat_thuat_toan_bubble_sort;

import java.util.Arrays;

public class BubbleSort {

    static int[] list = {3, 4, 5, 2, 1};

    public static void bubbleSort(int[] list) {
        boolean needNextPass = true;
        int time = 0;
        System.out.println(Arrays.toString(list));

        for (int k = 1; k < list.length && needNextPass; k++) {
            /* Array may be sorted and next pass not needed */
            needNextPass = false;

            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    /* Swap list[i] with list[i + 1] */
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true; /* Next pass still needed */
                }
            }
            time++;
            System.out.println(Arrays.toString(list));
        }
        System.out.println(time);
    }

    public static void main(String[] args) {
        bubbleSort(list);

        for (int j : list) {
            System.out.print(j + " ");
        }
    }
}
