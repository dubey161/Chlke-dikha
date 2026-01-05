/*
| Operation       | Time     |
| --------------- | -------- |
| add             | O(log N) |
| poll/remove     | O(log N) |
| peek            | O(1)     |
| remove(element) | O(N)     |

/
 */

package collections.comparator;

import java.util.*;

public class MaxHeapExample {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq =
                new PriorityQueue<>((a, b) -> b - a);

        pq.add(5);
        pq.add(2);
        pq.add(8);
        pq.add(1);

        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }
}
