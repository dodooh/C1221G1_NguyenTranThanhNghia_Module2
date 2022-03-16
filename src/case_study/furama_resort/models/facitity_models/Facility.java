package case_study.furama_resort.models.facitity_models;

import java.util.Objects;

public abstract class Facility {

    private String serviceID;
    private String serviceName;
    private int netArea;
    private double totalCost;
    private int numberOfPeopleAllowed;
    private String typeRent;

    public Facility() {
    }

    public Facility(String serviceID, String serviceName, int netArea, double totalCost, int numberOfPeopleAllowed, String typeRent) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.netArea = netArea;
        this.totalCost = totalCost;
        this.numberOfPeopleAllowed = numberOfPeopleAllowed;
        this.typeRent = typeRent;
    }

    public String getServiceID() {
        return serviceID;
    }

    public void setServiceID(String serviceID) {
        this.serviceID = serviceID;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getNetArea() {
        return netArea;
    }

    public void setNetArea(int netArea) {
        this.netArea = netArea;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public int getNumberOfPeopleAllowed() {
        return numberOfPeopleAllowed;
    }

    public void setNumberOfPeopleAllowed(int numberOfPeopleAllowed) {
        this.numberOfPeopleAllowed = numberOfPeopleAllowed;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }

    @Override
    public String toString() {
        return
            ", serviceID='" + serviceID + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", netArea=" + netArea +
                ", totalCost=" + totalCost +
                ", numberOfPeopleAllowed=" + numberOfPeopleAllowed +
                ", typeRent='" + typeRent + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Facility facility = (Facility) o;
        return serviceID.equals(facility.serviceID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceID);
    }
}
