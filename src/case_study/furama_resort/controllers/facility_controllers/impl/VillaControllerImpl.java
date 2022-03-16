package case_study.furama_resort.controllers.facility_controllers.impl;

import static case_study.furama_resort.utils.ValidatorInput.askUserToInputField;

import case_study.furama_resort.controllers.facility_controllers.IFacilityController;
import case_study.furama_resort.models.facitity_models.Villa;
import case_study.furama_resort.services.facility_services.IFacilityService;
import case_study.furama_resort.services.facility_services.impl.VillaServiceImpl;
import case_study.furama_resort.utils.ValidatorInput;

public class VillaControllerImpl implements IFacilityController {

    IFacilityService villaServices = new VillaServiceImpl();

    @Override
    public void create() {
        String serviceID = askUserToInputField("Service ID", ValidatorInput.IS_NOT_AN_EMPTY_STRING);
        String serviceName = askUserToInputField("Service Name", ValidatorInput.IS_NOT_AN_EMPTY_STRING);
        int netArea = Integer.parseInt(askUserToInputField("Net Area", ValidatorInput.IS_NOT_AN_EMPTY_STRING));
        double totalCost = Double.parseDouble(askUserToInputField("Total Cost", ValidatorInput.IS_NOT_AN_EMPTY_STRING));
        int numberOfPeopleAllowed = Integer.parseInt(askUserToInputField("Number of People Allowed", ValidatorInput.IS_NOT_AN_EMPTY_STRING));
        String typeRent = askUserToInputField("Rent Type", ValidatorInput.IS_NOT_AN_EMPTY_STRING);
        int roomStar = Integer.parseInt(askUserToInputField("Room Star", ValidatorInput.IS_NOT_AN_EMPTY_STRING));
        int poolArea = Integer.parseInt(askUserToInputField("Pool Area", ValidatorInput.IS_NOT_AN_EMPTY_STRING));
        int numberOfFloor = Integer.parseInt(askUserToInputField("Number Of Floor", ValidatorInput.IS_NOT_AN_EMPTY_STRING));
        villaServices.add(new Villa(serviceID, serviceName, netArea, totalCost, numberOfPeopleAllowed, typeRent, roomStar,
            poolArea, numberOfFloor));

    }

    @Override
    public void display() {
        villaServices.displayList(VillaServiceImpl.villaList);
    }
}
