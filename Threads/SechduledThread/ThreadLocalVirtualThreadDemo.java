//package Threads.SechduledThread;
//
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class ThreadLocalVirtualThreadDemo {
//
//    public static void main(String[] args) {
//
//        ExecutorService executor =
//                Executors.newVirtualThreadPerTaskExecutor();
//
//        ThreadLocal<String> threadLocal = new ThreadLocal<>();
//
//        executor.submit(() -> {
//            threadLocal.set("Task-1 Data");
//            System.out.println(
//                    "Set by: " + Thread.currentThread()
//            );
//        });
//
//        for (int i = 0; i < 6; i++) {
//            executor.submit(() -> {
//                System.out.println(
//                        Thread.currentThread() +
//                        " -> " + threadLocal.get()
//                );
//            });
//        }
//
////        executor.shutdown();
//    }
//}


/*

/ Short Answer (Interview-ready)

✅ YES —
ThreadLocal behavior and output remain the SAME for platform threads and virtual threads.

❌ NO —
Virtual threads do not change ThreadLocal semantics.

👉 The only difference is how threads are mapped to OS threads internally, which does NOT affect ThreadLocal output.

1️⃣ Core Rule (Very Important)

ThreadLocal is bound to the Java Thread object — NOT to OS threads.

Whether that Java thread is:

a platform thread, or

a virtual thread

👉 ThreadLocal works exactly the same.

2️⃣ Correcting Your Code (Important)

You wrote:

ExecutorService executor = Executors.newFixedThreadPool(2); // here use virtualthread


⚠️ This does NOT create virtual threads

❌ Wrong (Platform Threads)
Executors.newFixedThreadPool(2);

✅ Correct (Virtual Threads)
Executors.newVirtualThreadPerTaskExecutor();

3️⃣ Your Code — Corrected for Virtual Threads
ExecutorService executor =
        Executors.newVirtualThreadPerTaskExecutor();

ThreadLocal<String> threadLocal = new ThreadLocal<>();

executor.submit(() -> {
    try {
        threadLocal.set("Task-1 Data");
        System.out.println("Set done by: " + Thread.currentThread());
    } finally {
        threadLocal.remove(); // CLEANUP
    }
});

for (int i = 0; i < 10; i++) {
    executor.submit(() -> {
        System.out.println(
            Thread.currentThread() + " -> " + threadLocal.get()
        );
    });
}

4️⃣ What Will Be the Output?
Output (Example)
Set done by: VirtualThread[#21]
VirtualThread[#22] -> null
VirtualThread[#23] -> null
VirtualThread[#24] -> null
VirtualThread[#25] -> null

✅ Observations

Each task runs on a different virtual thread

Only the first virtual thread sets the value

All others print null

Same behavior as platform threads

5️⃣ Why Output Is the Same (Key Explanation)
Because:

ThreadLocal stores data in:

Thread → ThreadLocalMap → value


Each Java Thread object has its own map

Virtual thread is still a Thread

✔ Virtual thread ≠ shared ThreadLocal
✔ Each virtual thread has its own ThreadLocal storage

6️⃣ The REAL Difference (Internal Only)
Aspect	Platform Thread	Virtual Thread
ThreadLocal behavior	Same	Same
Java Thread object	Yes	Yes
OS thread mapping	1:1	Many:Few
Blocking behavior	Blocks OS	OS freed
Scalability	Limited	Massive

👉 ThreadLocal does not care about OS threads at all

7️⃣ Important Subtle Point 🔥
Platform Thread Pool
Executors.newFixedThreadPool(2);


Threads are reused

ThreadLocal cleanup is CRITICAL

Virtual Thread Executor
Executors.newVirtualThreadPerTaskExecutor();


Each task gets a new virtual thread

Thread dies after task

ThreadLocal is auto-cleaned

👉 ThreadLocal leaks are MUCH less likely with virtual threads

8️⃣ Interview Gold Answer 🏆

Virtual threads do not change ThreadLocal behavior. ThreadLocal is associated with
the Java Thread object, and virtual threads are still threads. The difference is only
 in how JVM schedules threads onto OS threads, not in ThreadLocal semantics.


 | Feature    | Platform Thread  | Virtual Thread     |
| ---------- | ---------------- | ------------------ |
| Mapping    | 1 Java : 1 OS    | Many Java : Few OS |
| Creation   | Expensive        | Very cheap         |
| Blocking   | Blocks OS thread | OS thread released |
| Managed by | OS + JVM         | JVM only           |
| Throughput | Limited          | Very high          |


 */
package Threads.SechduledThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalVirtualThreadDemo {

    public static void main(String[] args) {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        try (ExecutorService executor =
                     Executors.newVirtualThreadPerTaskExecutor()) {

            executor.submit(() -> {
                threadLocal.set("Task-1 Data");
                System.out.println(
                        "Set by: " + Thread.currentThread()
                );
            });

            for (int i = 0; i < 6; i++) {
                executor.submit(() -> {
                    System.out.println(
                            Thread.currentThread() +
                                    " -> " + threadLocal.get()
                    );
                });
            }
        } // waits for all submitted tasks to finish
    }
}
