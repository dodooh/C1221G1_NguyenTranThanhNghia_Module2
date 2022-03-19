package case_study.furama_resort.utils;

import case_study.furama_resort.models.Booking;
import case_study.furama_resort.models.CSVable;
import case_study.furama_resort.models.enums.CustomerType;
import case_study.furama_resort.models.enums.EmployeeLevel;
import case_study.furama_resort.models.enums.EmployeePosition;
import case_study.furama_resort.models.Facility;
import case_study.furama_resort.models.House;
import case_study.furama_resort.models.Room;
import case_study.furama_resort.models.Villa;
import case_study.furama_resort.models.Customer;
import case_study.furama_resort.models.Employee;
import case_study.furama_resort.models.Person;
import case_study.furama_resort.services.IFacilityService;
import case_study.furama_resort.services.impl.CustomerServiceImpl;
import case_study.furama_resort.services.impl.HouseServiceImpl;
import case_study.furama_resort.services.impl.RoomServiceImpl;
import case_study.furama_resort.services.impl.VillaServiceImpl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ReadWriteCSVFile {

    public static <T> void writeListToCSV(List<T> list, String filePath) {
        File file = new File(filePath);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (T s : list) {
                bufferedWriter.write(((CSVable) s).toCSVFormat());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> void writeSetToCSV(Set<T> set, String filePath) {
        File file = new File(filePath);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (T s : set) {
                bufferedWriter.write(((CSVable) s).toCSVFormat());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Set<Booking> readBookingSetFromCSVFile(String filePath) throws ParseException, ParseObjectException {
        Set<Booking> resultSet = new TreeSet<>();
        List<String> stringList = readStringListFromCSVFile(filePath);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        CustomerServiceImpl customerService = CustomerServiceImpl.getInstance();
        IFacilityService roomService = RoomServiceImpl.getInstance();
        IFacilityService houseService = HouseServiceImpl.getInstance();
        IFacilityService villaService = VillaServiceImpl.getInstance();
        for (String line : stringList) {
            String[] field = line.split(",");
            String bookingID = field[0];
            Date startDate = formatter.parse(field[1]);
            Date endDate = formatter.parse(field[2]);
            Customer customer;
            if (customerService.getCustomerByID(field[3]) != null) {
                customer = customerService.getCustomerByID(field[3]);
            } else {
                throw new ParseObjectException("!!!CANT FIND CUSTOMER WITH THIS ID!!!");
            }
            Facility facility;
            if (roomService.getFacilityByID(field[4]) != null) {
                facility = roomService.getFacilityByID(field[4]);
            } else if (houseService.getFacilityByID(field[4]) != null) {
                facility = houseService.getFacilityByID(field[4]);
            } else if (villaService.getFacilityByID(field[4]) != null) {
                facility = villaService.getFacilityByID(field[4]);
            } else {
                throw new ParseObjectException("!!!CANT FIND FACILITY WITH THIS ID!!!");
            }
            resultSet.add(new Booking(bookingID, startDate, endDate, customer, facility));
        }
        return resultSet;
    }

    public static List<Person> readCustomerListFromCSVFile(String filePath) {
        List<Person> resultList = new LinkedList<>();
        List<String> stringList = readStringListFromCSVFile(filePath);
        for (String line : stringList) {
            String[] field = line.split(",");
            String name = field[0];
            String dayOfBirth = field[1];
            boolean isMale = "true".equals(field[2]);
            String nationalID = field[3];
            String phoneNumber = field[4];
            String email = field[5];
            String customerID = field[6];
            CustomerType customerType = CustomerType.valueOf(field[7]);
            String address = field[8];
            resultList.add(new Customer(name,
                dayOfBirth,
                isMale,
                nationalID,
                phoneNumber,
                email,
                customerID,
                customerType,
                address));
        }
        return resultList;
    }

    public static List<Person> readEmployeeListFromCSVFile(String filePath) {
        List<Person> resultList = new LinkedList<>();
        List<String> stringList = readStringListFromCSVFile(filePath);
        for (String line : stringList) {
            String[] field = line.split(",");
            String name = field[0];
            String dayOfBirth = field[1];
            boolean isMale = "true".equals(field[2]);
            String nationalID = field[3];
            String phoneNumber = field[4];
            String email = field[5];
            String employeeID = field[6];
            EmployeeLevel level = EmployeeLevel.valueOf(field[7]);
            EmployeePosition position = EmployeePosition.valueOf(field[8]);
            double salary = Double.parseDouble(field[9]);
            resultList.add(new Employee(
                name,
                dayOfBirth,
                isMale,
                nationalID,
                phoneNumber,
                email,
                employeeID,
                level,
                position,
                salary));
        }
        return resultList;
    }

    public static List<Facility> readVillaListFromCSVFile(String filePath) {
        List<Facility> resultList = new ArrayList<>();
        List<String> stringList = readStringListFromCSVFile(filePath);
        for (String line : stringList) {
            String[] field = line.split(",");
            String serviceID = field[0];
            String serviceName = field[1];
            double netArea = Double.parseDouble(field[2]);
            double totalCost = Double.parseDouble(field[3]);
            int numberOfPeopleAllowed = Integer.parseInt(field[4]);
            String typeRent = field[5];
            int roomStar = Integer.parseInt(field[6]);
            double poolArea = Double.parseDouble(field[7]);
            int numberOfFloor = Integer.parseInt(field[8]);
            resultList.add(new Villa(serviceID, serviceName, netArea, totalCost, numberOfPeopleAllowed, typeRent, roomStar,
                poolArea, numberOfFloor));
        }
        return resultList;
    }

    public static List<Facility> readRoomListFromCSVFile(String filePath) {
        List<Facility> resultList = new ArrayList<>();
        List<String> stringList = readStringListFromCSVFile(filePath);
        for (String line : stringList) {
            String[] field = line.split(",");
            String serviceID = field[0];
            String serviceName = field[1];
            double netArea = Double.parseDouble(field[2]);
            double totalCost = Double.parseDouble(field[3]);
            int numberOfPeopleAllowed = Integer.parseInt(field[4]);
            String typeRent = field[5];
            String freeServices = field[6];
            resultList.add(new Room(
                serviceID,
                serviceName,
                netArea,
                totalCost,
                numberOfPeopleAllowed,
                typeRent,
                freeServices));
        }
        return resultList;
    }

    public static List<Facility> readHouseListFromCSVFile(String filePath) {
        List<Facility> resultList = new ArrayList<>();
        List<String> stringList = readStringListFromCSVFile(filePath);
        for (String line : stringList) {
            String[] field = line.split(",");
            String serviceID = field[0];
            String serviceName = field[1];
            double netArea = Double.parseDouble(field[2]);
            double totalCost = Double.parseDouble(field[3]);
            int numberOfPeopleAllowed = Integer.parseInt(field[4]);
            String typeRent = field[5];
            int roomStar = Integer.parseInt(field[6]);
            int numberOfFloor = Integer.parseInt(field[7]);
            resultList.add(new House(
                serviceID,
                serviceName,
                netArea,
                totalCost,
                numberOfPeopleAllowed,
                typeRent,
                roomStar,
                numberOfFloor));
        }
        return resultList;
    }

    // doc file csv -> string List
    private static List<String> readStringListFromCSVFile(String filePath) {

        List<String> stringList = new ArrayList<>();
        File file = new File(filePath);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("!!!FILE NOT FOUND!!!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }


}
