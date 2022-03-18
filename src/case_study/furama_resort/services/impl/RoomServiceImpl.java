package case_study.furama_resort.services.impl;

import case_study.furama_resort.models.Facility;
import case_study.furama_resort.services.IFacilityService;
import case_study.furama_resort.utils.ReadWriteCSVFile;
import java.util.ArrayList;
import java.util.List;

public class RoomServiceImpl implements IFacilityService {

    private static RoomServiceImpl instance;

    private RoomServiceImpl() {
    }

    public static RoomServiceImpl getInstance() {
        if (instance == null) {
            instance = new RoomServiceImpl();
        }
        return instance;
    }

    private static final String ROOM_FILE_PATH = "src/case_study/furama_resort/data/room.csv";
    public static List<Facility> roomList;

    static {
        roomList = new ArrayList<>();
        roomList = ReadWriteCSVFile.readRoomListFromCSVFile(ROOM_FILE_PATH);
    }

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
            System.out.println("!!!Room List not found.");
        }
    }

    @Override
    public void add(Facility newRoom) {
        roomList.add(newRoom);
        ReadWriteCSVFile.writeListToCSV(roomList, ROOM_FILE_PATH);
        System.out.println(newRoom);
        System.out.println("Add successfully!");
    }

    @Override
    public Facility getFacilityByID(String id) {
        for (Facility room : roomList) {
            if (room.getServiceID().equals(id)) {
                return room;
            }
        }
        return null;
    }
}
