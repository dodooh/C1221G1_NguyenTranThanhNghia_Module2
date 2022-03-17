package case_study.furama_resort.models;

import case_study.furama_resort.models.facitity_models.Facility;
import java.util.Date;

public class Booking implements CSVable {

    private String bookingID;
    private Date startDate;
    private Date endDate;
    private String customerID;
    private String serviceName;
    private Facility facilityType;

    public Booking(String bookingID, Date startDate, Date endDate, String customerID, String serviceName,
        Facility facilityType) {
        this.bookingID = bookingID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customerID = customerID;
        this.serviceName = serviceName;
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

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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
            ", startDate=" + startDate +
            ", endDate=" + endDate +
            ", customerID='" + customerID + '\'' +
            ", serviceName='" + serviceName + '\'' +
            ", facilityType=" + facilityType +
            '}';
    }

    @Override
    public String toCSVFormat() {
        return bookingID + "," + startDate + "," + endDate + "," + customerID + "," + serviceName + "," + facilityType;
    }
}
