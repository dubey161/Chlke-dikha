package lombok;

public class D implements  C{
    @Override
    public String doso() {
        return "doso";
    }

    public static void main(String[] args) {
        C c = new D();
        System.out.println(c.doso());
    }
}
