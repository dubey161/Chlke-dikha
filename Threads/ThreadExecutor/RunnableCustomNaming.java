package Threads.ThreadExecutor;

import java.util.concurrent.*;

public class RunnableCustomNaming {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2,
            4,
            10,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(2),

            // Custom ThreadFactory
            r -> {
                Thread t = new Thread(r);
                t.setName("worker-" + t.getId());
                return t;
            },

            // Rejection handler
            (r, ex) -> System.out.println("Task rejected: " + r)
        );

        for (int i = 1; i <= 7; i++) {
            int taskId = i;
            executor.execute(new MyRunnableTask(taskId));
        }

        executor.shutdown();
    }
}

/*

/🖥 Sample Output
Task 1 executed by worker-12
Task 2 executed by worker-13
Task 3 executed by worker-12
Task 4 executed by worker-13
Task 5 executed by worker-14
Task 6 executed by worker-15
Task rejected: java.util.concurrent.FutureTask@4eec7777


🧠 Notes:

Custom names help in logs & debugging

Task 7 rejected because:

2 core threads busy

queue size = 2 full

max threads = 4 reached
 */