package Reflection;

public class BrokenSingleton {

    private static BrokenSingleton instance = new BrokenSingleton();

    private BrokenSingleton() {
        System.out.println("Constructor called!");
    }

    public static BrokenSingleton getInstance() {
        return instance;
    }
}
