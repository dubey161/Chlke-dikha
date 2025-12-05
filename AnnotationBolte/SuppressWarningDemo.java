package AnnotationBolte;


@SuppressWarnings("deprecation")
public class SuppressWarningDemo {
    public static void main(String[] args) {
        Mobile m = new Mobile();
        m.oldFeature(); // No warning now
    }
}
