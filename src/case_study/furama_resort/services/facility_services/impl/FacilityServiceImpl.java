package case_study.furama_resort.services.facility_services.impl;

import case_study.furama_resort.models.facitity_models.Facility;
import case_study.furama_resort.services.facility_services.IFacilityService;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FacilityServiceImpl  {

    public static Map<Facility, Integer> usedFacility = new LinkedHashMap<>();


    public void add(Facility facility) {
        // Kiem tra Facility co trong Map chua
        // Neu co thi +1
        // Chua thi tao moi voi value = 1;
        System.out.println("Add successfully!");
    }
}
