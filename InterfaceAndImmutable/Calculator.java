package InterfaceAndImmutable;

@FunctionalInterface
public interface Calculator {

    int add(int a, int b);   // ONLY abstract method → Lambda allowed

    default int multiplyByTwo(int a) {
        return multiply(a, 2); 
    }

    private int multiply(int a, int b) {
        return a * b;
    }

    static int squareOfSum(int a, int b) {
        return square(a + b);
    }

    private static int square(int a) {
        return a * a;
    }
}
