package ss13_search_algorithm.bai_tap.chuoi_tang_co_do_dai_lon_nhat;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        String string = "Welcozxy";
        LinkedList<Character> max = new LinkedList<>();

        // Find the maximum increasingly ordered subsequence
        for (int i = 0; i < string.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();
            list.add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(j) > list.getLast()) {
                    list.add(string.charAt(j));
                }
            }

            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
            list.clear();
        }

        // Display the maximum consecutive
        // increasingly ordered substring
        for (Character ch: max) { // single loop
            System.out.print(ch); // Simple statement
        }
        System.out.println();

    }
}
