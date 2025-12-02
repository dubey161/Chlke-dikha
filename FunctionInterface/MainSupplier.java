package FunctionInterface;

public class MainSupplier {
    public static void main(String[] args) {

        // Lambda: supply a random number
        MySupplier<Double> randomSupplier = () -> Math.random();

        System.out.println(randomSupplier.get());
    }
}
