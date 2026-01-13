package Threads;

import java.util.concurrent.*;

public class SubmitWithRunnableExample {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2,
            4,
            10, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(2)
        );

        for (int i = 1; i <= 6; i++) {
            executor.submit(new MyRunnableTask(i));
        }

        executor.shutdown();
    }
}

/* Normal Runnable class */
class MyRunnableTask implements Runnable {

    private final int taskId;

    MyRunnableTask(int taskId) {
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
