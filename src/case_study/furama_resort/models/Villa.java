package case_study.furama_resort.models;

public class Villa extends Facility{
    private int roomStar;
    private int poolArea;
    private int numberOfFloor;

    public Villa(int roomStar, int poolArea, int numberOfFloor) {
        this.roomStar = roomStar;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
    }

    public Villa(String serviceName, int netArea, double totalCost, int numberOfPeopleAllowed, String typeRent, int roomStar, int poolArea,
        int numberOfFloor) {
        super(serviceName, netArea, totalCost, numberOfPeopleAllowed, typeRent);
        this.roomStar = roomStar;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
    }

    public int getRoomStar() {
        return roomStar;
    }

    public void setRoomStar(int roomStar) {
        this.roomStar = roomStar;
    }

    public int getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(int poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return "Villa{" +
            "roomStar=" + roomStar +
            ", poolArea=" + poolArea +
            ", numberOfFloor=" + numberOfFloor +
            '}';
    }
}
