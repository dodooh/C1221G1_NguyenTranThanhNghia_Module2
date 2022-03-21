package case_study.furama_resort.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Booking implements CSVable, Comparable<Booking> {

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private int bookingID;
    private Date startDate;
    private Date endDate;
    private Customer customer;
    private Facility facility;
    private boolean signedContract;

    public Booking(int bookingID, Date startDate, Date endDate, Customer customer,
        Facility facilityType, boolean contractStatus) {
        this.bookingID = bookingID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.facility = facilityType;
        this.signedContract = contractStatus;
    }

    public Booking(int bookingID, Date startDate, Date endDate, Customer customer,
        Facility facilityType) {
        this.bookingID = bookingID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.facility = facilityType;
        this.signedContract = false;
    }

    public boolean isSignedContract() {
        return signedContract;
    }

    public void setSignedContract(boolean signedContract) {
        this.signedContract = signedContract;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
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

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    @Override
    public String toString() {
        return "Booking{" +
            "bookingID='" + bookingID + '\'' +
            ", startDate=" + simpleDateFormat.format(startDate) +
            ", endDate=" + simpleDateFormat.format(endDate) +
            ", \n\t\t" + customer +
            ", \n\t\t" + facility +
            ", \n\t\tisContract=" + signedContract +
            '}';
    }

    // TO CSV
    @Override
    public String toCSVFormat() {
        return bookingID + "," + simpleDateFormat.format(startDate) + "," + simpleDateFormat.format(endDate) + ","
            + customer.getCustomerID() + ","
            + facility.getServiceID() + "," + signedContract;
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
        return bookingID == booking.bookingID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingID);
    }


    @Override
    public int compareTo(Booking o) {
        if (startDate.compareTo(o.startDate) == 0) {
            if (endDate.compareTo(o.endDate) == 0) {
                return 1;
            } else {
                return endDate.compareTo(o.endDate);
            }
        } else {
            return startDate.compareTo(o.startDate);
        }
    }
}
