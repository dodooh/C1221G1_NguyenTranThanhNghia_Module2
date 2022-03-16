package case_study.furama_resort.services.facility_services.impl;

import case_study.furama_resort.models.facitity_models.Facility;
import case_study.furama_resort.services.facility_services.IFacilityService;
import java.util.ArrayList;
import java.util.List;

public class RoomServiceImpl implements IFacilityService {

    public static List<Facility> roomList = new ArrayList<>();

    @Override
    public void displayList(List<Facility> list) {
        System.out.println("=======ROOM LIST=======");
        if (list != null && list.size() != 0) {
            int index = 0;
            for (Facility item : list) {
                System.out.printf("[%d] = %s", index++, item);
                System.out.println();
            }
        } else {
            System.out.println("Room List not found.");
        }
    }

    @Override
    public void add(Facility newRoom) {
        roomList.add(newRoom);

        System.out.println("Add successfully!");
    }
}
