package case_study.furama_resort.services.impl;

import static case_study.furama_resort.utils.ReadWriteCSVFile.readFacilityMapFromCSVFile;
import static case_study.furama_resort.utils.ReadWriteCSVFile.writeFacilityMapToCSVFile;

import case_study.furama_resort.models.Facility;
import case_study.furama_resort.utils.ParseObjectException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FacilityMaintenanceServiceImpl {

    private static final String FACILITY_MAINTENANCE_FILE_PATH = "src/case_study/furama_resort/data/facilityMaintenance.csv";
    public static Map<Facility, Integer> usingFacility = new LinkedHashMap<>();
    private static FacilityMaintenanceServiceImpl instance;

    static {
        try {
            usingFacility = readFacilityMapFromCSVFile(FACILITY_MAINTENANCE_FILE_PATH);
        } catch (ParseObjectException e) {
            e.printStackTrace();
        }
    }

    private FacilityMaintenanceServiceImpl() {
    }

    public static FacilityMaintenanceServiceImpl getInstance() {
        if (instance == null) {
            instance = new FacilityMaintenanceServiceImpl();
        }
        return instance;
    }

    public void displayMaintenanceList() {
        Set<Facility> set = usingFacility.keySet();
        for (Facility key : set) {
            if (usingFacility.get(key) >= 5) {
                System.out.println(key + "Using Time: " + usingFacility.get(key));
            }
        }
    }

    public void add(Facility facility) {
        if (usingFacility.containsKey(facility)) {
            usingFacility.replace(facility, usingFacility.get(facility) + 1);
        } else {
            usingFacility.put(facility, 1);
        }
        writeFacilityMapToCSVFile(usingFacility, FACILITY_MAINTENANCE_FILE_PATH);
    }
}
