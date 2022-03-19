package case_study.furama_resort.controllers;

import static case_study.furama_resort.utils.ReadInputFromKeyBoard.inputValidData;

import case_study.furama_resort.models.Villa;
import case_study.furama_resort.services.IFacilityService;
import case_study.furama_resort.services.impl.VillaServiceImpl;
import case_study.furama_resort.utils.ValidatorInputLibrary;

public class VillaController {

    private final IFacilityService villaServices = VillaServiceImpl.getInstance();

    public void create() {
        String serviceID = inputValidData("Service ID (SVVL-YYYY)", ValidatorInputLibrary.VILLA_SERVICE_ID);
        String serviceName = inputValidData("Service Name", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
        double netArea = Double.parseDouble(
            inputValidData("Net Area", ValidatorInputLibrary.REAL_NUMBER_LARGER_THAN_30));
        double totalCost = Double.parseDouble(inputValidData("Total Cost", ValidatorInputLibrary.REAL_POSITIVE_NUMBER));
        int numberOfPeopleAllowed = Integer.parseInt(
            inputValidData("Number of People Allowed", ValidatorInputLibrary.PEOPLE_QUANTITY));
        String typeRent = inputValidData("Rent Type", ValidatorInputLibrary.AT_LEAST_ONE_CHARACTER);
        int roomStar = Integer.parseInt(inputValidData("Room Star", ValidatorInputLibrary.INTEGER_POSITIVE_NUMBER));
        int poolArea = Integer.parseInt(inputValidData("Pool Area", ValidatorInputLibrary.REAL_NUMBER_LARGER_THAN_30));
        int numberOfFloor = Integer.parseInt(
            inputValidData("Number Of Floor", ValidatorInputLibrary.INTEGER_POSITIVE_NUMBER));
        villaServices.add(new Villa(serviceID, serviceName, netArea, totalCost,
            numberOfPeopleAllowed, typeRent, roomStar, poolArea, numberOfFloor));
    }

    public void display() {
        villaServices.displayList();
    }
}
