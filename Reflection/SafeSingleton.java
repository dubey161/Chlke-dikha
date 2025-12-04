package Reflection;

public class SafeSingleton {

    private static boolean instanceCreated = false;

    private static final SafeSingleton instance = new SafeSingleton();

    private SafeSingleton() {
        if (!instanceCreated) {
            throw new RuntimeException("Reflection not allowed! Singleton already created");
        }
        instanceCreated = true;
    }

    public static SafeSingleton getInstance() {
        return instance;
    }
}
