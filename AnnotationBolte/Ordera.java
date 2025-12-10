package AnnotationBolte;

@Controller(path = "/orders", secured = false)
public class Ordera {
    public void handleRequest() {
        System.out.println("📦 Handling ORDER request...");
    }
}
