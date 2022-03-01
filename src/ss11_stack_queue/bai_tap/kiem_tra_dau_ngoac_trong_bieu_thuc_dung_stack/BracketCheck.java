package ss11_stack_queue.bai_tap.kiem_tra_dau_ngoac_trong_bieu_thuc_dung_stack;

import java.util.Stack;

public class BracketCheck {

    public static void main(String[] args) {
        System.out.println(isValidBracket("{s * (s – a) * (s – b) * (s – c)"));
        System.out.println(isValidBracket("{[– b + (b*b – 4*a*c)^0.5] / 2 * a}"));
        System.out.println(isValidBracket("[s * (s – ]a) * (s – b * (s – c)"));
        System.out.println(isValidBracket("s * (s – a) * s – b) * (s – c)"));
        System.out.println(isValidBracket("[– b + (b^2 – 4*a*c)^(0.5/ 2*a)]"));
    }

    private static boolean isValidBracket(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char checkedBracket = stack.peek();
                // kiểm tra dấu đóng ngoặc với mở ngoặc có tương ứng không
                // nếu KHÔNG có cặp nào tương ứng thì trả về false;
                if (!((c == ')' && checkedBracket == '(') ||
                    (c == ']' && checkedBracket == '[') ||
                    (c == '}' && checkedBracket == '{'))) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
