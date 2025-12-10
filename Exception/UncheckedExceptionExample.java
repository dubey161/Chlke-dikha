package Exception;

public class UncheckedExceptionExample {
    public static void main(String[] args) {
        try {
            int arr[] = {10, 20};
            System.out.println(arr[5]); 
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index wrong");
        }
    }
}
