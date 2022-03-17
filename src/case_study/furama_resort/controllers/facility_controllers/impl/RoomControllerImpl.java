package case_study.furama_resort.controllers.facility_controllers.impl;

import static case_study.furama_resort.utils.ReadInputFromKeyBoard.askUserToInputValidData;

import case_study.furama_resort.controllers.facility_controllers.IFacilityController;
import case_study.furama_resort.models.facitity_models.Room;
import case_study.furama_resort.services.facility_services.IFacilityService;
import case_study.furama_resort.services.facility_services.impl.RoomServiceImpl;
import case_study.furama_resort.utils.ValidatorInputLibrary;

public class RoomControllerImpl implements IFacilityController {

    IFacilityService roomServices = new RoomServiceImpl();

    @Override
    public void create() {
        String serviceID = askUserToInputValidData("Service ID", ValidatorInputLibrary.ROOM_SERVICE_ID);
        String serviceName = askUserToInputValidData("Service Name", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
        double netArea = Double.parseDouble(askUserToInputValidData("Net Area", ValidatorInputLibrary.REAL_NUMBER_LARGER_THAN_30));
        double totalCost = Double.parseDouble(askUserToInputValidData("Total Cost", ValidatorInputLibrary.REAL_POSITIVE_NUMBER));
        int numberOfPeopleAllowed = Integer.parseInt(askUserToInputValidData("Number of People Allowed", ValidatorInputLibrary.PEOPLE_QUANTITY));
        String typeRent = askUserToInputValidData("Rent Type", ValidatorInputLibrary.STANDARD_NAME);
        String freeServices = askUserToInputValidData("Free Services", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
        roomServices.add(new Room(
            serviceID,
            serviceName,
            netArea,
            totalCost,
            numberOfPeopleAllowed,
            typeRent,
            freeServices));
    }

    @Override
    public void display() {
        roomServices.displayList(RoomServiceImpl.roomList);

    }
}
