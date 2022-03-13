package oop_review.quan_ly_phuong_tien.utils;

public class NotFoundVehicleException extends Exception {

    @Override
    public String getMessage() {
        return "Biển kiểm soát không tồn tại";
    }
}
