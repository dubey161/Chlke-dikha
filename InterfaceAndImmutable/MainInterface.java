package InterfaceAndImmutable;

public class MainInterface {
    public static void main(String[] args) {
        MyCalculator calc = new MyCalculator();

        System.out.println("Add: " + calc.add(5, 3));
        System.out.println("Multiply by 2 (default): " + calc.multiplyByTwo(6));
        System.out.println("Square of sum (static): " + Calculator.squareOfSum(3, 4));
    }
}
