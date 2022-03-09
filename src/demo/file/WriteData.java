package demo.file;

import java.io.IOException;

public class WriteData {

    public static void main(String[] args) throws IOException {
        java.io.File file = new java.io.File("src/demo/file/text.txt");
        if (file.exists()) {
            System.out.println("File already exists");
            System.exit(1);
        }
        java.io.PrintWriter output = new java.io.PrintWriter(file);

        // Write formatted output to the file
        output.print("John T Smith ");
        output.println(90);
        output.print("Eric K Jones ");
        output.println(85);

        // Close the file
        output.close();
    }
}