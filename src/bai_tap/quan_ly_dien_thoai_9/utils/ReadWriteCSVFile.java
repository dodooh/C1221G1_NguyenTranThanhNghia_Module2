package bai_tap.quan_ly_dien_thoai_9.utils;

import bai_tap.quan_ly_dien_thoai_9.models.AuthenticPhone;
import bai_tap.quan_ly_dien_thoai_9.models.HandPhone;
import bai_tap.quan_ly_dien_thoai_9.models.Phone;
import bai_tap.quan_ly_dien_thoai_9.models.enums.Status;
import bai_tap.quan_ly_dien_thoai_9.models.enums.WarrantyRange;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteCSVFile {

    // ghi file voi dong dau tien la title
    public static void writeListToCSVFile(List<Phone> list, String filePath, String title) {
        File file = new File(filePath);
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(title);
            bufferedWriter.newLine();
            for (Phone s : list) {
                bufferedWriter.write(s.toCSVFormat());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Phone> readHandPhoneListFromCSVFile(String filePath) {
        List<String> stringList = readStringListFromCSVFile(filePath);
        if (stringList.size() == 0) {
            return new ArrayList<>();
        }
        List<Phone> result = new ArrayList<>();
        stringList.remove(0);
        for (String line : stringList) {
            String[] field = line.split(",");
            result.add(new HandPhone(
                Integer.parseInt(field[0]),
                field[1],
                Double.parseDouble(field[2]),
                Integer.parseInt(field[3]),
                field[4],
                field[5],
                Status.valueOf(field[6])
            ));
        }
        return result;
    }

    public static List<Phone> readAuthenticatePhoneListFromCSVFile(String filePath) {
        List<String> stringList = readStringListFromCSVFile(filePath);
        if (stringList.size() == 0) {
            return new ArrayList<>();
        }
        List<Phone> result = new ArrayList<>();
        stringList.remove(0);
        for (String line : stringList) {
            String[] field = line.split(",");
            result.add(new AuthenticPhone(
                Integer.parseInt(field[0]),
                field[1],
                Double.parseDouble(field[2]),
                Integer.parseInt(field[3]),
                field[4],
                Integer.parseInt(field[5]),
                WarrantyRange.valueOf(field[6])
            ));
        }
        return result;
    }


    private static List<String> readStringListFromCSVFile(String filePath) {
        List<String> stringList = new ArrayList<>();
        File file = new File(filePath);
        FileReader fileReader;
        BufferedReader bufferedReader;
        String line;
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
