package Exception;

import java.io.IOException;

public class ThrowsExample {

    static void show() throws IOException {
        throw new IOException("Device error");
    }

    public static void main(String[] args) {
        try {
            show();
        } catch (IOException e) {
            System.out.println("Handled: " + e.getMessage());
        }
    }
}
