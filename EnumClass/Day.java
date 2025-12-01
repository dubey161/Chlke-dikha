package EnumClass;

public enum Day {
    MONDAY("Weekday"),
    TUESDAY("Weekday"),
    SATURDAY("Weekend"),
    SUNDAY("Weekend");
    private final String type;

    // enum constructor (always private)
    private Day(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

