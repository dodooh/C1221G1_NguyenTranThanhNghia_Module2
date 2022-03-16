package case_study.furama_resort.controllers.facility_controllers.impl;

import static oop_review.quan_ly_phuong_tien.controllers.MainController.scanner;

public class VillaControllerImpl {
    protected int getRoomStarFromInput() {
        String netArea;
        do {
            System.out.print("Enter Room Star: ");
            netArea = scanner.nextLine();
            if (false) { // Validator
                System.err.println("Room Star is invalid. Retry!");
            } else {
                break;
            }
        } while (true);
        return Integer.parseInt(netArea);
    }

    protected int getPoolAreaFromInput() {
        String netArea;
        do {
            System.out.print("Enter Room Star: ");
            netArea = scanner.nextLine();
            if (false) { // Validator
                System.err.println("Room Star is invalid. Retry!");
            } else {
                break;
            }
        } while (true);
        return Integer.parseInt(netArea);
    }
}
