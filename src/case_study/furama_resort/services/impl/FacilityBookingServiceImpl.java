package case_study.furama_resort.services.impl;

import case_study.furama_resort.models.Facility;
import case_study.furama_resort.models.House;
import case_study.furama_resort.models.Room;
import case_study.furama_resort.models.Villa;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FacilityBookingServiceImpl {

    public static Map<Facility, Integer> usingFacility = new LinkedHashMap<>();

    static {
        usingFacility.put(new House("SVHO-1234", "House 1", 35.5,
            350, 10, "Theo Nam", 3, 3), 4);
        usingFacility.put(new House("SVHO-1235", "House 2", 40.5,
            400, 12, "Theo Nam", 3, 4), 5);
        usingFacility.put(new Villa("SVVL-1232", "Villa 1", 35.5,
            350, 10, "Theo Ngay", 3, 36, 10), 2);
        usingFacility.put(new Villa("SVVL-1234", "Villa 2", 35.5,
            700, 4, "Theo Ngay", 4, 40, 4), 5);
        usingFacility.put(new Room("SVRO-1445", "Room 1", 35.5,
            350, 10, "Theo Ngay", "Free Massage King"), 10);
        usingFacility.put(new Room("SVRO-1446", "Room 2", 35.5,
            350, 10, "Theo Ngay", "Free Massage Vip"), 20);
    }

    public void displayMaintenanceList() {
        Set<Facility> set = usingFacility.keySet();
        for (Facility key : set) {
            if (usingFacility.get(key) >= 5) {
                System.out.println(key + "So lan su dung: " + usingFacility.get(key));
            }
        }
    }

    public void add(Facility facility) {
        // Kiem tra Facility co trong Map chua
        // Neu co thi +1
        // Chua thi tao moi voi value = 1;
        System.out.println("Add successfully!");
    }
}
