package Sigleton;// File: SingletonEnum.java

/**
 * Enum Singleton
 * - Simplest, thread-safe
 * - Handles serialization automatically
 * - Cannot be broken by reflection
 */
public enum SingletonEnum {
    INSTANCE;

    public void showMessage() {
        System.out.println("Hello from Enum Singleton");
    }

    public static void main(String[] args) {
        SingletonEnum s1 = SingletonEnum.INSTANCE;
        SingletonEnum s2 = SingletonEnum.INSTANCE;

        s1.showMessage();
        System.out.println("s1 == s2? " + (s1 == s2)); // true
    }
}
