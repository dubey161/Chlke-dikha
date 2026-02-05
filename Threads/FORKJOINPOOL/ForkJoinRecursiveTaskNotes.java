package Threads.FORKJOINPOOL;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/*
/5️⃣ FORK JOIN POOL + RECURSIVE TASK
📝 NOTES
🔹 Definition

Used for divide-and-conquer problems where subtasks return a result.

🔹 Methods

fork() → split task

join() → wait and combine result

 */

public class ForkJoinRecursiveTaskNotes {

    public static void main(String[] args) {

        // Common ForkJoinPool
        ForkJoinPool pool = ForkJoinPool.commonPool();

        // Submit task
        SumTask task = new SumTask(1, 100);

        int result = pool.invoke(task);

        System.out.println("Final Sum = " + result);
    }

    // RecursiveTask returns result
    static class SumTask extends RecursiveTask<Integer> {

        private final int start;
        private final int end;

        SumTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {

            // Base condition
            if (end - start <= 10) {
                int sum = 0;
                for (int i = start; i <= end; i++) {
                    sum += i;
                }
                return sum;
            }

            // Split task
            int mid = (start + end) / 2;

            SumTask left = new SumTask(start, mid);
            SumTask right = new SumTask(mid + 1, end);

            // Fork subtasks
            left.fork();
            right.fork();

            // Join results
            return left.join() + right.join();
        }
    }
}
