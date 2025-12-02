package FunctionInterface;

public class MainBiFunction {
    public static void main(String[] args) {

        // Lambda: add two numbers
        MyBiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;

        System.out.println(add.apply(5, 10));  // 15
    }
}
