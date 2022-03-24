package demo.file;

import java.io.CharArrayReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadData {

    public static void main(String[] args) throws Exception {
//        // Create a File instance
//        java.io.File file = new java.io.File("src/demo/file/text.txt");
//        // Create a Scanner for the file
//        Scanner input.txt = new Scanner(file);
//        // Read data from a file
//        while (input.txt.hasNext()) {
//            String firstName = input.txt.next();
//            String mi = input.txt.next();
//            String lastName = input.txt.next();
//            int score = input.txt.nextInt();
//            System.out.println(firstName + " " + mi + " " + lastName + " " + score);
//        }
//        // Close the file
//        input.txt.close();
        String obj = "abcdefgh";
        int length = obj.length();
        char c[] = new char[length];
        obj.getChars(0, length, c, 0);
        CharArrayReader input1 = new CharArrayReader(c);
        CharArrayReader input2 = new CharArrayReader(c, 1, 4);
        int i;
        int j;
        try {
            while ((i = input1.read()) == (j = input2.read())) {
                System.out.print((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
