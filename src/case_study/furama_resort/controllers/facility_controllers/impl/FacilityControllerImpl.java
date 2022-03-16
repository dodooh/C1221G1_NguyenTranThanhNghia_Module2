package case_study.furama_resort.controllers.facility_controllers.impl;

import static oop_review.quan_ly_phuong_tien.controllers.MainController.scanner;

public class FacilityControllerImpl {

    protected String getServiceIDFromInput(/*Validator validator*/) {
        String serviceID;
        do {
            System.out.print("Enter Service ID: ");
            serviceID = scanner.nextLine();
            if (false) { // Validator
                System.err.println("Service ID is invalid. Retry!");
            } else {
                break;
            }
        } while (true);
        return serviceID;
    }

    protected String getServiceNameFromInput() {
        String serviceName;
        do {
            System.out.print("Enter Service Name: ");
            serviceName = scanner.nextLine();
            if (false) { // Validator
                System.err.println("Service Name is invalid. Retry!");
            } else {
                break;
            }
        } while (true);
        return serviceName;
    }

    protected int getNetAreaFromInput() {
        String netArea;
        do {
            System.out.print("Enter Net Area: ");
            netArea = scanner.nextLine();
            if (false) { // Validator
                System.err.println("Net Area is invalid. Retry!");
            } else {
                break;
            }
        } while (true);
        return Integer.parseInt(netArea);
    }

    protected int getNumberOfPeopleAllowedFromInput() {
        String numberOfPeopleAllowed;
        do {
            System.out.print("Enter Number of People Allowed: ");
            numberOfPeopleAllowed = scanner.nextLine();
            if (false) { // Validator
                System.err.println("Number of People Allowed is invalid. Retry!");
            } else {
                break;
            }
        } while (true);
        return Integer.parseInt(numberOfPeopleAllowed);
    }

    protected double getTotalCostFromInput() {
        String totalCost;
        do {
            System.out.print("Enter Total Cost: ");
            totalCost = scanner.nextLine();
            if (false) { // Validator
                System.err.println("Total Cost is invalid. Retry!");
            } else {
                break;
            }
        } while (true);
        return Double.parseDouble(totalCost);
    }

    protected String getTypeRentFromInput() {
        String typeRent;
        do {
            System.out.print("Enter Type Of Rent(Year/Month/Day): ");
            typeRent = scanner.nextLine();
            if (false) { // Validator
                System.err.println("Type Of Rent is invalid. Retry!");
            } else {
                break;
            }
        } while (true);
        return typeRent;
    }


}
