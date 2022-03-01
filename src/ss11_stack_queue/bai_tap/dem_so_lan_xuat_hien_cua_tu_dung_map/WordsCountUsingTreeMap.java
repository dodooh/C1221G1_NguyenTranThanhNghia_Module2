package ss11_stack_queue.bai_tap.dem_so_lan_xuat_hien_cua_tu_dung_map;

import java.util.Map;
import java.util.TreeMap;

public class WordsCountUsingTreeMap {

    public static void main(String[] args) {
        String sentence = "This is a test string this iS a test case thiS is";
        System.out.println(sentence);

        // TreeMap: sắp xếp các key theo thứ tự tự nhiên hoặc dùng Comparator.
        Map<String, Integer> dictionary = new TreeMap<>();
        String[] words = sentence.toLowerCase().split(" ");
        for (String word : words) {
            if (!dictionary.containsKey(word)) {
                dictionary.put(word, 1);
            } else {
                dictionary.replace(word, dictionary.get(word) + 1);
            }
        }
        System.out.println("Đếm từ trong chuỗi:\n" + dictionary);

    }
}
