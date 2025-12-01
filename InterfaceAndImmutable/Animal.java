package InterfaceAndImmutable;

// Abstract class with constructor, abstract and concrete methods
public abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
        System.out.println("Animal constructor called");
    }

    public abstract void sound();

    public void eat() {
        System.out.println(name + " is eating");
    }
}
