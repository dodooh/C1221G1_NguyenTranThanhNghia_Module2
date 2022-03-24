package bai_tap.quan_ly_benh_an_11.utils;

public class EnumUtils {

    public static <T extends Enum<T>> void displayMenu(Class<T> clazz) {
        int i = 0;
        for (T item : clazz.getEnumConstants()) {
            System.out.printf("[%d] - %s\t", i++, item);
        }
    }
}
