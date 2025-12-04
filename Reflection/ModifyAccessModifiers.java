package Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ModifyAccessModifiers {
    public static void main(String[] args) throws Exception {

        Person obj = new Person();
        Class<?> cls = obj.getClass();


        System.out.println("\n==== 1. PUBLIC FIELD ====");
        Field f = cls.getField("name");
        System.out.println("Old name = " + f.get(obj));
        f.set(obj, "Michael");
        System.out.println("New name = " + f.get(obj));

        System.out.println("\n==== 2. PRIVATE FIELD ====");
        Field age = cls.getDeclaredField("age");
        age.setAccessible(true);
        System.out.println("Old age = " + age.get(obj));
        age.set(obj, 40);
        System.out.println("New age = " + age.get(obj));

        System.out.println("\n==== 3. PRIVATE METHOD ====");
        Method secret = cls.getDeclaredMethod("secret");
        secret.setAccessible(true);
        secret.invoke(obj);

        System.out.println("\n==== 4. STATIC FIELD ====");
        Field country = cls.getField("country");
        System.out.println("Old country = " + country.get(obj));
        country.set(null, "USA");
        System.out.println("New country = " + Person.country);

        System.out.println("\n==== 5. CHANGING MODIFIERS (ADVANCED) ====");
        changePrivateFieldToPublic(age);
        System.out.println("Updated modifiers = " + Modifier.toString(age.getModifiers()));
    }

    // ADVANCED: Change access modifier of a field (Java 8–11)
    private static void changePrivateFieldToPublic(Field field) throws Exception {
        Field modifiers = Field.class.getDeclaredField("modifiers");
        modifiers.setAccessible(true);
        modifiers.setInt(field, field.getModifiers() & ~Modifier.PRIVATE | Modifier.PUBLIC);
    }
}