package GenericWildCard;

class NumericBox<T extends Number> {
    private T number;

    public NumericBox(T number) {
        this.number = number;
    }

    public double doubleValue() {
        return number.doubleValue();
    }
}
