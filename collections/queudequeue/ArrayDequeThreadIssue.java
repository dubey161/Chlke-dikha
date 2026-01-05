package collections.queudequeue;

import java.util.*;

public class ArrayDequeThreadIssue {

    public static void main(String[] args) throws Exception {

        Deque<Integer> deque = new ArrayDeque<>();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                deque.addLast(i);
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // May throw exception OR wrong size
        System.out.println("Deque size: " + deque.size());
    }
}
