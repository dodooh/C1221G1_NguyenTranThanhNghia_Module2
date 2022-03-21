package case_study.furama_resort.services.impl;

import case_study.furama_resort.models.Booking;
import case_study.furama_resort.models.Customer;
import case_study.furama_resort.services.IPromotionService;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class PromotionServicesImpl implements IPromotionService {

    private static PromotionServicesImpl instance;

    private final BookingServiceImpl bookingService = BookingServiceImpl.getInstance();

    private PromotionServicesImpl() {
    }

    public static PromotionServicesImpl getInstance() {
        if (instance == null) {
            instance = new PromotionServicesImpl();
        }
        return instance;
    }

    @Override
    public void displayCustomersByYear(int year) {
        Set<Booking> bookingSet = new TreeSet<>(bookingService.sendBooking());
//        Set<Customer> customerSet = new <>();;
        Set<Customer> customerSet = new HashSet<>();
        for (Booking booking : bookingSet) {
            // So sanh nam
            Date bookingStartDate = booking.getStartDate();
            if (year == bookingStartDate.getYear() + 1900) {
                customerSet.add(booking.getCustomer());
            }
        }
        if (customerSet.size() == 0) {
            System.out.println("!!!THERE IS NO CUSTOMER FOR THE YEAR " + year + "!!!");
        } else {
            for (Customer customer : customerSet) {
                System.out.println(customer);
            }
        }
    }

    @Override
    public void giveVoucher(int voucher10, int voucher20, int voucher50) {
        Customer currentCustomer;
        Stack<Booking> bookingList = bookingService.getAllBookingInCurrentMonth();
        System.out.println("Customers get 10% OFF voucher");
        while (!bookingList.isEmpty() && voucher10 != 0) {
            currentCustomer = bookingList.pop().getCustomer();
            System.out.println(currentCustomer);
            voucher10--;
        }
        System.out.println("Customers get 20% OFF voucher");
        while (!bookingList.isEmpty() && voucher20 != 0) {
            currentCustomer = bookingList.pop().getCustomer();
            System.out.println(currentCustomer);
            voucher20--;
        }
        System.out.println("Customer get 50% OFF voucher");
        while (!bookingList.isEmpty() && voucher50 != 0) {
            currentCustomer = bookingList.pop().getCustomer();
            System.out.println(currentCustomer);
            voucher50--;
        }
    }
}
