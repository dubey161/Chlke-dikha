package Threads;

import java.util.concurrent.*;

public class SubmitWithLambdaExample {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2,                          // corePoolSize
            4,                          // maxPoolSize
            10, TimeUnit.SECONDS,       // keepAlive
            new ArrayBlockingQueue<>(2) // queue capacity
        );

        for (int i = 1; i <= 6; i++) {
            int taskId = i;

            executor.submit(() -> {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println(
                    "Task " + taskId +
                    " executed by " +
                    Thread.currentThread().getName()
                );
            });
        }

        executor.shutdown();
    }
}
