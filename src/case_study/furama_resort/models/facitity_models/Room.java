package case_study.furama_resort.models.facitity_models;

public class Room extends Facility {

    private String freeServices;

    public Room(String serviceID, String serviceName, int netArea, double totalCost, int numberOfPeopleAllowed, String typeRent,
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
            "freeServices='" + freeServices + '\'' +
            '}';
    }
}
