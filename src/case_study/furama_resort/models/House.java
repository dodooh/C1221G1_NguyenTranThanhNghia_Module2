package case_study.furama_resort.models;

public class House extends Facility {

    private int roomStar;
    private int numberOfFloor;

    public House(int roomStar, int numberOfFloor) {
        this.roomStar = roomStar;
        this.numberOfFloor = numberOfFloor;
    }

    public House(String serviceName, int netArea, double totalCost, int numberOfPeopleAllowed, String typeRent, int roomStar, int numberOfFloor) {
        super(serviceName, netArea, totalCost, numberOfPeopleAllowed, typeRent);
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
            "roomStar=" + roomStar +
            ", numberOfFloor=" + numberOfFloor +
            '}';
    }
}
