package AnnotationBolte;

public class Sparrow implements Bird {

    @Override    // annotation used on method
    public void fly() {
        System.out.println("Sparrow is flying...");
    }
}
