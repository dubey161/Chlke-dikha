package demo;

import java.lang.reflect.Method;

public class PublicInheritedMethodsDemo {

    public static void main(String[] args) {

        Class<?> cls = ChildClass.class;

        System.out.println("=== PUBLIC METHODS (INCLUDING INHERITED) ===");
        Method[] methods = cls.getMethods();

        for (Method m : methods) {
            System.out.println(m.getDeclaringClass().getSimpleName() + " -> " + m.getName());
        }
    }
}
