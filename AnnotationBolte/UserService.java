package AnnotationBolte;

@Role("ADMIN")
@Role("MANAGER")
@Role("DEVELOPER")
class UserService {

    public void accessFeature() {
        System.out.println("Feature Access Granted!");
    }
}
