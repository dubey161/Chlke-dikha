package Reflection;

public class ChildClass extends BaseClass {

    public void childPublicMethod() {
        System.out.println("ChildClass: childPublicMethod()");
    }

    private void childPrivateMethod() {
        System.out.println("ChildClass: childPrivateMethod()");
    }
}
