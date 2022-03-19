package case_study.furama_resort.services.impl;

import case_study.furama_resort.models.Facility;
import case_study.furama_resort.services.IFacilityService;
import case_study.furama_resort.utils.ReadWriteCSVFile;
import java.util.ArrayList;
import java.util.List;

public class VillaServiceImpl implements IFacilityService {

    private static final String VILLA_FILE_PATH = "src/case_study/furama_resort/data/villa.csv";
    public static List<Facility> villaList;
    private static VillaServiceImpl instance;

    static {
        villaList = new ArrayList<>();
        villaList = ReadWriteCSVFile.readVillaListFromCSVFile(VILLA_FILE_PATH);
    }

    private VillaServiceImpl() {
    }

    public static VillaServiceImpl getInstance() {
        if (instance == null) {
            instance = new VillaServiceImpl();
        }
        return instance;
    }

    @Override
    public void displayList() {
        System.out.println("=======VILLA LIST=======");
        if (villaList != null && villaList.size() != 0) {
            int index = 0;
            for (Facility item : villaList) {
                System.out.printf("[%d] - %s", index++, item);
                System.out.println();
            }
        } else {
            System.out.println("!!!VILLA LIST IS EMPTY!!!");
        }
    }

    @Override
    public void add(Facility newVilla) {
        villaList.add(newVilla);
        ReadWriteCSVFile.writeListToCSVFile(villaList, VILLA_FILE_PATH);
        System.out.println(newVilla);
        System.out.println("✓Add successfully!");
    }

    @Override
    public Facility getFacilityByID(String id) {
        for (Facility villa : villaList) {
            if (villa.getServiceID().equals(id)) {
                return villa;
            }
        }
        return null;
    }
}
