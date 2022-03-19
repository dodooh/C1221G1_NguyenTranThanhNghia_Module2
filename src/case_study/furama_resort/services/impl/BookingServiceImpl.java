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
    public static Set<Booking> bookingSet = new TreeSet<>();
    private static BookingServiceImpl instance;

    static {
        try {
            bookingSet = ReadWriteCSVFile.readBookingSetFromCSVFile(BOOKING_FILE_PATH);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ParseObjectException e) {
            System.out.println(e.getMessage());
        }
    }

    FacilityMaintenanceServiceImpl facilityBookingService = FacilityMaintenanceServiceImpl.getInstance();

    private BookingServiceImpl() {
    }

    public static BookingServiceImpl getInstance() {
        if (instance == null) {
            instance = new BookingServiceImpl();
        }
        return instance;
    }

    public static Booking findBookingByID(int bookingID) {
        for (Booking booking : bookingSet) {
            if (booking.getBookingID() == bookingID) {
                return booking;
            }
        }
        return null;
    }

    public void displaySet() {
        System.out.println("============Booking Set============");
        if (bookingSet.size() != 0) {
            for (Booking booking : bookingSet) {
                System.out.println(booking);
            }
        } else {
            System.out.println("!!!BOOKING SET IS EMPTY!!!");
        }
    }

    @Override
    public void add(Booking booking) {
        System.out.println(booking);
        if (bookingSet.contains(booking)) {
            System.out.println("!!!CAN NOT ADD SAME BOOKING ID TO SET!!!");
        } else {
            bookingSet.add(booking);
            facilityBookingService.add(booking.getFacility());
            System.out.println("✓Add Facility to Facility Booking Successfully");
            ReadWriteCSVFile.writeSetToCSVFile(bookingSet, BOOKING_FILE_PATH);
            System.out.println("✓Add Booking Successfully");
        }
    }

    public Set<Booking> sendBooking() {
        return bookingSet;
    }

}
