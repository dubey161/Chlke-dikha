package Threads.ThreadExecutor;

import java.util.concurrent.*;

public class RunnableDefaultNaming {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2,                              // core threads
            4,                              // max threads
            10,                             // keep alive time
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(2)     // task queue size = 2
        );

        // Submitting 6 tasks
        for (int i = 1; i <= 6; i++) {
            int taskId = i;
            executor.execute(new MyRunnableTask(taskId));
        }

        executor.shutdown();
    }
}

/* Runnable task */
class MyRunnableTask implements Runnable {

    private int taskId;

    MyRunnableTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println(
            "Task " + taskId +
            " executed by " +
            Thread.currentThread().getName()
        );

        try {
            Thread.sleep(3000); // simulate work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


/*

/🖥 Sample Output
Task 1 executed by pool-1-thread-1
Task 2 executed by pool-1-thread-2
Task 3 executed by pool-1-thread-1
Task 4 executed by pool-1-thread-2
Task 5 executed by pool-1-thread-3
Task 6 executed by pool-1-thread-4


🧠 Notes:

Default names → pool-1-thread-x

Runnable = task

Executor = thread manager
 */