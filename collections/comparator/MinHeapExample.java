/*
/PriorityQueue (Heap in Java)

👉 Java Heap = PriorityQueue

Types

Min Heap (default)
✔ Automatically sorted
✔ Uses natural ordering (ascending)
✔ Internally Min Heap

Max Heap (using Comparator)
 */

package collections.comparator;

import java.util.*;

public class MinHeapExample {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(5);
        pq.add(2);
        pq.add(8);
        pq.add(1);

        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }
}
