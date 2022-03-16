package case_study.furama_resort.services.facility_services.impl;

import case_study.furama_resort.models.facitity_models.Facility;
import case_study.furama_resort.services.facility_services.IFacilityService;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FacilityServiceImpl implements IFacilityService {

    public static Map<Facility, Integer> facilityData = new LinkedHashMap<>();

    List<Facility> facilityList = new ArrayList<>();


    @Override
    public void add(Facility facility) {
        facilityData.put(facility,0);
        System.out.println("Add successfully!");
    }
}
