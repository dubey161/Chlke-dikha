package Exception;

public class RethrowExample {

    static void testMethod() {
        try {
            int a = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Handling inside method...");
            throw e; // rethrowing exception
        }
    }

    public static void main(String[] args) {
        try {
            testMethod();
        } catch (ArithmeticException e) {
            System.out.println("Caught Again in main()");
        }
    }
}
