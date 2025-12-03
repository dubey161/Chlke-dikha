package demo;

public class ReflectionBasic {

    // Public field
    public int pub = 1;

    // Private field
    private String secret = "s";

    // Public constructor
    public ReflectionBasic() {
        System.out.println("Public constructor invoked");
    }

    // Private constructor
    private ReflectionBasic(String s) {
        System.out.println("Private constructor invoked");
        this.secret = s;
    }

    // Public method
    public void hello() {
        System.out.println("hi");
    }

    // Private method
    private String whisper() {
        return "shh";
    }

    // Public static field
    public static int staticVal = 42;
}
