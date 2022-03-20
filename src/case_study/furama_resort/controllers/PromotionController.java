package case_study.furama_resort.controllers;

import static case_study.furama_resort.utils.ReadInputFromKeyBoard.inputValidData;

import case_study.furama_resort.services.impl.BookingServiceImpl;
import case_study.furama_resort.services.impl.PromotionServicesImpl;
import case_study.furama_resort.utils.ValidatorInputLibrary;

public class PromotionController {

    private static PromotionController instance;

    private final BookingServiceImpl bookingService = BookingServiceImpl.getInstance();
    private final PromotionServicesImpl promotionServices = PromotionServicesImpl.getInstance();

    private PromotionController() {
    }

    public static PromotionController getInstance() {
        if (instance == null) {
            instance = new PromotionController();
        }
        return instance;
    }

    void displayCustomerListByYear() {
        System.out.println("===============DISPLAY CUSTOMER LIST BY YEAR==============");
        int year = Integer.parseInt(inputValidData("A Year (1900-2029)", ValidatorInputLibrary.YEAR_FORMAT));
        promotionServices.displayCustomersByYear(year);
    }

    void giveVoucher() {
        System.out.println("===============GIVE VOUCHER FUNCTION==============");
        int voucher10;
        int voucher20;
        int voucher50;
        int numberOfVoucher = bookingService.getAllBookingInCurrentMonth().size();
        if (numberOfVoucher == 0) {
            System.out.println("!!!THERE IS NO BOOKING IN THIS MONTH");
        } else {
            do {
                System.out.println(numberOfVoucher + " VOUCHERS SHOULD BE CREATED IN TOTAL");
                String title = "Number of Voucher following (10% 20% 50%) example: 10 4 1";
                String input = inputValidData(title, ValidatorInputLibrary.VOUCHER_NUMBER_FORMAT);
                voucher10 = Integer.parseInt(input.split(" ")[0]);
                voucher20 = Integer.parseInt(input.split(" ")[1]);
                voucher50 = Integer.parseInt(input.split(" ")[2]);
                if ((voucher10 + voucher20 + voucher50) != numberOfVoucher) {
                    System.out.println("!!!TOTAL MUST BE EQUAL TO " + numberOfVoucher + "!!!");
                } else {
                    promotionServices.giveVoucher(voucher10, voucher20, voucher50);
                    break;
                }
            } while (true);

        }
    }
}
