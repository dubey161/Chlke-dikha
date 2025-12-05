package AnnotationBolte;

public class AccessChecker {

    public static void checkAccess(Class<?> cls) {
        if (cls.isAnnotationPresent(CompanyAccess.class)) {
            System.out.println(cls.getSimpleName() + " ✔ Has company access");
        } else {
            System.out.println(cls.getSimpleName() + " ❌ No access");
        }
    }

    public static void main(String[] args) {
        checkAccess(Employee.class);
        checkAccess(Developer.class);
        checkAccess(BackendDeveloper.class);
    }
}
