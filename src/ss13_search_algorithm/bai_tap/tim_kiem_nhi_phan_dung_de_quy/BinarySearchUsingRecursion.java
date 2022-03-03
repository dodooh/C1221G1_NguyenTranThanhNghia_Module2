package ss13_search_algorithm.bai_tap.tim_kiem_nhi_phan_dung_de_quy;

public class BinarySearchUsingRecursion {

    public static void main(String[] args) {
        int[] arr = {1,3,4,5,6,7,8,9,10,12,13,14,16,17,18,20,22,25};
        System.out.println(binarySearch(arr,5));
        System.out.println(binarySearch(arr,10));
        System.out.println(binarySearch(arr,13));
        System.out.println(binarySearch(arr,0));
        System.out.println(binarySearch(arr,15));
        System.out.println(binarySearch(arr,19));
        System.out.println(binarySearch(arr,40));
    }
    private static int binarySearch(int[] arr, int value) {
        return binarySearch(arr,0,arr.length-1,value);
    }

    private static int binarySearch(int[] array, int left, int right, int value) {
        if (left > right) {
            return -1;
        }
        int middle = (left + right) / 2;
        if (array[middle] == value) {
            return middle;
        } else if (array[middle] > value) {
            return binarySearch(array, left, middle - 1, value);
        } else {
            return binarySearch(array, middle + 1, right, value);
        }

    }
}
