package bai_tap.quan_ly_ngan_hang_8.utils;

public class NotFoundBankAccountException extends Exception {

    @Override
    public String getMessage() {
        return "This Account Is Not Existence!!!";
    }
}
