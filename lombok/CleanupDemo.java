package lombok;

import lombok.Cleanup;

import java.io.FileInputStream;
import java.io.IOException;

public class CleanupDemo {

    public void readFile() throws IOException {

        @Cleanup
        FileInputStream fis = new FileInputStream("test.txt");

        int data;
        while ((data = fis.read()) != -1) {
            System.out.print((char) data);
        }
    }
}
