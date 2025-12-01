package InterfaceAndImmutable;

public interface Calculator {

    // Abstract method
    int add(int a, int b);

    // Default method
    default int multiplyByTwo(int a) {
        return multiply(a, 2); // Calls private helper
    }

    // Private instance method (Java 9+)
    private int multiply(int a, int b) {
        return a * b;
    }

    // Private static method (Java 9+)
    private static int square(int a) {
        return a * a;
    }

    // Public static method using private static method
    static int squareOfSum(int a, int b) {
        return square(a + b);
    }
}
