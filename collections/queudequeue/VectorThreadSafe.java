package collections.queudequeue;
/*
/public synchronized boolean add(E e)
❌ Downside: slow (global lock)
 */
import java.util.*;

public class VectorThreadSafe {

    public static void main(String[] args) throws Exception {

        List<Integer> list = new Vector<>();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i); // synchronized
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        // Always 2000
        System.out.println("Vector size: " + list.size());
    }
}
