package bai_tap.final_module_2.utils;

import static bai_tap.final_module_2.utils.ValidatorInputLibrary.simpleDateFormat;

//import bai_tap.quan_ly_benh_an_11.models.NormalPatient;
//import bai_tap.quan_ly_benh_an_11.models.Patient;
//import bai_tap.quan_ly_benh_an_11.models.VIPPatient;
//import bai_tap.quan_ly_benh_an_11.models.enums.VIPType;
import bai_tap.final_module_2.models.Person;
import bai_tap.final_module_2.models.Student;
import bai_tap.final_module_2.models.Class;
import bai_tap.final_module_2.models.Teacher;
import bai_tap.final_module_2.models.enums.Gender;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReadWriteCSVFile {

    // ghi file voi dong dau tien la title
    public static void writeListToCSVFile(List<Person> list, String filePath) {
        File file = new File(filePath);
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (int i = 0; i < list.size(); i++) {
                Person s = list.get(i);
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

    public static List<Class> readClassListFromCSVFile(String filePath) {
        List<String> stringList = readStringListFromCSVFile(filePath);
        if (stringList.size() == 0) {
            return new ArrayList<>();
        }
        List<Class> result = new ArrayList<>();
        for (String line : stringList) {
            String[] field = line.split(",");
            result.add(
                new Class(
                    field[0],
                    field[1],
                    field[2]
                )
            );
        }
        return result;
    }

    public static List<Person> readStudentListFromCSVFile(String filePath) throws ParseException {
        List<String> stringList = readStringListFromCSVFile(filePath);
        if (stringList.size() == 0) {
            return new ArrayList<>();
        }
        List<Person> result = new ArrayList<>();
        for (String line : stringList) {
            String[] field = line.split(",");
            int studentID = Integer.parseInt(field[0]);
            String name = field[1];
            Date date = simpleDateFormat.parse(field[2]);
            Gender gender = Gender.valueOf(field[3]);
            String phoneNumber = field[4];
            String classID = field[5];
            result.add(
                new Student(
                    name,
                    date,
                    gender,
                    phoneNumber,
                    studentID,
                    classID
                )
            );
        }
        return result;
    }

    public static List<Person> readTeacherListFromCSVFile(String filePath) throws ParseException {
        List<String> stringList = readStringListFromCSVFile(filePath);
        if (stringList.size() == 0) {
            return new ArrayList<>();
        }
        List<Person> result = new ArrayList<>();
        for (String line : stringList) {
            String[] field = line.split(",");
            int teacherID = Integer.parseInt(field[0]);
            String name = field[1];
            Date date = simpleDateFormat.parse(field[2]);
            Gender gender = Gender.valueOf(field[3]);
            String phoneNumber = field[4];
            result.add(
                new Teacher(
                    name,
                    date,
                    gender,
                    phoneNumber,
                    teacherID
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
