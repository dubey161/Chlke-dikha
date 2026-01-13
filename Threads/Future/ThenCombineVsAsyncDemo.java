package Threads.Future;

import java.util.concurrent.*;

public class ThenCombineVsAsyncDemo {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        System.out.println("Main Thread: " + Thread.currentThread().getName());

        // Task 1 → returns Integer
        CompletableFuture<Integer> task1 =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("Task1 Thread: " +
                            Thread.currentThread().getName());
                    sleep(2);
                    return 10;
                }, executor);

        // Task 2 → returns String
        CompletableFuture<String> task2 =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("Task2 Thread: " +
                            Thread.currentThread().getName());
                    sleep(1);
                    return "K";
                }, executor);

        // 🔹 thenCombine (SAME THREAD)
        CompletableFuture<String> combined =
                task1.thenCombine(task2, (num, str) -> {
                    System.out.println("thenCombine Thread: " +
                            Thread.currentThread().getName());
                    return num + str;
                });

        // 🔹 thenCombineAsync (NEW THREAD)
        CompletableFuture<String> combinedAsync =
                task1.thenCombineAsync(task2, (num, str) -> {
                    System.out.println("thenCombineAsync Thread: " +
                            Thread.currentThread().getName());
                    return num + str;
                }, executor);

        System.out.println("thenCombine RESULT = " + combined.get());
        System.out.println("thenCombineAsync RESULT = " + combinedAsync.get());

        executor.shutdown();
    }

    private static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
