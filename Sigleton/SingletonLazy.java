package Sigleton;// File: SingletonLazy.java

/**
 * Lazy Initialization Singleton
 * - Instance is created only when needed
 * - Not thread-safe in multi-threaded environment
 * - Pros: saves resources if instance not used
 * - Cons: requires synchronization for thread safety
 */
public class SingletonLazy {

    private static SingletonLazy instance;

    private SingletonLazy() {
        System.out.println("SingletonLazy Constructor Called");
    }

    public static SingletonLazy getInstance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }

    public static void main(String[] args) {
        SingletonLazy s1 = SingletonLazy.getInstance();
        SingletonLazy s2 = SingletonLazy.getInstance();
        System.out.println("s1 == s2? " + (s1 == s2));
    }
}
