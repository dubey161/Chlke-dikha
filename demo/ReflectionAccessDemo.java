package demo;

public class ReflectionAccessDemo {

    public static void main(String[] args) throws Exception {

        // ❌ DO NOT USE ExampleClass (your class name was wrong)
        // ✔ Use ReflectionBasic instead

        // 1️⃣ Get class using ClassName.class
        Class<?> c1 = ReflectionBasic.class;
        System.out.println("1) Using ClassName.class  → " + c1.getName());

        // 2️⃣ Get class using object.getClass()
        ReflectionBasic inst = new ReflectionBasic();
        Class<?> c2 = inst.getClass();
        System.out.println("2) Using obj.getClass()  → " + c2.getName());

        // 3️⃣ Get class using Class.forName()
        Class<?> c3 = Class.forName("demo.ReflectionBasic");
        System.out.println("3) Using Class.forName   → " + c3.getName());

        // 4️⃣ Get class using ClassLoader.loadClass()
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Class<?> c4 = cl.loadClass("demo.ReflectionBasic");
        System.out.println("4) Using ClassLoader     → " + c4.getName());
    }
}
