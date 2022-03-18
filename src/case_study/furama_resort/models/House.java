package case_study.furama_resort.models;

public class House extends Facility {

    private int roomStar;
    private int numberOfFloor;

    public House(String serviceID, String serviceName, double netArea, double totalCost, int numberOfPeopleAllowed, String typeRent, int roomStar,
        int numberOfFloor) {
        super(serviceID, serviceName, netArea, totalCost, numberOfPeopleAllowed, typeRent);
        this.roomStar = roomStar;
        this.numberOfFloor = numberOfFloor;
    }

    public int getRoomStar() {
        return roomStar;
    }

    public void setRoomStar(int roomStar) {
        this.roomStar = roomStar;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return "House{" +
            super.toString() +
            ", roomStar=" + roomStar +
            ", numberOfFloor=" + numberOfFloor +
            '}';
    }

    @Override
    public String toCSVFormat() {
        return super.toCSVFormat() + "," + roomStar + "," + numberOfFloor;
    }
}
