package case_study.furama_resort.services.impl;

import case_study.furama_resort.models.Booking;
import case_study.furama_resort.services.IBookingService;
import case_study.furama_resort.utils.ParseObjectException;
import case_study.furama_resort.utils.ReadWriteCSVFile;
import java.text.ParseException;
import java.util.Set;
import java.util.TreeSet;

public class BookingServiceImpl implements IBookingService {

    private static final String BOOKING_FILE_PATH = "src/case_study/furama_resort/data/booking.csv";
    public static Set<Booking> bookingTreeSet = new TreeSet<>();
    private static BookingServiceImpl instance;

    static {
        try {
            bookingTreeSet = ReadWriteCSVFile.readBookingSetFromCSVFile(BOOKING_FILE_PATH);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ParseObjectException e) {
            System.out.println(e.getMessage());
        }
    }

    private BookingServiceImpl() {
    }

    public static BookingServiceImpl getInstance() {
        if (instance == null) {
            instance = new BookingServiceImpl();
        }
        return instance;
    }

    public void displaySet() {
        System.out.println("============Booking Set============");
        if (bookingTreeSet.size() != 0) {
            for (Booking booking : bookingTreeSet) {
                System.out.println(booking);
            }
        } else {
            System.out.println("!!!BOOKING SET IS EMPTY!!!");
        }
    }

    @Override
    public void add(Booking booking) {
        System.out.println(booking);
        if (bookingTreeSet.contains(booking)) {
            System.out.println("!!!CAN NOT ADD SAME BOOKING ID TO SET!!!");
        } else {
            bookingTreeSet.add(booking);
            ReadWriteCSVFile.writeSetToCSV(bookingTreeSet, BOOKING_FILE_PATH);
            System.out.println("Add Successfully");
        }
    }
}
