package AnnotationBolte;

@Controller(path = "/users", secured = true)
public class Usera {
    public void handleRequest() {
        System.out.println("📩 Handling USER request...");
    }
}
