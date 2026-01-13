package Threads;

import java.util.concurrent.Semaphore;

class Washroom {
    private final Semaphore semaphore = new Semaphore(2);

    void useWashroom() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() +
                               " entered washroom");
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() +
                               " exited washroom");
        } catch (InterruptedException e) {}
        finally {
            semaphore.release();
        }
    }
}

public class SemaphoreDemo {
    public static void main(String[] args) {
        Washroom washroom = new Washroom();

        for (int i = 1; i <= 5; i++) {
            new Thread(washroom::useWashroom,
                       "Person-" + i).start();
        }
    }
}

/*
/
Person-1 entered washroom
Person-2 entered washroom

Person-1 exited washroom
Person-3 entered washroom

Person-2 exited washroom
Person-4 entered washroom

Person-3 exited washroom
Person-5 entered washroom

Person-4 exited washroom
Person-5 exited washroom

🧠 EXPLANATION

Semaphore(2) → ONLY 2 threads allowed

Others WAIT

As soon as one exits → next enters

🔑 Key line
Semaphore controls HOW MANY threads can enter


| Lock                 | Allows             | Purpose           |
| -------------------- | ------------------ | ----------------- |
| ReentrantLock        | 1 thread           | Mutual exclusion  |
| ReadWriteLock        | Many read, 1 write | Performance       |
| Semaphore            | N threads          | Resource limiting |
| Optimistic (Stamped) | Read + write       | High concurrency  |



 */