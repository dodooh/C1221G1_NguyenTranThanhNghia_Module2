package ss14_sort_algorithm.bai_tap.minh_hoa_insertion_sort;

public class Main {

    static int[] list = {12, 2, 7, -2, 5, 14};

    public static void insertionSort(int[] list) {
        int pos, x;
        System.out.println("Bắt đầu sắp xếp mảng...");
        for (int i = 1; i < list.length; i++) { //đoạn array[0] đã sắp xếp
            System.out.printf("Lấy %d ra khỏi vị trí %d\n", list[i], i);
            x = list[i];
            pos = i;
            while (pos > 0 && x < list[pos - 1]) {
                System.out.printf("-->Đưa %d vào vị trí %d\n", list[pos - 1], pos);
                list[pos] = list[pos - 1]; // đổi chỗ
                pos--;
            }
            list[pos] = x;
            System.out.printf("-->Đưa %d vào vị trí %d\n", x, pos);
            System.out.printf("Mảng sau sắp xếp lần %d:", i);
            printList();
            System.out.println();
        }
        System.out.println("Đã hoàn thành sắp xếp!");

    }

    public static void main(String[] args) {
        System.out.print("Mảng ban đầu: ");
        printList();
        insertionSort(list);
        System.out.print("Mảng sau sắp xếp: ");
        printList();
    }

    private static void printList() {
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
