package Reflection;

import java.lang.reflect.Method;

public class DeclaredMethodsOnlyDemo {

    public static void main(String[] args) {

        Class<?> cls = ChildClass.class;

        System.out.println("=== METHODS DECLARED ONLY IN THIS CLASS ===");
        Method[] methods = cls.getDeclaredMethods();

        for (Method m : methods) {
            System.out.println(m.getName() + " | modifiers=" + m.getModifiers());
        }
    }
}
