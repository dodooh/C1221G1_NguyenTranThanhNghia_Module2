package ss16_text_file.bai_tap.doc_file_csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFileCSV {

    private static String FILEPATH = "src/ss16_text_file/bai_tap/doc_file_csv/data.csv";

    public static void main(String[] args) {
        List<Nation> nationList = getNationListFromFile(FILEPATH);
        for (Nation nation  : nationList) {
            System.out.println(nation);
        }

    }

    private static List<Nation> getNationListFromFile(String filePath) {
        List<Nation> nationList = new ArrayList<>();
        File file = new File(filePath);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                nationList.add(getNationFromLine(line));
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nationList;
    }

    private static Nation getNationFromLine(String line) {
        String[] properties = line.replaceAll("\"","").split(",");
        return new Nation(Integer.parseInt(properties[0]), properties[1], properties[2]);
    }
}
