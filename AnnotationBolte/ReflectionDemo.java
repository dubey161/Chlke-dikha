package AnnotationBolte;

public class ReflectionDemo {
    public static void main(String[] args) {
        Class<?> cls = AnnotatedClass.class;

        if (cls.isAnnotationPresent(MyAnnotation.class)) {
            System.out.println("Annotation FOUND!");
        } else {
            System.out.println("Annotation NOT found.");
        }
    }
}
