package Threads.SechduledThread;


/*

/1️⃣ Why is null printed?
Your Output
Task-1 Data
null
Task-1 Data
null
Task-1 Data
null
Task-1 Data
null
Task-1 Data
null

Your Code
ExecutorService executor = Executors.newFixedThreadPool(2);
ThreadLocal<String> threadLocal = new ThreadLocal<>();

executor.submit(() -> {
    threadLocal.set("Task-1 Data");
});

for (int i = 0; i < 10; i++) {
    executor.submit(() -> {
        System.out.println(threadLocal.get());
    });
}

🔹 Key Rule (Most Important)

ThreadLocal value belongs to the THREAD, not the TASK

🔹 What threads exist here?
Executors.newFixedThreadPool(2);


➡️ Exactly 2 threads are created:

Thread-A
Thread-B

🔹 Step-by-Step Execution
Step 1: First task
executor.submit(() -> {
    threadLocal.set("Task-1 Data");
});


Either Thread-A or Thread-B picks this task

Suppose:

Thread-A → threadLocal = "Task-1 Data"
Thread-B → threadLocal = null

Step 2: Loop submitting 10 tasks

Now these 10 tasks are executed by either Thread-A or Thread-B.

Task	Picked by	threadLocal.get()
1	Thread-A	Task-1 Data
2	Thread-B	null
3	Thread-A	Task-1 Data
4	Thread-B	null
5	Thread-A	Task-1 Data
6	Thread-B	null

✔ Thread-A prints "Task-1 Data"
✔ Thread-B prints null

➡️ That’s why output alternates

🔹 Why NOT all threads have the value?

Because:

Only one thread executed threadLocal.set()

Other thread never set any value

ThreadLocal does not share values

2️⃣ What happens if we call remove()?
🔹 If we DO NOT call remove() ❌

Thread keeps old data forever

When thread is reused → data leakage

Very dangerous in:

Web servers

Thread pools

Security context

🔹 Correct Code (With remove)
ExecutorService executor = Executors.newFixedThreadPool(2);
ThreadLocal<String> threadLocal = new ThreadLocal<>();

executor.submit(() -> {
    try {
        threadLocal.set("Task-1 Data");
        System.out.println("Set done by: " + Thread.currentThread().getName());
    } finally {
        threadLocal.remove(); // CLEANUP
    }
});

for (int i = 0; i < 10; i++) {
    executor.submit(() -> {
        System.out.println(
            Thread.currentThread().getName() + " -> " + threadLocal.get()
        );
    });
}

Output (example)
pool-1-thread-1 -> null
pool-1-thread-2 -> null


✔ No stale data
✔ No memory leak
✔ Safe reuse of threads

🔹 Interview Rule 🔥

Always call ThreadLocal.remove() when using thread pools

3️⃣ What if we want EACH task to have its own value?

ThreadLocal ❌ is NOT for task-based data
It is thread-based

Correct approach:

Pass data explicitly:

executor.submit(() -> {
    String data = "Task data";
    System.out.println(data);
});

4️⃣ Virtual Thread – Definition (Interview Ready)
📌 Definition

Virtual threads are lightweight, JVM-managed threads that are not mapped 1:1 to OS threads and allow millions of concurrent tasks by detaching blocking operations from OS threads.

5️⃣ Platform Thread vs Virtual Thread (Core Difference)
Feature	Platform Thread	Virtual Thread
Mapping	1 Java : 1 OS	Many Java : Few OS
Creation	Expensive	Very cheap
Blocking	Blocks OS thread	OS thread released
Managed by	OS + JVM	JVM only
Throughput	Limited	Very high


9️⃣ Final Interview Takeaways 🔥
ThreadLocal

Value belongs to thread

Not shared

Must call remove()

Dangerous with thread pools if misused

Virtual Threads

JVM managed

Lightweight

Best for I/O heavy workloads

GA from Java 21
 */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalPlatformThreadDemo {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        executor.submit(() -> {
            try {
                threadLocal.set("Task-1 Data");
                System.out.println(
                        "Set by: " + Thread.currentThread().getName()
                );
            } finally {
                threadLocal.remove(); // VERY IMPORTANT
            }
        });

        for (int i = 0; i < 6; i++) {
            executor.submit(() -> {
                System.out.println(
                        Thread.currentThread().getName() +
                        " -> " + threadLocal.get()
                );
            });
        }

        executor.shutdown();
    }
}
