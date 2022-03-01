package ss11_stack_queue.bai_tap.dao_nguoc_phan_tu_trong_mang_su_dung_stack;

import java.util.Arrays;
import java.util.Stack;

public class ReverseArrayUsingStack {

    public static void main(String[] args) {
        // Đảo ngược mảng số
        Integer[] intArray = {1, 4, 6, 2, 3, 5, 7, 8, 0};
        System.out.println("Number array truoc khi dao nguoc: " + Arrays.toString(intArray));
        reverseArrayUsingStack(intArray);
        System.out.println("Number array sau khi dao nguoc: " + Arrays.toString(intArray));

        // Đảo ngược chuỗi
        String sentence = "This is a test string to reverse";
        System.out.println("String truoc khi dao nguoc: " + sentence);
        String[] words = sentence.split(" ");
        reverseArrayUsingStack(words);
        sentence = String.join(" ", words);
        System.out.println("String sau khi dao nguoc: " + sentence);

    }

    private static <T> void reverseArrayUsingStack(T[] array) {
        Stack<T> stack = new Stack<>();
        for (T j : array) {
            stack.push(j);
        }
//        for (int i = 0; i < array.length; i++) {
//            array[i] = stack.pop();
//        }
        int i = 0;
        while (!stack.isEmpty()) {
            array[i++] = stack.pop();
        }
    }
}
