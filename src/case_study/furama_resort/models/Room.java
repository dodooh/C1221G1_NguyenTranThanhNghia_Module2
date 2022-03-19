package case_study.furama_resort.models;

public class Room extends Facility {

    private String freeServices;

    public Room(String serviceID, String serviceName, double netArea, double totalCost, int numberOfPeopleAllowed,
        String typeRent,
        String freeServices) {
        super(serviceID, serviceName, netArea, totalCost, numberOfPeopleAllowed, typeRent);
        this.freeServices = freeServices;
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }

    @Override
    public String toString() {
        return "Room{" +
            super.toString() +
            ", freeServices='" + freeServices + '\'' +
            '}';
    }

    @Override
    public String toCSVFormat() {
        return super.toCSVFormat() + "," + freeServices;
    }
}
