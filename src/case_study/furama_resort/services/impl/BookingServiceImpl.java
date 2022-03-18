package case_study.furama_resort.services.impl;

import case_study.furama_resort.models.Booking;
import case_study.furama_resort.services.IBookingService;
import case_study.furama_resort.utils.ReadWriteCSVFile;
import java.util.Set;
import java.util.TreeSet;

public class BookingServiceImpl implements IBookingService {
    private static final String BOOKING_FILE_PATH = "src/case_study/furama_resort/data/booking.csv";
    private static BookingServiceImpl instance;
    private BookingServiceImpl() {
    }
    public static BookingServiceImpl getInstance() {
        if (instance == null) {
            instance = new BookingServiceImpl();
        }
        return instance;
    }
    public static TreeSet<Booking> bookingTreeSet = new TreeSet<>();

    @Override
    public void displaySet(Set<Booking> set) {
        System.out.println("============Booking Set============");
        for (Booking booking: set) {
            System.out.println(booking);
        }
    }

    @Override
    public void add(Booking booking) {
        System.out.println(booking);
        if (bookingTreeSet.contains(booking)) {
            System.out.println("!!!CAN NOT ADD SAME BOOKING ID TO SET!!!");
        } else {
            bookingTreeSet.add(booking);
            ReadWriteCSVFile.writeSetToCSV(bookingTreeSet,BOOKING_FILE_PATH);
            System.out.println("Add Successfully");
        }
    }
}
