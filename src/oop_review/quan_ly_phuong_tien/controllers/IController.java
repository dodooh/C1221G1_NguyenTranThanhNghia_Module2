package oop_review.quan_ly_phuong_tien.controllers;

import oop_review.quan_ly_phuong_tien.models.PhuongTien;

public interface IController {

    PhuongTien inputPhuongTien();

    boolean askToRemove(PhuongTien phuongTien);
}
