package Threads.FORKJOINPOOL;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/*
6️⃣ FORK JOIN POOL + RECURSIVE ACTION
📝 NOTES
🔹 Definition

Used when subtasks do not return any result.

 */

public class ForkJoinRecursiveActionNotes {

    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool();

        PrintTask task = new PrintTask(1, 20);

        pool.invoke(task);
    }

    // RecursiveAction does not return value
    static class PrintTask extends RecursiveAction {

        private final int start;
        private final int end;

        PrintTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {

            // Base condition
            if (end - start <= 5) {
                for (int i = start; i <= end; i++) {
                    System.out.println(
                            "Number " + i +
                            " printed by " +
                            Thread.currentThread().getName()
                    );
                }
                return;
            }

            // Split task
            int mid = (start + end) / 2;

            // Fork subtasks
            invokeAll(
                    new PrintTask(start, mid),
                    new PrintTask(mid + 1, end)
            );
        }
    }
}
