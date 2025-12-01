package Sigleton;// File: SingletonBillPugh.java

/**
 * Bill Pugh Singleton
 * - Uses static inner helper class
 * - Thread-safe without synchronization
 * - Lazy initialization
 * - Pros: Elegant, thread-safe, lazy
 */
public class SingletonBillPugh {

    private SingletonBillPugh() {
        System.out.println("SingletonBillPugh Constructor Called");
    }

    // Inner static helper class holds the instance
    private static class SingletonHelper {
        private static final SingletonBillPugh INSTANCE = new SingletonBillPugh();
    }

    public static SingletonBillPugh getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public static void main(String[] args) {
        SingletonBillPugh s1 = SingletonBillPugh.getInstance();
        SingletonBillPugh s2 = SingletonBillPugh.getInstance();
        System.out.println("s1 == s2? " + (s1 == s2));
    }
}
