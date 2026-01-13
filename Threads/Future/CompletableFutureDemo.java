package Threads.Future;

import java.util.concurrent.*;

public class CompletableFutureDemo {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        System.out.println("Main Thread: " + Thread.currentThread().getName());

        // 1️⃣ supplyAsync
        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(() -> {
                    System.out.println("supplyAsync Thread: " +
                            Thread.currentThread().getName());
                    sleep(2);
                    return "Hello";
                }, executor);

        // 2️⃣ thenApply (same thread)
        CompletableFuture<String> applied =
                future.thenApply(value -> {
                    System.out.println("thenApply Thread: " +
                            Thread.currentThread().getName());
                    return value + " World";
                });

        // 3️⃣ thenApplyAsync (new thread)
        CompletableFuture<String> asyncApplied =
                applied.thenApplyAsync(value -> {
                    System.out.println("thenApplyAsync Thread: " +
                            Thread.currentThread().getName());
                    return value + " !!!";
                }, executor);

        // 4️⃣ thenCompose (dependent async)
        CompletableFuture<String> composed =
                asyncApplied.thenCompose(value ->
                        CompletableFuture.supplyAsync(() -> {
                            System.out.println("thenCompose Thread: " +
                                    Thread.currentThread().getName());
                            return value + " Composed";
                        }, executor)
                );

        // 5️⃣ thenAccept (terminal)
        CompletableFuture<Void> finalStage =
                composed.thenAccept(result -> {
                    System.out.println("thenAccept Thread: " +
                            Thread.currentThread().getName());
                    System.out.println("FINAL RESULT = " + result);
                });

        finalStage.get(); // wait for completion
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
