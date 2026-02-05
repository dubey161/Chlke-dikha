package Threads.FORKJOINPOOL;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
2️⃣ CACHED THREAD POOL EXECUTOR
📝 NOTES
🔹 Definition

A Cached Thread Pool creates new threads as needed and removes idle threads after 60 seconds.

🔹 Key Characteristics

corePoolSize = 0

maxPoolSize = Integer.MAX_VALUE

No queue (uses SynchronousQueue)

Best for short-lived tasks

🔹 Risk

⚠ Can create too many threads

 */

public class CachedThreadPoolNotes {

    public static void main(String[] args) {

        // Creates threads dynamically
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 1; i <= 8; i++) {
            int taskId = i;

            executor.submit(() -> {
                System.out.println(
                        "Task " + taskId +
                        " handled by " +
                        Thread.currentThread().getName()
                );
            });
        }

        executor.shutdown();
    }
}
