package case_study.furama_resort.controllers.facility_controllers.impl;

import static oop_review.quan_ly_phuong_tien.controllers.MainController.scanner;

import case_study.furama_resort.controllers.facility_controllers.IFacilityController;
import case_study.furama_resort.services.facility_services.IFacilityService;
import case_study.furama_resort.services.facility_services.impl.FacilityServiceImpl;

public class FacilityControllerImpl implements IFacilityController{
    FacilityServiceImpl facilityService = new FacilityServiceImpl();
    IFacilityController houseController = new HouseControllerImpl();
    IFacilityController villaController = new VillaControllerImpl();
    IFacilityController roomController = new RoomControllerImpl();


    @Override
    public void create() {
        boolean flag = true;
        do {
            System.out.println("===========Add New Facility===========\n" +
                "1. Add New Villa\n"
                + "2. Add New House\n"
                + "3. Add New Room\n"
                + "4. Back to menu");
            System.out.print("Choose a function: ");
            int chooseMenu = Integer.parseInt(scanner.nextLine());
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
                default:
                    flag = false;
            }
        } while (flag);
    }

    @Override
    public void display() {
        houseController.display();
        villaController.display();
        roomController.display();
    }

    public void showMantainanceList() {
    }
}
