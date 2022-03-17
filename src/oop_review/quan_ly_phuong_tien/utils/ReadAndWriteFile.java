package oop_review.quan_ly_phuong_tien.utils;

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
import oop_review.quan_ly_phuong_tien.models.PhuongTien;
import oop_review.quan_ly_phuong_tien.models.XeMay;
import oop_review.quan_ly_phuong_tien.models.XeTai;
import oop_review.quan_ly_phuong_tien.services.impl.HangSanXuatServiceImpl;

public class ReadAndWriteFile {

    public static void writePhuongTienListToCSV(List<PhuongTien> list, String filePath, Boolean append) {
        File file = new File(filePath);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append); // true ghi tiếp; false (mặc đinh): nghi đè
            bufferedWriter = new BufferedWriter(fileWriter);
            for (PhuongTien s : list) {
                bufferedWriter.write(s.getCSVFormat());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<PhuongTien> readOtoListFromFile(String filePath) {
        List<PhuongTien> resultList = new ArrayList<>();
        List<String> stringList = readStringListFromFile(filePath);
        for (String line : stringList) {
            String[] field = line.split(",");
            String bienKiemSoat = field[0];
            HangSanXuat hangSanXuat = HangSanXuatServiceImpl.findByName(field[1]);
            int namSanXuat = Integer.parseInt(field[2]);
            String chuSoHuu = field[3];
            int soChoNgoi = Integer.parseInt(field[4]);
            Oto.KieuXe kieuXe = Oto.KieuXe.valueOf(field[5]);
            resultList.add(new Oto(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu, soChoNgoi, kieuXe));
        }
        return resultList;
    }

    public static List<PhuongTien> readXeMayListFromFile(String filePath) {
        List<PhuongTien> resultList = new ArrayList<>();
        List<String> stringList = readStringListFromFile(filePath);
        for (String line : stringList) {
            String[] field = line.split(",");
            String bienKiemSoat = field[0];
            HangSanXuat hangSanXuat = HangSanXuatServiceImpl.findByName(field[1]);
            int namSanXuat = Integer.parseInt(field[2]);
            String chuSoHuu = field[3];
            int congSuat = Integer.parseInt(field[4]);
            resultList.add(new XeMay(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu, congSuat));
        }
        return resultList;
    }

    public static List<PhuongTien> readXeTaiListFromFile(String filePath) {
        List<PhuongTien> resultList = new ArrayList<>();
        List<String> stringList = readStringListFromFile(filePath);
        for (String line : stringList) {
            String[] field = line.split(",");
            String bienKiemSoat = field[0];
            HangSanXuat hangSanXuat = HangSanXuatServiceImpl.findByName(field[1]);
            int namSanXuat = Integer.parseInt(field[2]);
            String chuSoHuu = field[3];
            int taiTrong = Integer.parseInt(field[4]);
            resultList.add(new XeTai(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu, taiTrong));
        }
        return resultList;
    }

    public static List<HangSanXuat> readHangSanXuatListFromFile(String filePath) {
        List<HangSanXuat> resultList = new ArrayList<>();
        List<String> stringList = readStringListFromFile(filePath);
        for (String line : stringList) {
            String[] field = line.split(",");
            String maHangSanXuat = field[0];
            String tenHangSanXuat = field[1];
            String tenQuocGia = field[2];
            resultList.add(new HangSanXuat(maHangSanXuat, tenHangSanXuat, tenQuocGia));
        }
        return resultList;
    }

    private static List<String> readStringListFromFile(String filePath) {
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
