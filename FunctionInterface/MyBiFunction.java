package FunctionInterface;

@FunctionalInterface
public interface MyBiFunction<T, U, R> {
    // 5. Custom BiFunction Interface (T, U → R)
    R apply(T t, U u);
}
