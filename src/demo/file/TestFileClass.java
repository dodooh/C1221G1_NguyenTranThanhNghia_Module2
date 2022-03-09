package demo.file;

import java.io.FileNotFoundException;

public class TestFileClass {

    public static void main(String[] args) throws FileNotFoundException {
//        java.io.File file = new java.io.File("src/demo/file/text.txt");
//        System.out.println("Does it exist? " + file.exists());
//        System.out.println("The file has " + file.length() + " bytes");
//        System.out.println("Can it be read? " + file.canRead());
//        System.out.println("Can it be written? " + file.canWrite());
//        System.out.println("Is it a directory? " + file.isDirectory());
//        System.out.println("Is it a file? " + file.isFile());
//        System.out.println("Is it absolute? " + file.isAbsolute());
//        System.out.println("Is it hidden? " + file.isHidden());
//        System.out.println("Absolute path is " +
//            file.getAbsolutePath());
//        System.out.println("Last modified on " +
//            new java.util.Date(file.lastModified()));
        java.io.PrintWriter output = new
            java.io.PrintWriter("src/demo/file/text.txt");
        output.printf("amount is %f %e\r\n", 32.32, 32.32);
        output.printf("amount is %5.4f %5.4e\r\n", 32.32, 32.32);
        output.printf("%6b\r\n", (1 > 2));
        output.printf("%6s\r\n", "Java");
        output.close();
    }
}
