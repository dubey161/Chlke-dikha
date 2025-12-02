package FunctionInterface;

public class MainBooleanSupplier {
    public static void main(String[] args) {

        // Lambda: returns true if random > 0.5 Custom BooleanSupplier (no input, returns boolean)
        MyBooleanSupplier randomBool = () -> Math.random() > 0.5;

        System.out.println(randomBool.getAsBoolean());
    }
}
