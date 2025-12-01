package Sigleton;// File: SingletonWithSubclass.java

/**
 * Singleton with Subclass
 * - Usually not recommended to allow subclassing
 * - Subclass can break singleton guarantee
 * - Use final class to prevent subclassing
 */
class SingletonBase {
    private static final SingletonBase INSTANCE = new SingletonBase();

    protected SingletonBase() {
        System.out.println("SingletonBase Constructor Called");
    }

    public static SingletonBase getInstance() {
        return INSTANCE;
    }
}

// Attempt to subclass
class SingletonChild extends SingletonBase {
    public SingletonChild() {
        super();
        System.out.println("SingletonChild Constructor Called");
    }
}

public class MainSingletonSubclass {
    public static void main(String[] args) {
        SingletonBase base = SingletonBase.getInstance();
        System.out.println("base: " + base);

        // Subclass instance can exist separately
        SingletonChild child = new SingletonChild();
        System.out.println("child: " + child);
    }
}
