package Threads.SechduledThread;

import java.util.List;
import java.util.concurrent.*;


/*
: What does fully terminated mean?

All tasks finished, no queued tasks, and all worker threads exited.

Q: Does awaitTermination stop threads?

No, it only waits and checks termination status.

Q: Does shutdownNow guarantee stopping threads?

No, it only interrupts them on a best-effort basis.

 */
public class ExecutorTerminationDemo {

    public static void main(String[] args) throws Exception {

        System.out.println("===== shutdown() DEMO =====");
        shutdownDemo();

        Thread.sleep(7000);

        System.out.println("\n===== awaitTermination() DEMO =====");
        awaitTerminationDemo();

        Thread.sleep(7000);

        System.out.println("\n===== shutdownNow() DEMO =====");
        shutdownNowDemo();


//        ExecutorService executor = Executors.newFixedThreadPool(2);
//        ThreadLocal<String> threadLocal = new ThreadLocal<>();
//
//        executor.submit(() -> {
//            threadLocal.set("Task-1 Data");
//        });
//
//        for (int i = 0; i < 10; i++) {
//            executor.submit(() -> {
//                System.out.println(threadLocal.get());
//            });
//        }

//        ExecutorService executor = Executors.newFixedThreadPool(2);
//        ThreadLocal<String> threadLocal = new ThreadLocal<>();
//
//        executor.submit(() -> {
//            try {
//                threadLocal.set("Task-1 Data");
//                System.out.println("Set done by: " + Thread.currentThread().getName());
//            } finally {
//                threadLocal.remove(); // CLEANUP
//            }
//        });
//
//        for (int i = 0; i < 10; i++) {
//            executor.submit(() -> {
//                System.out.println(
//                        Thread.currentThread().getName() + " -> " + threadLocal.get()
//                );
//            });
//        }




    }

    // ----------------------------
    // 1. shutdown()
    // ----------------------------
    private static void shutdownDemo() {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        executor.submit(() -> {
            try {
                System.out.println("Task started");
                Thread.sleep(5000);
                System.out.println("Task completed");
            } catch (InterruptedException e) {
                System.out.println("Task interrupted");
            }
        });

        executor.shutdown();
        System.out.println("shutdown() called");
        System.out.println("Main thread exits, task continues...");
    }

    // ----------------------------
    // 2. awaitTermination()
    // ----------------------------
    private static void awaitTerminationDemo() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        executor.submit(() -> {
            try {
                System.out.println("Long task started");
                Thread.sleep(5000);
                System.out.println("Long task completed");
            } catch (InterruptedException e) {
                System.out.println("Long task interrupted");
            }
        });

        executor.shutdown();
        System.out.println("shutdown() called");

        System.out.println("Main thread waiting for 2 seconds...");
        boolean terminated = executor.awaitTermination(2, TimeUnit.SECONDS);

        System.out.println("Is executor fully terminated? " + terminated);
        System.out.println("Main thread continues...");
    }

    // ----------------------------
    // 3. shutdownNow()
    // ----------------------------
    private static void shutdownNowDemo() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        executor.submit(() -> {
            try {
                System.out.println("Task started");
                Thread.sleep(10000);
                System.out.println("Task completed normally");
            } catch (InterruptedException e) {
                System.out.println("Task interrupted by shutdownNow()");
            }
        });

        Thread.sleep(1000);

        List<Runnable> waitingTasks = executor.shutdownNow();
        System.out.println("shutdownNow() called");
        System.out.println("Waiting tasks returned: " + waitingTasks.size());
    }
}
