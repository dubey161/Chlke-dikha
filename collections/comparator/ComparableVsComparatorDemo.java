package collections.comparator;

import java.util.*;

/*
 * This demo shows:
 * 1️⃣ Comparable  → class-level sorting (natural order)
 * 2️⃣ Comparator  → custom sorting (external / flexible)
 *
 * IMPORTANT RULE:
 * - Collections.sort(list)           → uses Comparable (compareTo)
 * - Collections.sort(list, comparator) → uses Comparator (compare)
 */

public class ComparableVsComparatorDemo {

    // =========================
    // 1️⃣ Car class
    // =========================
    static class Car implements Comparable<Car> {

        String name;
        int price;

        Car(String name, int price) {
            this.name = name;
            this.price = price;
        }

        /*
         * Comparable implementation
         * --------------------------
         * This is called ONLY when:
         * Collections.sort(cars) is used
         *
         * Natural Order:
         * Ascending by price
         */
        @Override
        public int compareTo(Car other) {
            return this.price - other.price; // ascending
        }

        @Override
        public String toString() {
            return name + " : " + price;
        }
    }

    // =========================
    // 2️⃣ Main method
    // =========================
    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Sedan", 15));
        cars.add(new Car("SUV", 20));
        cars.add(new Car("Hatchback", 10));

        // -------------------------------------
        // CASE 1: Comparable
        // -------------------------------------
        // No Comparator passed
        // Java uses compareTo() from Car class
        Collections.sort(cars);

        System.out.println("Comparable (Ascending by price):");
        System.out.println(cars);

        // -------------------------------------
        // CASE 2: Comparator - Descending price
        // -------------------------------------
        // Comparator is passed
        // compareTo() is IGNORED
        Collections.sort(cars,
                (c1, c2) -> c2.price - c1.price
        );

        System.out.println("\nComparator (Descending by price):");
        System.out.println(cars);

        // -------------------------------------
        // CASE 3: Comparator - Ascending by name
        // -------------------------------------
        Collections.sort(cars,
                (c1, c2) -> c1.name.compareTo(c2.name)
        );

        System.out.println("\nComparator (Ascending by name):");
        System.out.println(cars);
    }
}
