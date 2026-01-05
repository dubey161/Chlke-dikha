package collections.comparator;

import java.util.*;

public class CarComparatorExample {
    public static void main(String[] args) {

        Car[] cars = {
            new Car("SUV", "Petrol"),
            new Car("Sedan", "Diesel"),
            new Car("Hatchback", "CNG")
        };

        Arrays.sort(cars,
            (c1, c2) -> c1.name.compareTo(c2.name)
        );

        System.out.println(Arrays.toString(cars));
    }
}
