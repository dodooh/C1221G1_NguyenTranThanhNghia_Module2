package bai_tap.quan_ly_dien_thoai_9.utils;

public class NotFoundProductException extends Exception {

    @Override
    public String getMessage() {
        return "Patient ID is not exist";
    }
}
