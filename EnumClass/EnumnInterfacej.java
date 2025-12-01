package EnumClass;

public enum EnumnInterfacej implements EnumInterface {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY;

    public String toLowerCase() {
        return this.name().toLowerCase();
    }
    public int ordinalXfive() {
        return this.ordinal()*5;
    }
}
