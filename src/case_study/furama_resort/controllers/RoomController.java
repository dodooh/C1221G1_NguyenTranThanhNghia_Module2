package case_study.furama_resort.controllers;

import static case_study.furama_resort.utils.ReadInputFromKeyBoard.inputValidData;

import case_study.furama_resort.models.Room;
import case_study.furama_resort.services.IFacilityService;
import case_study.furama_resort.services.impl.RoomServiceImpl;
import case_study.furama_resort.utils.ValidatorInputLibrary;

public class RoomController {

    private final IFacilityService roomServices = RoomServiceImpl.getInstance();

    public void create() {
        String serviceID = inputValidData("Service ID (SVRO-YYYY)", ValidatorInputLibrary.ROOM_SERVICE_ID);
        String serviceName = inputValidData("Service Name", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
        double netArea = Double.parseDouble(
            inputValidData("Net Area", ValidatorInputLibrary.REAL_NUMBER_LARGER_THAN_30));
        double totalCost = Double.parseDouble(inputValidData("Total Cost", ValidatorInputLibrary.REAL_POSITIVE_NUMBER));
        int numberOfPeopleAllowed = Integer.parseInt(
            inputValidData("Number of People Allowed", ValidatorInputLibrary.PEOPLE_QUANTITY));
        String typeRent = inputValidData("Rent Type", ValidatorInputLibrary.STANDARD_NAME);
        String freeServices = inputValidData("Free Services", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
        roomServices.add(new Room(serviceID, serviceName, netArea, totalCost,
            numberOfPeopleAllowed, typeRent, freeServices));
    }

    public void display() {
        roomServices.displayList();

    }
}
