package Exception;

public class FinallyExample {
    public static void main(String[] args) {

        try {
            int x = 10 / 2;
        } catch (Exception e) {
            System.out.println("Error Occurred");
        } finally {
            System.out.println("Finally Always Runs");
        }
    }
}
