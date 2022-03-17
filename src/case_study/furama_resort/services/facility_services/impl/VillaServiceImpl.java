package case_study.furama_resort.services.facility_services.impl;

import case_study.furama_resort.models.facitity_models.Facility;
import case_study.furama_resort.services.facility_services.IFacilityService;
import java.util.ArrayList;
import java.util.List;

public class VillaServiceImpl implements IFacilityService {

    private static final String VILLA_FILE_PATH = "src/case_study/furama_resort/data/villa.csv";
    public static List<Facility> villaList = new ArrayList<>();

    static {
        //ReadWriteCSVFile.writeListToCSV(villaList, VILLA_FILE_PATH);

    }


    @Override
    public void displayList(List<Facility> list) {
        System.out.println("=======VILLA LIST=======");
        if (list != null && list.size() != 0) {
            int index = 0;
            for (Facility item : list) {
                System.out.printf("[%d] = %s", index++, item);
                System.out.println();
            }
        } else {
            System.out.println("!!!Villa List not found.");
        }
    }

    @Override
    public void add(Facility newVilla) {
        villaList.add(newVilla);
        System.out.println("Add successfully!");
    }
}
