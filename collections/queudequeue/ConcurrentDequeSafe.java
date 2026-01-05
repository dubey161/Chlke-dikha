package collections.queudequeue;

import java.util.*;
import java.util.concurrent.*;

public class ConcurrentDequeSafe {

    public static void main(String[] args) throws Exception {

        Deque<Integer> deque = new ConcurrentLinkedDeque<>();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                deque.addLast(i); // lock-free
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("ConcurrentDeque size: " + deque.size()); // 2000
    }
}
