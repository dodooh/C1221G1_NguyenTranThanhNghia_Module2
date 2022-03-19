package case_study.furama_resort.controllers;

import static case_study.furama_resort.controllers.FuramaController.INVALID_INDEX_WARNING;
import static oop_review.quan_ly_phuong_tien.controllers.MainController.scanner;

import case_study.furama_resort.services.impl.FacilityMaintenanceServiceImpl;

public class FacilityController {

    private static FacilityController instance;
    private final FacilityMaintenanceServiceImpl facilityService = FacilityMaintenanceServiceImpl.getInstance();
    private final HouseController houseController = new HouseController();
    private final VillaController villaController = new VillaController();
    private final RoomController roomController = new RoomController();

    private FacilityController() {
    }

    public static FacilityController getInstance() {
        if (instance == null) {
            instance = new FacilityController();
        }
        return instance;
    }

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
                        System.out.println(INVALID_INDEX_WARNING);
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (flag);
    }

    public void display() {
        houseController.display();
        villaController.display();
        roomController.display();
    }

    public void showMaintenanceList() {
        facilityService.displayMaintenanceList();
    }
}
