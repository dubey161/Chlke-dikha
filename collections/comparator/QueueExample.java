package collections.comparator;

import java.util.*;

public class QueueExample {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println(queue.poll()); // 10 (removed)
        System.out.println(queue.peek()); // 20 (not removed)
        System.out.println(queue);         // [20, 30]
    }
}
