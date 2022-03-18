package case_study.furama_resort.controllers.impl;

import static oop_review.quan_ly_phuong_tien.controllers.MainController.scanner;

import case_study.furama_resort.controllers.IFacilityController;
import case_study.furama_resort.services.impl.FacilityBookingServiceImpl;

public class FacilityControllerImpl implements IFacilityController {

    FacilityBookingServiceImpl facilityService = new FacilityBookingServiceImpl();
    IFacilityController houseController = new HouseControllerImpl();
    IFacilityController villaController = new VillaControllerImpl();
    IFacilityController roomController = new RoomControllerImpl();

    private static FacilityControllerImpl instance;

    private FacilityControllerImpl() {
    }

    public static FacilityControllerImpl getInstance() {
        if (instance == null) {
            instance = new FacilityControllerImpl();
        }
        return instance;
    }

    @Override
    public void create() {
        boolean flag = true;
        int chooseMenu;
        do {
            System.out.println("===========Add New Facility===========\n" +
                "1. Add New Villa\n"
                + "2. Add New House\n"
                + "3. Add New Room\n"
                + "0. Back to menu");
            try {
                chooseMenu = Integer.parseInt(scanner.nextLine());
                switch (chooseMenu) {
                    case 1:
                        villaController.create();
                        break;
                    case 2:
                        houseController.create();
                        break;
                    case 3:
                        roomController.create();
                        break;
                    case 0:
                        System.out.println("Back To Main Menu");
                        flag = false;
                        break;
                    default:
                        System.out.println("Please Enter Exactly Number!!!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (flag);
    }

    @Override
    public void display() {
        houseController.display();
        villaController.display();
        roomController.display();
    }

    public void showMaintenanceList() {
        facilityService.displayMaintenanceList();
    }
}
