package case_study.furama_resort.services;

import case_study.furama_resort.models.Booking;

public interface IPromotionService {

    void displayCustomersByYear(int year);

    void giveVoucher(int voucher10, int voucher20, int voucher50);
}
