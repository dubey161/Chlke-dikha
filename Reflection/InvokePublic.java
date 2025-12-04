package Reflection;

import java.lang.reflect.Method;

public class InvokePublic {
    public static void main(String[] args) throws Exception {

        // Create normal instance
        Sample obj = new Sample();

        // Get Class object
        Class<?> cls = obj.getClass();

        // Get public method (no parameters)
        Method m = cls.getMethod("greet");
        Method an = cls.getMethod("ans",int.class,int.class);
        Object result = an.invoke(obj, 4, 5);

        // Invoke method on instance
        m.invoke(obj);
        System.out.println(result);
    }
}