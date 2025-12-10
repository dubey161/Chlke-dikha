package Exception;

public class ExceptionBasics {
    public static void main(String[] args) {
        System.out.println("Program Started");

        try {
            int a = 10 / 0; // risky code
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Program Ended");
    }
}
