package case_study.furama_resort.services.impl;

import case_study.furama_resort.models.Facility;
import case_study.furama_resort.services.IFacilityService;
import case_study.furama_resort.utils.ReadWriteCSVFile;
import java.util.ArrayList;
import java.util.List;

public class VillaServiceImpl implements IFacilityService {
    private static VillaServiceImpl instance;
    private VillaServiceImpl() {
    }
    public static VillaServiceImpl getInstance() {
        if (instance == null) {
            instance = new VillaServiceImpl();
        }
        return instance;
    }
    private static final String VILLA_FILE_PATH = "src/case_study/furama_resort/data/villa.csv";
    public static List<Facility> villaList;

    static {
        villaList = new ArrayList<>();
        villaList = ReadWriteCSVFile.readVillaListFromCSVFile(VILLA_FILE_PATH);
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
        ReadWriteCSVFile.writeListToCSV(villaList, VILLA_FILE_PATH);
        System.out.println(newVilla);
        System.out.println("Add successfully!");
    }
    @Override
    public Facility getFacilityByID(String id) {
        for (Facility villa: villaList) {
            if (villa.getServiceID().equals(id)) {
                return villa;
            }
        }
        return null;
    }
}
