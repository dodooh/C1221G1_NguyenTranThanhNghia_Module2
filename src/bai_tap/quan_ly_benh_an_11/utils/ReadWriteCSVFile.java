package bai_tap.quan_ly_benh_an_11.utils;

import static bai_tap.quan_ly_benh_an_11.utils.ValidatorInputLibrary.simpleDateFormat;

import bai_tap.quan_ly_benh_an_11.models.NormalPatient;
import bai_tap.quan_ly_benh_an_11.models.Patient;
import bai_tap.quan_ly_benh_an_11.models.VIPPatient;
import bai_tap.quan_ly_benh_an_11.models.enums.VIPType;
import bai_tap.quan_ly_dien_thoai_9.models.AuthenticPhone;
import bai_tap.quan_ly_dien_thoai_9.models.enums.WarrantyRange;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteCSVFile {

    // ghi file voi dong dau tien la title
    public static void writeListToCSVFile(List<Patient> list, String filePath, String title) {
        File file = new File(filePath);
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(title);
            bufferedWriter.newLine();
            for (int i = 0; i < list.size(); i++) {
                Patient s = list.get(i);
                bufferedWriter.write(s.toCSVFormat());
                if (i != list.size() - 1) {
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Patient> readNormalPatientListFromCSVFile(String filePath) throws ParseException {
        List<String> stringList = readStringListFromCSVFile(filePath);
        if (stringList.size() == 0) {
            return new ArrayList<>();
        }
        List<Patient> result = new ArrayList<>();
        stringList.remove(0);
        for (String line : stringList) {
            String[] field = line.split(",");
            result.add(
                new NormalPatient(
                    Integer.parseInt(field[0]),
                    field[1],
                    field[2],
                    field[3],
                    simpleDateFormat.parse(field[4]),
                    simpleDateFormat.parse(field[5]),
                    field[6],
                    Double.parseDouble(field[7])
                )
            );
        }
        return result;
    }

    public static List<Patient> readVIPPatientListFromCSVFile(String filePath) throws ParseException {
        List<String> stringList = readStringListFromCSVFile(filePath);
        if (stringList.size() == 0) {
            return new ArrayList<>();
        }
        List<Patient> result = new ArrayList<>();
        stringList.remove(0);
        for (String line : stringList) {
            String[] field = line.split(",");
            result.add(
                new VIPPatient(
                    Integer.parseInt(field[0]),
                    field[1],
                    field[2],
                    field[3],
                    simpleDateFormat.parse(field[4]),
                    simpleDateFormat.parse(field[5]),
                    field[6],
                    VIPType.valueOf(field[7]),
                    simpleDateFormat.parse(field[8])

                )
            );
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
