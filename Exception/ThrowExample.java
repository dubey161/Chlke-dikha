package Exception;

public class ThrowExample {
    public static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or above");
        }
        System.out.println("Valid Age");
    }

    public static void main(String[] args) {
        checkAge(15);
    }
}
