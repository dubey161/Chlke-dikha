package collections.comparator;

import java.util.*;

public class ComparatorExample {
    public static void main(String[] args) {

        Integer[] arr = {6, 1, 9, 2};

        Arrays.sort(arr, (a, b) -> b - a);

        System.out.println(Arrays.toString(arr));
    }
}
