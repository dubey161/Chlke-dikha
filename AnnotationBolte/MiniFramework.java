package AnnotationBolte;

import java.util.*;

public class MiniFramework {

    public static void main(String[] args) throws Exception {

        List<Class<?>> classes = List.of(
                UserController.class,
                ProductService.class,
                OrderController.class
        );

        System.out.println("🔍 Detecting controllers...\n");

        for (Class<?> cls : classes) {

            if (cls.isAnnotationPresent(Controller.class)) {

                Controller info = cls.getAnnotation(Controller.class);

                System.out.println(cls.getSimpleName() + " is a controller.");
                System.out.println("➡ Route: " + info.path());
                System.out.println("🔐 Secured: " + info.secured());

                // create object and call method
                Object obj = cls.getDeclaredConstructor().newInstance();
                cls.getMethod("handleRequest").invoke(obj);

                System.out.println();
            }
        }
    }
}
