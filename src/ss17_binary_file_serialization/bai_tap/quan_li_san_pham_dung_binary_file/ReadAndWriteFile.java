package ss17_binary_file_serialization.bai_tap.quan_li_san_pham_dung_binary_file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {

    public static List<Product> readProductListFromFile(String filePath) {
        List<Product> productList = new ArrayList<>();
        File file = new File(filePath);
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            if (file.length() > 0) {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                productList = (List<Product>) ois.readObject();
                fis.close();
                ois.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public static void writeProductListToFile(String filePath, List<Product> productList) {
        File file = new File(filePath);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(productList);
            fos.close();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
