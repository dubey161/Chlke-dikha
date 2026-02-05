package Threads.FORKJOINPOOL;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
3️⃣ SINGLE THREAD EXECUTOR
📝 NOTES
🔹 Definition

Executes tasks one at a time using a single thread.

🔹 Key Characteristics

Only one worker thread

Tasks executed sequentially

Maintains task order
 */

public class SingleThreadExecutorNotes {

    public static void main(String[] args) {

        // Only one thread executes all tasks
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.submit(() -> System.out.println("Task 1"));
        executor.submit(() -> System.out.println("Task 2"));
        executor.submit(() -> System.out.println("Task 3"));

        executor.shutdown();
    }
}
