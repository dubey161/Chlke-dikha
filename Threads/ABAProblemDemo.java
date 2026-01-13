package Threads;

import java.util.concurrent.atomic.AtomicReference;

public class ABAProblemDemo {

    static AtomicReference<Integer> ref = new AtomicReference<>(10);

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            Integer expected = ref.get();
            System.out.println("T1 read value = " + expected);

            try { Thread.sleep(2000); } catch (InterruptedException e) {}

            boolean success = ref.compareAndSet(expected, 20);
            System.out.println("T1 CAS success = " + success +
                               ", current value = " + ref.get());
        });

        Thread t2 = new Thread(() -> {
            try { Thread.sleep(500); } catch (InterruptedException e) {}

            ref.compareAndSet(10, 30);
            System.out.println("T2 changed 10 → 30");

            ref.compareAndSet(30, 10);
            System.out.println("T2 changed 30 → 10");
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
