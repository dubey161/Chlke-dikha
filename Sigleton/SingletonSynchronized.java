package Sigleton;// File: SingletonSynchronized.java

/**
 * Synchronized Block Singleton
 * - Thread-safe
 * - Synchronization applied to method (or block)
 * - Cons: Synchronization overhead on every call
 */
public class SingletonSynchronized {

    private static SingletonSynchronized instance;

    private SingletonSynchronized() {
        System.out.println("SingletonSynchronized Constructor Called");
    }

    // Thread-safe method
    public static synchronized SingletonSynchronized getInstance() {
        if (instance == null) {
            instance = new SingletonSynchronized();
        }
        return instance;
    }

    public static void main(String[] args) {
        SingletonSynchronized s1 = SingletonSynchronized.getInstance();
        SingletonSynchronized s2 = SingletonSynchronized.getInstance();
        System.out.println("s1 == s2? " + (s1 == s2));
    }
}
