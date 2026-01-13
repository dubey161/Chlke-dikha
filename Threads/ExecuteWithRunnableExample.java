package Threads;

import java.util.concurrent.*;

public class ExecuteWithRunnableExample {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2,
            4,
            10, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(2)
        );

        for (int i = 1; i <= 6; i++) {
            executor.execute(new MyRunnableTask2(i));
        }

        executor.shutdown();
    }
}

/* Runnable task */
class MyRunnableTask2 implements Runnable {

    private final int taskId;

    MyRunnableTask2(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
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
    }
}
