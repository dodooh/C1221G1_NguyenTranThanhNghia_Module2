package bai_tap.final_module_2.utils;

import java.text.SimpleDateFormat;

public class ValidatorInputLibrary {

    public static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static final String NAME_FORMAT = "^[A-Za-z ]{4,50}$";
    public static final String AT_LEAST_ONE_CHARACTER = ".+";
    public static final String STANDARD_NAME = "^[A-Z][a-z]+( [A-Z0-9][a-z0-9]+)*$";
    public static final String REAL_POSITIVE_NUMBER = "^\\d+\\.?\\d*";
    public static final String PHONE_NUMBER = "^09[01]\\d{7}$";
    public static final String ONE_NUMBER = "^\\d$";
    public static final String BIRTHDAY_FORMAT = "^\\d{2}/\\d{2}/\\d{4}$";
}