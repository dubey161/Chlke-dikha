package AnnotationBolte;

@Controller(path = "/users", secured = true)
class UserController {
    public void handleRequest() {
        System.out.println("Handling user request...");
    }
}

class ProductService {
    public void process() {
        System.out.println("Processing products...");
    }
}

@Controller(path = "/orders", secured = false)
class OrderController {
    public void handleRequest() {
        System.out.println("Handling order request...");
    }
}
