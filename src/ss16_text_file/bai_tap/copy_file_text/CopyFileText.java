package ss16_text_file.bai_tap.copy_file_text;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CopyFileText {

    private static final String INPUT_PATH = "src/ss16_text_file/bai_tap/copy_file_text/input.txt";
    private static final String OUTPUT_PATH = "src/ss16_text_file/bai_tap/copy_file_text/output.txt";

    public static void main(String[] args) {
        // Đọc file lấy từng dòng đưa vào List
        List<String> inputString = readStringFromFile(INPUT_PATH);
        // Từ List gom thành 1 chuối String phân chia bởi dấu xuông dòng
        String collected = getStringLineByLineFromStringList(inputString);
        // Hiển thị
        System.out.println("\"" + collected + "\"");
        System.out.println("Số kí tự trong chuỗi là : " + collected.length());
        System.out.println("Writing to file...");
        // Ghi ra file, lấy nội dung từ List<String>
        writeStringToFile(OUTPUT_PATH, inputString);
        System.out.println("Finish write to file");

    }

    private static List<String> readStringFromFile(String filePath) {
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

    private static void writeStringToFile(String filePath, List<String> outputStringList) {
        File file = new File(filePath);
        if (file.exists()) {
            System.err.println("File is already exist!");
            return;
        }
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {

            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(getStringLineByLineFromStringList(outputStringList));
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getStringLineByLineFromStringList(List<String> stringList) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < stringList.size(); i++) {
            result.append(stringList.get(i));
            if (i != stringList.size() - 1) { // KHÔNG có dấu xuống dòng ở dòng cuối cùng
                result.append("\n");
            }
        }
        return result.toString();
    }
}
