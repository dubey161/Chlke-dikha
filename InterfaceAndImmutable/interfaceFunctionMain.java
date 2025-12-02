package InterfaceAndImmutable;

public class interfaceFunctionMain {
    public static void main(String[] args) {
        // Anonymous class MUST implement both:
        Calc c = new Calc() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }

            @Override
            public int subtract(int a, int b) {
                return a - b;
            }
        };

        System.out.println(c.multiplyByTwo(10)); // works

        // Lambda expression for the abstract method "add"
        Calculator calc = (a, b) -> a + b;

        System.out.println("Add = " + calc.add(5, 7));               // 12
        System.out.println("MultiplyByTwo = " + calc.multiplyByTwo(10)); // 20

        System.out.println("SquareOfSum = " + Calculator.squareOfSum(3, 4)); // 49
    }
}
