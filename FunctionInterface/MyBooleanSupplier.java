package FunctionInterface;

@FunctionalInterface
public interface MyBooleanSupplier {
    //Custom BooleanSupplier (no input, returns boolean)
    boolean getAsBoolean();
}
