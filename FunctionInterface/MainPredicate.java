package FunctionInterface;

public class MainPredicate {
    public static void main(String[] args) {

        // Lambda: check if number is even
        MyPredicate<Integer> isEven = n -> n % 2 == 0;

        System.out.println(isEven.test(10)); // true
        System.out.println(isEven.test(7));  // false
    }
}
