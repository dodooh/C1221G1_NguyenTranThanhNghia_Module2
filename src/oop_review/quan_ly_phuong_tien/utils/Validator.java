package oop_review.quan_ly_phuong_tien.utils;

import java.time.Year;
import oop_review.quan_ly_phuong_tien.models.Oto;

public class Validator {

    public static boolean isValidYear(int year) {
        return year > 1900 && year < Year.now().getValue();
    }

    public static boolean isValidNumber(String number) {
        return number.matches("^\\d+[^a-zA-Z]");
    }

    public static boolean isRequired(String input) {
        return input.length() > 0;
    }

    public static boolean isValidOto(String input, Oto.KieuXe kieuXe) {
        if (kieuXe == Oto.KieuXe.XE_DU_LICH) {
            String otoDuLichRegex = "^\\d{2}A-\\d{3}\\.\\d{2}";
            return input.matches(otoDuLichRegex);
        } else {
            String otoXeKhachRegex = "^\\d{2}B-\\d{3}\\.\\d{2}";
            return input.matches(otoXeKhachRegex);
        }
    }

    public static boolean isValidXeTai(String input) {
        String xeTaiRegex = "^\\d{2}C-\\d{3}\\.\\d{2}";
        return input.matches(xeTaiRegex);
    }

    public static boolean isValidXeMay(String input) {
        String xeMayRegex = "^\\d{2}-[A-Z][A-Z0-9]-\\d{3}\\.\\d{2}";
        return input.matches(xeMayRegex);
    }
}
