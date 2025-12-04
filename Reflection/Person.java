package Reflection;

public class Person {
    public String name = "John";      // public field
    private int age = 20;             // private field

    public void show() {              // public method
        System.out.println("Name=" + name + ", Age=" + age);
    }

    private void secret() {           // private method
        System.out.println("This is a secret method!");
    }

    public static String country = "India";  // public static field
}