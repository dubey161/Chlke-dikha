package Reflection;

import java.lang.reflect.Constructor;

public class ProtectSingletonTest {
    public static void main(String[] args) throws Exception {

        SafeSingleton s1 = SafeSingleton.getInstance();

//        Constructor<SafeSingleton> ctor =
//                SafeSingleton.class.getDeclaredConstructor();

//        Class<?> cls = SafeSingleton.class;
//        Constructor<?> ctor = cls.getDeclaredConstructor();

        SafeSingleton temp = SafeSingleton.getInstance();
        Constructor<?> ctor = temp.getClass().getDeclaredConstructor();



        ctor.setAccessible(true);
        // fails


        // This will now throw an exception
        SafeSingleton s2 = (SafeSingleton) ctor.newInstance();


        //fails through enum
//        Constructor<?>[] ctors = EnumSingleton.class.getDeclaredConstructors();
//        ctors[0].setAccessible(true);
//        ctors[0].newInstance();
    }
}
