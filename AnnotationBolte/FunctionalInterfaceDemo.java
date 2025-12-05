package AnnotationBolte;

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        MyFunction obj = () -> System.out.println("Functional Interface Example");
        obj.show();
    }
}
