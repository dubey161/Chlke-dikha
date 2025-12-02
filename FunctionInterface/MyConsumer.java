package FunctionInterface;

@FunctionalInterface
public interface MyConsumer<T> {
    // Custom Consumer Interface (takes input, no return)
    void accept(T t);
}
