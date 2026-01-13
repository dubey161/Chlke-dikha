package Threads;

import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int count = 0;
    private final ReentrantLock lock = new ReentrantLock();

    void increment() {
        lock.lock();
        try {
            int temp = count;
            Thread.sleep(1000);
            count = temp + 1;
            System.out.println(Thread.currentThread().getName() +
                               " incremented count to " + count);
        } catch (InterruptedException e) {}
        finally {
            lock.unlock();
        }
    }
}

public class ReentrantLockDemo {
    public static void main(String[] args) {
        Counter counter = new Counter();

        new Thread(counter::increment, "Thread-1").start();
        new Thread(counter::increment, "Thread-2").start();
        new Thread(counter::increment, "Thread-3").start();
    }
}

/*
Thread-1 incremented count to 1
Thread-2 incremented count to 2
Thread-3 incremented count to 3

🧠 EXPLANATION

Only ONE thread can hold lock

Others WAIT

Similar to synchronized, but more flexible

🔑 Key line
ReentrantLock = synchronized with more control
/
 */