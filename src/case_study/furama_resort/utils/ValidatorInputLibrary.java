package case_study.furama_resort.utils;

public class ValidatorInputLibrary {

    public static final String AT_LEAST_ONE_CHARACTER = "\\w*";
    public static final String STANDARD_NAME = "^[A-Z][a-z]+( [A-Z0-9][a-z0-9]+)*$";
    public static final String REAL_NUMBER_LARGER_THAN_30 = "^([3-9]\\d|\\d{3,})(.\\d{1,3})?$";
    public static final String REAL_POSITIVE_NUMBER = "^\\d+\\.?\\d*";
    public static final String INTEGER_POSITIVE_NUMBER = "^[1-9]\\d*$";
    public static final String PEOPLE_QUANTITY = "^([1-9]|(1\\d))$";
    public static final String VILLA_SERVICE_ID = "^SVVL-\\d{4}$";
    public static final String HOUSE_SERVICE_ID = "^SVHO-\\d{4}$";
    public static final String ROOM_SERVICE_ID = "^SVRO-\\d{4}$";

    static boolean isMatch(String input, String regex) {
        return input.matches(regex);
    }

}