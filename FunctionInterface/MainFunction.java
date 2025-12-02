package FunctionInterface;

public class MainFunction {
    public static void main(String[] args) {

        // Lambda: convert Integer → String
        MyFunction<Integer, String> intToString = num -> "Number is: " + num;

        System.out.println(intToString.apply(10));
    }
}
