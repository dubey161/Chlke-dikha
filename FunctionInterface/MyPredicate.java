package FunctionInterface;

@FunctionalInterface
public interface MyPredicate<T> {
    // Custom Predicate Interface (boolean test)
    boolean test(T t);
}
