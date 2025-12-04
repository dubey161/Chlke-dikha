package Reflection;

public class Sample {
    public void greet() {
        System.out.println("Hello from public method!");
    }

    private String secretMessage() {
        return "This is private!";
    }

    public int ans(int x,int y){
        return x+y;
    }
}