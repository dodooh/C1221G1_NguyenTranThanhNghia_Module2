package demo.set;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapDemo {

    public static void main(String[] args) {
//        0 100
        int random = (int) (Math.random() * 101);
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Mời bạn đoán: ");
            choice = Integer.parseInt(scanner.nextLine());
            if (choice == random) {
                System.out.println("Bạn thắng");
                break;
            } else if (choice > random) {
                System.out.println("số vừa nhạp lớn hơn số cần tìm");
            } else {
                System.out.println("số vừa nhạp nhỏ hơn số cần tìm");

            }
        } while (true);

//        Map<String, String> dictionary = new HashMap<>();
//        dictionary.put("hello", "xin chaof");
//        dictionary.put("goodbye", "tam biet");
//        dictionary.put("morning", "ban ngay");
//
//        System.out.println(dictionary.get("goodbye"));;
//        Set<String> keys = dictionary.keySet();
//        for (String key : keys) {
//            System.out.println(key + ": " + dictionary.get(key));
//        }
    }
}
