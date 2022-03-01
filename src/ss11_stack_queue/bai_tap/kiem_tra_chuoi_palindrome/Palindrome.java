package ss11_stack_queue.bai_tap.kiem_tra_chuoi_palindrome;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {

    public static void main(String[] args) {
        String string = "Able was I erre I saw Elba";
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new ArrayDeque<>();
        for (char c : string.toLowerCase().toCharArray()) {
            stack.push(c);
            queue.add(c);
        }
        boolean isPalindrome = true;
        while (!stack.isEmpty()) {
            if (stack.pop() != queue.poll()) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("\"" + string + "\" là chuỗi Palindrome");
        } else {
            System.out.println("\"" + string + "\" không phải là chuỗi Palindrome");
        }
    }
}
