package case_study.furama_resort.services.facility_services.impl;

import case_study.furama_resort.models.facitity_models.Facility;
import case_study.furama_resort.services.facility_services.IFacilityService;
import java.util.ArrayList;
import java.util.List;

public class HouseServiceImpl implements IFacilityService {

    private static final String HOUSE_FILE_PATH = "src/case_study/furama_resort/data/house.csv";
    public static List<Facility> houseList = new ArrayList<>();

    static {
        //ReadWriteCSVFile.writeListToCSV(houseList, HOUSE_FILE_PATH);

    }


    @Override
    public void displayList(List<Facility> list) {
        System.out.println("=======HOUSE LIST=======");
        if (list != null && list.size() != 0) {
            int index = 0;
            for (Facility item : list) {
                System.out.printf("[%d] = %s", index++, item);
                System.out.println();
            }
        } else {
            System.out.println("!!!House List not found.");
        }
    }

    @Override
    public void add(Facility newHouse) {
        houseList.add(newHouse);
        System.out.println("Add successfully!");
    }
}
