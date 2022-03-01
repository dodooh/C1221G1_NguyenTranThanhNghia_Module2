package ss11_stack_queue.bai_tap.chuyen_doi_he_thap_phan_sang_nhi_phan;

import java.util.Stack;

public class DecimalToBinary {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int numberToConvert = 11;
        System.out.printf("Số %d trong hệ nhị phân là: ", numberToConvert);
        while (numberToConvert != 0) {
            stack.push(numberToConvert % 2);
            numberToConvert /= 2;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
