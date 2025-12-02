package FunctionInterface;

@FunctionalInterface
public interface MyFunction<T, R> {
    // Custom Function Interface (T → R) apply to
    R apply(T t);
}
