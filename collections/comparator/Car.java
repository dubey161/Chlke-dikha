package collections.comparator;

class Car {
    String name;
    String type;

    Car(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String toString() {
        return name + " - " + type;
    }
}
