package collections.comparator;

import java.util.*;

public class SortIntArrayDescending {

    public static void main(String[] args) {

        int[] arr = { 2, 1, 4, 3 };

        // 1️⃣ Convert int[] → Integer[]
        Integer[] boxed = Arrays.stream(arr)
                                .boxed()
                                .toArray(Integer[]::new);

        // 2️⃣ Sort using Comparator (descending)
        Arrays.sort(boxed, (a, b) -> b - a);

        // 3️⃣ Convert back Integer[] → int[]
        int[] sortedDesc = Arrays.stream(boxed)
                                 .mapToInt(Integer::intValue)
                                 .toArray();

        // Output
        System.out.println(Arrays.toString(sortedDesc));
    }
}
