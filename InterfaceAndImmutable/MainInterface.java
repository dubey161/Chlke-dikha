package InterfaceAndImmutable;

public class MainInterface {
    public static void main(String[] args) {
        MyCalculator calc = new MyCalculator();


        Calculator calc2 = new Calculator() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        };

        System.out.println(calc2.add(5, 3));            // Calls overridden add()
        System.out.println(calc2.multiplyByTwo(10));    // Calls default method
        System.out.println(Calculator.squareOfSum(2,3));//

        System.out.println("Add: " + calc.add(5, 3));
        System.out.println("Multiply by 2 (default): " + calc.multiplyByTwo(6));
        System.out.println("Square of sum (static): " + Calculator.squareOfSum(3, 4));
    }
}
