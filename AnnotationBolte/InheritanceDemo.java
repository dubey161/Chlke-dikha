package AnnotationBolte;

public class InheritanceDemo {
    public static void main(String[] args) {
        System.out.println(
            ChildClass.class.isAnnotationPresent(ParentAnnotation.class)
        );
        // Output: true (because @Inherited is used)
    }
}
