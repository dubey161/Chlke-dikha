package FunctionInterface;

public class MainConsumer {
    public static void main(String[] args) {

        // Lambda: print a message
        MyConsumer<String> printer = msg -> System.out.println("Message: " + msg);

        printer.accept("Hello Lambda!");
    }
}
