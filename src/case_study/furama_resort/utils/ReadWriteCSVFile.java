package case_study.furama_resort.utils;

import static case_study.furama_resort.utils.ReadInputFromKeyBoard.askUserToInputValidData;

import case_study.furama_resort.models.CSVable;
import case_study.furama_resort.models.enums.CustomerType;
import case_study.furama_resort.models.enums.EmployeeLevel;
import case_study.furama_resort.models.enums.EmployeePosition;
import case_study.furama_resort.models.people_models.Customer;
import case_study.furama_resort.models.people_models.Employee;
import case_study.furama_resort.models.people_models.Person;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import oop_review.quan_ly_phuong_tien.models.HangSanXuat;
import oop_review.quan_ly_phuong_tien.models.Oto;
import oop_review.quan_ly_phuong_tien.services.impl.HangSanXuatServiceImpl;

public class ReadWriteCSVFile {

    public static <T> void writeListToCSV(List<T> list, String filePath) {
        File file = new File(filePath);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file); // true ghi tiếp; false (mặc đinh): nghi đè
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

    public static List<Person> readCustomerListFromCSVFile(String filePath) {
        List<Person> resultList = new ArrayList<>();
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
        List<Person> resultList = new ArrayList<>();
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
            System.err.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }


}
