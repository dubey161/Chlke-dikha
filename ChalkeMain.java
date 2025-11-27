public class ChalkeMain {

        public static void main(String[] args) {
            Box<String> stringBox = new Box<>();
            stringBox.set("Hello");
            System.out.println(stringBox.get());

            Box<Integer> intBox = new Box<>();
            intBox.set(100);
            System.out.println(intBox.get());

            NumericBox<Integer> intBoxi = new NumericBox<>(10);
            System.out.println(intBoxi.doubleValue());  // 10.0

            NumericBox<Double> doubleBox = new NumericBox<>(5.5);
            System.out.println(doubleBox.doubleValue());
        }
    }

