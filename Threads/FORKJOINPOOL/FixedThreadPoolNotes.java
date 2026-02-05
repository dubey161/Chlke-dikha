package Threads.FORKJOINPOOL;

/*
/1️⃣ FIXED THREAD POOL EXECUTOR
📝 NOTES
🔹 Definition

A Fixed Thread Pool creates a thread pool with a fixed number of threads.
If all threads are busy, new tasks are placed into a queue.

🔹 Key Characteristics

corePoolSize = maxPoolSize

Threads are reused

Uses unbounded queue

Threads stay alive even when idle

🔹 When to Use

When workload is predictable

When concurrency level must be controlled
 */


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolNotes {

    public static void main(String[] args) {

        // Create a fixed thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit 6 tasks
        for (int i = 1; i <= 6; i++) {
            int taskId = i;

            executor.submit(() -> {

                // Each task prints the thread name executing it
                System.out.println(
                        "Task " + taskId +
                        " executed by " +
                        Thread.currentThread().getName()
                );

                try {
                    Thread.sleep(1000); // Simulate work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        // Gracefully shutdown executor
        executor.shutdown();
    }
}
