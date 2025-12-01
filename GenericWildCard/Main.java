package GenericWildCard;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Util.printTwice("Hello");   // works with String
        Util.printTwice(123);       // works with Integer
        Util.printTwice(5.5);
        List<String> names = List.of("A", "B", "C");
        List<Integer> numbers = List.of(1, 2, 3);

        Util.printList(names);    // allowed
        Util.printList(numbers);  // allowed
// works with Double

        List<String> namess = List.of("A", "B", "C");
        List<Integer> numberss = List.of(1, 2, 3);

        Util.printLists(namess);    // allowed
        Util.printLists(numberss);  // allowed

        List<Integer> ints = List.of(10, 20, 30);
        List<Double> doubles = List.of(1.5, 2.5, 3.5);

        System.out.println(Util.sumList(ints));      // 60.0
        System.out.println(Util.sumList(doubles));   // 7.5

        List<Object> objs = new ArrayList<>();
        List<Number> nums = new ArrayList<>();
        List<Integer> intss = new ArrayList<>();

        Util.addNumbers(objs);   // allowed
        Util.addNumbers(nums);   // allowed
        Util.addNumbers(intss);   // allowed


        Util.compare(List.of("a"), List.of("b"));  // OK
        Util.compare(List.of(1), List.of(2));      // OK

        Util.compares(List.of("a"), List.of("b"));  // OK
        Util.compares(List.of(1), List.of(2));      // OK

       Util.mix(List.of(1), List.of("hello"));   // ✔ Allowed


        List<Number> umberss = new ArrayList<>();
        List<Integer> intsss = List.of(10, 20, 30);

        Util.copyFirst(umberss, intsss);  // OK
        System.out.println(umberss); // [10]




    }
}
