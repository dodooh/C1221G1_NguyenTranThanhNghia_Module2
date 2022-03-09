package demo.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) {
        String str = "hello world heLlo Hello this is a test wORLD";
        str = str.toLowerCase();
        String[] wordsArray = str.split(" ");
        System.out.println(Arrays.toString(wordsArray));

        Map<String, Integer> wordsMap = new HashMap<>();
//        <K,V> => 1 entry
        // <hello, 1> => 1
        // <world, 2> => 1
//       .entrySet() => Entry[]
        // 1. chưa xh
        // 2. đã xh
        for (String ele : wordsArray) {
            if (!wordsMap.containsKey(ele)) {
                wordsMap.put(ele, 1);
            } else {
                wordsMap.put(ele, wordsMap.get(ele) + 1);
            }
        }
        for (Entry<String,Integer> entry : wordsMap.entrySet()) {
            System.out.println(entry.getKey() + " xuất hiện " + entry.getValue() + " lần");
        }

    }
}
