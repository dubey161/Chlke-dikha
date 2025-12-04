package Reflection;

import java.lang.reflect.Constructor;

public class ReflectionBreakSingleton {
    public static void main(String[] args) throws Exception {

        BrokenSingleton s1 = BrokenSingleton.getInstance();
//        BrokenSingleton v=BrokenSingleton() not allowed private construcotr

        // Get private constructor
        Constructor<BrokenSingleton> ctor =
                BrokenSingleton.class.getDeclaredConstructor();
        ctor.setAccessible(true);

        Class<?> instanceClass = s1.getClass();
        Constructor<?> ctor2 = instanceClass.getDeclaredConstructor();

        Class<?> cls = Class.forName("Reflection.BrokenSingleton");
        Constructor<?> ctor3 = cls.getDeclaredConstructor();
        ctor3.setAccessible(true);

        BrokenSingleton s3 = (BrokenSingleton) ctor3.newInstance();

        // Create a NEW object (breaking singleton)
        BrokenSingleton s2 = ctor.newInstance();

        System.out.println("s1 hash = " + s1.hashCode());
        System.out.println("s2 hash = " + s2.hashCode());
        System.out.println("s3 hash = " + s3.hashCode());
        System.out.println("Are both same? " + (s1 == s2));
    }
}