package AnnotationBolte;

public class Mobile {

    @Deprecated
    public void oldFeature() {
        System.out.println("Old feature (Deprecated)");
    }

    public void newFeature() {
        System.out.println("New feature (Use this)");
    }
}
