package AnnotationBolte;

import java.util.*;

public class Router {

    private static final Map<String, Class<?>> routeTable = new HashMap<>();

    public static void registerControllers(Class<?>... classes) {
        for (Class<?> cls : classes) {

            if (cls.isAnnotationPresent(Controller.class)) {
                Controller info = cls.getAnnotation(Controller.class);
                routeTable.put(info.path(), cls);
                System.out.println("🔧 Registered route: " + info.path() + " → " + cls.getSimpleName());
            }
        }
        System.out.println();
    }

    public static void run(String path) throws Exception {
        System.out.println("🌍 Incoming Request: " + path);

        Class<?> controllerClass = routeTable.get(path);

        if (controllerClass == null) {
            System.out.println("❌ 404 Not Found\n");
            return;
        }

        Controller info = controllerClass.getAnnotation(Controller.class);

        if (info.secured()) {
            System.out.println("🔐 This route requires security check... (simulated)\n");
        }

        Object obj = controllerClass.getDeclaredConstructor().newInstance();
        controllerClass.getMethod("handleRequest").invoke(obj);

        System.out.println();
    }

    public static void main(String[] args) throws Exception {

        registerControllers(
                Usera.class,
                Producta.class,
                Ordera.class
        );

        run("/users");
        run("/orders");
        run("/unknown");
    }
}
