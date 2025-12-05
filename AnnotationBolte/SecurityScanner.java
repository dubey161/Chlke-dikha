package AnnotationBolte;

public class SecurityScanner {
    public static void main(String[] args) throws Exception {

        Class<?> cls = UserService.class;

        // Read repeated roles
        Role[] roles = cls.getAnnotationsByType(Role.class);

        System.out.println("🔐 Roles found on class:");
        for (Role r : roles) {
            System.out.println("- " + r.value());
        }

        // Simple logic: allow only if ADMIN exists
        boolean isAdmin = java.util.Arrays.stream(roles)
                        .anyMatch(r -> r.value().equals("ADMIN"));

        System.out.println("\nAccess Check:");
        if (isAdmin) {
            UserService service = new UserService();
            service.accessFeature();
        } else {
            System.out.println("❌ Access Denied.");
        }
    }
}
