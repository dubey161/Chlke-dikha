package Exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CheckedExceptionExample {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("abc.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found!");
        }
    }
}
