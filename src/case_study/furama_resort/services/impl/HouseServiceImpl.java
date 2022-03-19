package case_study.furama_resort.services.impl;

import case_study.furama_resort.models.Customer;
import case_study.furama_resort.models.Facility;
import case_study.furama_resort.models.House;
import case_study.furama_resort.models.Person;
import case_study.furama_resort.services.IFacilityService;
import case_study.furama_resort.utils.ReadWriteCSVFile;
import java.util.ArrayList;
import java.util.List;

public class HouseServiceImpl implements IFacilityService {

    private static final String HOUSE_FILE_PATH = "src/case_study/furama_resort/data/house.csv";
    public static List<Facility> houseList = new ArrayList<>();
    private static HouseServiceImpl instance;

    static {
        houseList = ReadWriteCSVFile.readHouseListFromCSVFile(HOUSE_FILE_PATH);
    }

    private HouseServiceImpl() {
    }

    public static HouseServiceImpl getInstance() {
        if (instance == null) {
            instance = new HouseServiceImpl();
        }
        return instance;
    }

    @Override
    public void displayList() {
        System.out.println("=======HOUSE LIST=======");
        if (houseList != null && houseList.size() != 0) {
            int index = 0;
            for (Facility item : houseList) {
                System.out.printf("[%d] = %s", index++, item);
                System.out.println();
            }
        } else {
            System.out.println("!!!HOUSE LIST IS EMPTY!!!");
        }
    }

    @Override
    public void add(Facility newHouse) {
        houseList.add(newHouse);
        ReadWriteCSVFile.writeListToCSV(houseList, HOUSE_FILE_PATH);
        System.out.println(newHouse);
        System.out.println("Add successfully!");
    }

    @Override
    public Facility getFacilityByID(String id) {
        for (Facility house : houseList) {
            if (house.getServiceID().equals(id)) {
                return house;
            }
        }
        return null;
    }
}
