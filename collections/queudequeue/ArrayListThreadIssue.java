/*
/❌ Why failure happens?

Internal array resizing

No locking

Two threads modify same structure
 */

package collections.queudequeue;

import java.util.*;

public class ArrayListThreadIssue {

    public static void main(String[] args) throws Exception {

        List<Integer> list = new ArrayList<>();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i); // NOT synchronized
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // Expected size = 2000
        // Actual size may be < 2000 (DATA LOSS)
        System.out.println("ArrayList size: " + list.size());
    }
}
