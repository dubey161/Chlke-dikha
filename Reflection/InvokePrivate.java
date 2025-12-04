package Reflection;

import java.lang.reflect.Method;

public class InvokePrivate {
    public static void main(String[] args) throws Exception {

        Sample obj = new Sample();
        Class<?> cls = obj.getClass();

        // Get private method
        Method m = cls.getDeclaredMethod("secretMessage");
        m.setAccessible(true); // allow access

        // Invoke and capture return value
        Object result = m.invoke(obj);

        System.out.println("Returned: " + result);
    }
}