package case_study.furama_resort.models;

public class Room extends Facility{
    private String freeServices;

    public Room(String freeServices) {
        this.freeServices = freeServices;
    }

    public Room(String serviceName, int netArea, double totalCost, int numberOfPeopleAllowed, String typeRent, String freeServices) {
        super(serviceName, netArea, totalCost, numberOfPeopleAllowed, typeRent);
        this.freeServices = freeServices;
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }
}
