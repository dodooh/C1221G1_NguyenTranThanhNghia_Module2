package oop_review.quan_ly_phuong_tien.views;

import oop_review.quan_ly_phuong_tien.controllers.PhuongTienController;
import oop_review.quan_ly_phuong_tien.models.HangSanXuat;

import static oop_review.quan_ly_phuong_tien.services.impl.HangSanXuatImpl.hangSanXuats;

public class View {

    public static void main(String[] args) {
        PhuongTienController phuongTienController = new PhuongTienController();
        phuongTienController.showMainMenu();
    }
}
