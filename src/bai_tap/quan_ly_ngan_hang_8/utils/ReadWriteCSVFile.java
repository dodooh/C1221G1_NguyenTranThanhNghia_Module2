package bai_tap.quan_ly_ngan_hang_8.utils;


import static bai_tap.quan_ly_ngan_hang_8.utils.ValidatorInputLibrary.simpleDateFormat;

import bai_tap.quan_ly_ngan_hang_8.models.Account;
import bai_tap.quan_ly_ngan_hang_8.models.SavingAccount;
import bai_tap.quan_ly_ngan_hang_8.models.SpendingAccount;
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
    public static void writeListToCSVFile(List<Account> list, String filePath, String title) {
        File file = new File(filePath);
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(title);
            bufferedWriter.newLine();
            for (Account s : list) {
                bufferedWriter.write(s.toCSVFormat());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Account> readAccountListFromCSVFile(String filePath) throws ParseException, ParseObjectException {
        List<String> stringList = readStringListFromCSVFile(filePath);
        if (stringList.size() == 0) {
            return new ArrayList<>();
        }
        List<Account> result = new ArrayList<>();
        stringList.remove(0);
        for (String line : stringList) {
            String[] field = line.split(",");
            if (field.length == 6) {
                result.add(new SpendingAccount(
                    Integer.parseInt(field[0]),
                    field[1],
                    field[2],
                    simpleDateFormat.parse(field[3]),
                    field[4],
                    Double.parseDouble(field[5])));
            } else if (field.length == 8) {
                result.add(
                    new SavingAccount(
                        Integer.parseInt(field[0]),
                        field[1],
                        field[2],
                        simpleDateFormat.parse(field[3]),
                        Double.parseDouble(field[4]),
                        simpleDateFormat.parse(field[5]),
                        Double.parseDouble(field[6]),
                        Integer.parseInt(field[7])
                    ));
            } else {
                throw new ParseObjectException("!!!Can not find any type of account with this information!!!");
            }
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
