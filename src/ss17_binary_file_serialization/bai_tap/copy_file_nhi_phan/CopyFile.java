package ss17_binary_file_serialization.bai_tap.copy_file_nhi_phan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class CopyFile {

    public static void main(String[] args) {
        String sourceFilePath = "src/ss17_binary_file_serialization/bai_tap/copy_file_nhi_phan/source.txt";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter destFileName: ");
        String destFileName = scanner.nextLine();
        String destFilePath = "src/ss17_binary_file_serialization/bai_tap/copy_file_nhi_phan/" + destFileName;
        File sourceFile = new File(sourceFilePath);
        File destFile = new File(destFilePath);

        try {
            copyFileUsingStream(sourceFile, destFile);
            System.out.print("Copy completed");
        } catch (IOException ioe) {
            System.out.print("Can't copy that file");
            System.out.print(ioe.getMessage());
        }
    }

    private static void copyFileUsingStream(File source, File dest) throws IOException {
//        try-with-resource
        try (
            InputStream is = new FileInputStream(source);
            OutputStream os = new FileOutputStream(dest);
        ) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);

            }
        }
    }
}
