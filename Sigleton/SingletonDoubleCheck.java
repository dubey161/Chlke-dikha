package Sigleton;// File: SingletonDoubleCheck.java

/**
 * Double-Check Locking Singleton
 * - Thread-safe
 * - Reduces synchronization overhead
 * - Uses volatile to prevent instruction reordering
 * - Pros: Lazy initialization + good performance
 */
public class SingletonDoubleCheck {

    private static volatile SingletonDoubleCheck instance;

    private SingletonDoubleCheck() {
        System.out.println("SingletonDoubleCheck Constructor Called");
    }

    public static SingletonDoubleCheck getInstance() {
        if (instance == null) {            // 1st check
            synchronized (SingletonDoubleCheck.class) {
                if (instance == null) {    // 2nd check
                    instance = new SingletonDoubleCheck();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        SingletonDoubleCheck s1 = SingletonDoubleCheck.getInstance();
        SingletonDoubleCheck s2 = SingletonDoubleCheck.getInstance();
        System.out.println("s1 == s2? " + (s1 == s2));
    }
}
