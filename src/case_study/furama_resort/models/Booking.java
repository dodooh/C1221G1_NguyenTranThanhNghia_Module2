package case_study.furama_resort.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Booking implements CSVable, Comparable<Booking> {

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private String bookingID;
    private Date startDate;
    private Date endDate;
    private Customer customer;
    private Facility facilityType;

    public Booking(String bookingID, Date startDate, Date endDate, Customer customer,
        Facility facilityType) {
        this.bookingID = bookingID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.facilityType = facilityType;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(Facility facilityType) {
        this.facilityType = facilityType;
    }

    @Override
    public String toString() {
        return "Booking{" +
            "bookingID='" + bookingID + '\'' +
            ", startDate=" + simpleDateFormat.format(startDate) +
            ", endDate=" + simpleDateFormat.format(endDate) +
            ", customer='" + customer.getCustomerID() + '\'' +
            ", facilityType=" + facilityType.getServiceID() +
            '}';
    }

    // TO CSV
    @Override
    public String toCSVFormat() {
        return bookingID + "," + simpleDateFormat.format(startDate) + "," + simpleDateFormat.format(endDate) + "," + customer.getCustomerID() + ","
            + facilityType.getServiceID();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Booking booking = (Booking) o;
        return bookingID.equals(booking.bookingID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingID);
    }


    @Override
    public int compareTo(Booking o) {
        if (startDate.compareTo(o.startDate) == 0) {
            return endDate.compareTo(o.endDate);
        } else {
            return startDate.compareTo(o.startDate);
        }
    }
}
