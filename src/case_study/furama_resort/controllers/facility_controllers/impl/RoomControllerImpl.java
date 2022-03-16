package case_study.furama_resort.controllers.facility_controllers.impl;

import static case_study.furama_resort.utils.ValidatorInput.askUserToInputField;

import case_study.furama_resort.controllers.facility_controllers.IFacilityController;
import case_study.furama_resort.models.facitity_models.Room;
import case_study.furama_resort.services.facility_services.IFacilityService;
import case_study.furama_resort.services.facility_services.impl.RoomServiceImpl;
import case_study.furama_resort.services.facility_services.impl.VillaServiceImpl;
import case_study.furama_resort.utils.ValidatorInput;

public class RoomControllerImpl implements IFacilityController {
    IFacilityService roomServices = new RoomServiceImpl();
    @Override
    public void create() {
        String serviceID = askUserToInputField("Service ID", ValidatorInput.IS_NOT_AN_EMPTY_STRING);
        String serviceName = askUserToInputField("Service Name", ValidatorInput.IS_NOT_AN_EMPTY_STRING);
        int netArea = Integer.parseInt(askUserToInputField("Net Area", ValidatorInput.IS_NOT_AN_EMPTY_STRING));
        double totalCost = Double.parseDouble(askUserToInputField("Total Cost", ValidatorInput.IS_NOT_AN_EMPTY_STRING));
        int numberOfPeopleAllowed = Integer.parseInt(askUserToInputField("Number of People Allowed", ValidatorInput.IS_NOT_AN_EMPTY_STRING));
        String typeRent = askUserToInputField("Rent Type", ValidatorInput.IS_NOT_AN_EMPTY_STRING);
        String freeServices = askUserToInputField("Free Services", ValidatorInput.IS_NOT_AN_EMPTY_STRING);
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
