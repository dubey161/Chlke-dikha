package Sigleton;// File: SingletonEager.java

/**
 * Eager Initialization Singleton
 * - Instance is created at class loading time
 * - Thread-safe without synchronization
 * - Cons: Instance is created even if it may not be used
 */
public class SingletonEager {

    // 1. Private static final instance created eagerly
    private static final SingletonEager INSTANCE = new SingletonEager();

    // 2. Private constructor to prevent external instantiation
    private SingletonEager() {
        System.out.println("SingletonEager Constructor Called");
    }

    // 3. Public method to access the instance
    public static SingletonEager getInstance() {
        return INSTANCE;
    }

    // Demo main
    public static void main(String[] args) {
        SingletonEager s1 = SingletonEager.getInstance();
        SingletonEager s2 = SingletonEager.getInstance();

        System.out.println("s1 == s2? " + (s1 == s2)); // true
    }
}
