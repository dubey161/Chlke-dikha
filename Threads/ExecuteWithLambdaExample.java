package Threads;

import java.util.concurrent.*;

public class ExecuteWithLambdaExample {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2,
            4,
            10, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(2)
        );

        for (int i = 1; i <= 6; i++) {
            int taskId = i;

            executor.execute(() -> {
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

        /*
        /What this really is (behind the scenes)
executor.execute(new Runnable() {
    @Override
    public void run() {
        // same code
    }
});
         */
        executor.shutdown();
    }
}
