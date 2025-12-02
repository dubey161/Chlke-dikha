package FunctionInterface;

@FunctionalInterface
public interface MySupplier<T> {
    // Custom Supplier Interface (supplies value, no input)
    T get();
}
