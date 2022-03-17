package case_study.furama_resort.controllers.facility_controllers.impl;

import static case_study.furama_resort.utils.ReadInputFromKeyBoard.askUserToInputValidData;

import case_study.furama_resort.controllers.facility_controllers.IFacilityController;
import case_study.furama_resort.models.facitity_models.Villa;
import case_study.furama_resort.services.facility_services.IFacilityService;
import case_study.furama_resort.services.facility_services.impl.VillaServiceImpl;
import case_study.furama_resort.utils.ValidatorInputLibrary;

public class VillaControllerImpl implements IFacilityController {

    IFacilityService villaServices = new VillaServiceImpl();

    @Override
    public void create() {
        String serviceID = askUserToInputValidData("Service ID", ValidatorInputLibrary.VILLA_SERVICE_ID);
        String serviceName = askUserToInputValidData("Service Name", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
        double netArea = Double.parseDouble(askUserToInputValidData("Net Area", ValidatorInputLibrary.REAL_NUMBER_LARGER_THAN_30));
        double totalCost = Double.parseDouble(askUserToInputValidData("Total Cost", ValidatorInputLibrary.REAL_POSITIVE_NUMBER));
        int numberOfPeopleAllowed = Integer.parseInt(askUserToInputValidData("Number of People Allowed", ValidatorInputLibrary.PEOPLE_QUANTITY));
        String typeRent = askUserToInputValidData("Rent Type", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
        int roomStar = Integer.parseInt(askUserToInputValidData("Room Star", ValidatorInputLibrary.INTEGER_POSITIVE_NUMBER));
        int poolArea = Integer.parseInt(askUserToInputValidData("Pool Area", ValidatorInputLibrary.REAL_NUMBER_LARGER_THAN_30));
        int numberOfFloor = Integer.parseInt(askUserToInputValidData("Number Of Floor", ValidatorInputLibrary.INTEGER_POSITIVE_NUMBER));
        villaServices.add(new Villa(serviceID, serviceName, netArea, totalCost, numberOfPeopleAllowed, typeRent, roomStar,
            poolArea, numberOfFloor));
    }

    @Override
    public void display() {
        villaServices.displayList(VillaServiceImpl.villaList);
    }
}
