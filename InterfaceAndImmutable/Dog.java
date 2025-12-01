package InterfaceAndImmutable;

public class Dog extends Animal {

    public Dog(String name) {
        super(name); // Calls Animal constructor
        System.out.println("Dog constructor called");
    }

    @Override
    public void sound() {
        System.out.println(name + " says Woof!");
    }
}
