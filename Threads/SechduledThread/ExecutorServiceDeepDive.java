package Threads.SechduledThread;

import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceDeepDive {

    public static void main(String[] args) throws Exception {

        // =========================
        // 1. shutdown()
        // =========================
        ExecutorService pool1 = Executors.newFixedThreadPool(2);

        pool1.submit(() -> {
            try {
                System.out.println("Task-1 started");
                Thread.sleep(5000);
                System.out.println("Task-1 completed");
            } catch (InterruptedException e) {
                System.out.println("Task-1 interrupted");
            }
        });

        pool1.shutdown();
        System.out.println("shutdown() called");

        // pool1.submit(() -> System.out.println("New Task")); // ❌ RejectedExecutionException

        // =========================
        // 2. awaitTermination()
        // =========================
        ExecutorService pool2 = Executors.newFixedThreadPool(1);

        pool2.submit(() -> {
            try {
                System.out.println("Long task started");
                Thread.sleep(5000);
                System.out.println("Long task completed");
            } catch (InterruptedException e) {
                System.out.println("Long task interrupted");
            }
        });

        pool2.shutdown();

        boolean terminated = pool2.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("Is pool2 terminated? " + terminated);

        // =========================
        // 3. shutdownNow()
        // =========================
        ExecutorService pool3 = Executors.newFixedThreadPool(1);

        pool3.submit(() -> {
            try {
                System.out.println("Task running");
                Thread.sleep(15000);
                System.out.println("Task finished normally");
            } catch (InterruptedException e) {
                System.out.println("Task interrupted via shutdownNow");
            }
        });

        List<Runnable> waitingTasks = pool3.shutdownNow();
        System.out.println("Waiting tasks count: " + waitingTasks.size());

        // =========================
        // 4. ScheduledExecutorService
        // =========================
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // 4.1 schedule Runnable
        scheduler.schedule(() ->
                System.out.println("Delayed task executed"),
                3, TimeUnit.SECONDS
        );

        // 4.2 schedule Callable
        ScheduledFuture<String> future = scheduler.schedule(() ->
                "Callable result",
                4, TimeUnit.SECONDS
        );

        System.out.println("Callable returned: " + future.get());

        // 4.3 scheduleAtFixedRate
        ScheduledFuture<?> fixedRateTask =
                scheduler.scheduleAtFixedRate(() -> {
                    try {
                        System.out.println("Fixed Rate Task Start");
                        Thread.sleep(6000);
                        System.out.println("Fixed Rate Task End");
                    } catch (InterruptedException e) {
                        System.out.println("Fixed Rate Interrupted");
                    }
                }, 1, 3, TimeUnit.SECONDS);

        Thread.sleep(10000);
        fixedRateTask.cancel(true);

        // 4.4 scheduleWithFixedDelay
        ScheduledFuture<?> fixedDelayTask =
                scheduler.scheduleWithFixedDelay(() -> {
                    try {
                        System.out.println("Fixed Delay Task Start");
                        Thread.sleep(6000);
                        System.out.println("Fixed Delay Task End");
                    } catch (InterruptedException e) {
                        System.out.println("Fixed Delay Interrupted");
                    }
                }, 1, 3, TimeUnit.SECONDS);

        Thread.sleep(10000);
        fixedDelayTask.cancel(true);
//        Why is this used?
//fixedRateTask.cancel(true);
//
//Short answer
//
//To stop a repeatedly scheduled task (scheduleAtFixedRate) from running forever.

        scheduler.shutdown();
    }
}
