package Threads.FORKJOINPOOL;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/*

4️⃣ WORK STEALING POOL EXECUTOR
📝 NOTES
🔹 Definition

A Work-Stealing Pool improves CPU utilization by allowing idle threads to steal tasks from busy threads.

🔹 Internal Working

Uses ForkJoinPool

Each thread has its own work-stealing deque

Idle threads steal from the back of deque

REAL MENTAL MODEL (Forget ranges → think DEQUES)
Each worker has:
Deque (double-ended queue)

Workers do ONLY 3 things:

Pop task from FRONT (their own deque)

Fork → push new tasks to FRONT

If idle → steal from BACK of someone else

That’s it. No magic. No planner.

🔍 STEP-BY-STEP (VERY SLOW, NO JUMPS)

We start here:

pool.invoke(new StealTask(1, 40));

STEP 1️⃣ Root task enters the pool

One worker (any one) picks it up

Let’s say Worker-1

Worker-1 deque: [ (1–40) ]


Other workers:

Worker-2 deque: [ ]
Worker-3 deque: [ ]
Worker-4 deque: [ ]

STEP 2️⃣ Worker-1 executes (1–40)

Check:

40 - 1 > 5 → must split


Creates:

A = (1–20)
B = (21–40)


Now this is CRITICAL 👇

Code:
left.fork();   // (1–20)
right.fork();  // (21–40)

What fork() ACTUALLY does

➡️ Pushes task into Worker-1’s own deque

Deque becomes:

FRONT → [ (21–40), (1–20) ] ← BACK


⚠️ NO other worker touched this yet

STEP 3️⃣ Who executes next?
Worker-1:

Pops from FRONT

Gets:

(21–40)


Worker-1 deque now:

[ (1–20) ]

Worker-2:

Idle

Looks for work

Finds Worker-1 has tasks

Steals from BACK

💥 Worker-2 steals:

(1–20)


Now:

Worker-1 deque: [ ]
Worker-2 deque: [ (1–20) ]


❗ This is why it LOOKS like Worker-1 got 21–40 and Worker-2 got 1–20

But it was NOT decided upfront.

STEP 4️⃣ Both workers now act INDEPENDENTLY
Worker-1 executing (21–40)
40 - 21 > 5 → split
→ (21–30), (31–40)


Worker-1 deque:

[ (31–40), (21–30) ]

Worker-2 executing (1–20)
20 - 1 > 5 → split
→ (1–10), (11–20)


Worker-2 deque:

[ (11–20), (1–10) ]

STEP 5️⃣ Stealing happens AGAIN 🔥

Worker-3 is idle → steals from BACK

Possible steals:

From Worker-1 → (21–30)

Or from Worker-2 → (1–10)

⚠️ Which one? NOT predictable

Let’s say Worker-3 steals:

(21–30)

STEP 6️⃣ KEY REALIZATION 💡 (THIS IS THE CLICK MOMENT)

❌ There is NO mapping like:
“Worker-1 → 21–40”
“Worker-2 → 1–20”

✔️ Instead:

Tasks float between workers dynamically


Workers:

Execute

Split

Fork

Steal

Repeat

🧠 WHY IT FEELS CONFUSING

Because humans think in:

Thread → owns work


ForkJoin works like:

Work → floats between threads

🔥 SIMPLE ANALOGY (BEST ONE)
Pizza analogy 🍕

Pizza = task (1–40)

Slices = subtasks

Workers = people at table

Rules:

You take slices from your plate (FRONT)

If hungry and plate empty → steal slice from someone else’s plate (BACK)

Nobody pre-assigns slices

🎯 ONE SENTENCE THAT CLEARS EVERYTHING

ForkJoinPool does not assign ranges to threads; threads dynamically execute and steal tasks from deques based on availability.

 */
public class WorkStealingPoolNotes {

    public static void main(String[] args) {

        // Create ForkJoinPool with limited threads
        ForkJoinPool pool = new ForkJoinPool(4);

        System.out.println("Parallelism : " + pool.getParallelism());
        System.out.println("Starting work-stealing demo...\n");

        // Submit root task
        pool.invoke(new StealTask(1, 40));

        pool.shutdown();
    }

    // RecursiveAction → no return value
    static class StealTask extends RecursiveAction {

        private static final int THRESHOLD = 5;

        private final int start;
        private final int end;

        StealTask(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {

            // Base condition
            if (end - start <= THRESHOLD) {

                System.out.println(
                        "Processing range " + start + " - " + end +
                                " by " + Thread.currentThread().getName()
                );

                // Artificial delay to create imbalance
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return;
            }

            // Split unevenly (IMPORTANT for stealing)
            int mid = (start + end) / 2;

            StealTask left = new StealTask(start, mid);
            StealTask right = new StealTask(mid + 1, end);

            // Fork both tasks
            left.fork();
            right.fork();

            // Join both
            left.join();
            right.join();
        }
    }
}