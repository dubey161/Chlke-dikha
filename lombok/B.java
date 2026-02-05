package lombok;

public class B extends A {
    public String doso(){
        return "fool";
    }

    public static void main(String[] args) {
//        B b=new A();
        A a = new B();
    }

}
