package Reflection;

import  java.lang.reflect.Field;
public class ReflectionTest {
    public static void main(String[] args) throws Exception {

        Demo obj = new Demo();

        Class<?> cls = Demo.class;

        // Instance field
        Field f1 = cls.getField("x");
        System.out.println("Instance field x = " + f1.get(obj));

        // Static field
        Field f2 = cls.getField("y");
        System.out.println("Static field y = " + f2.get(null));
    }
}

class Demo {
    public int x = 10;
    public static int y = 20;
}
