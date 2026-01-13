package Threads.benifitoflockoverWait;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BufferLock {
    private int item;
    private boolean available = false;

    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public void produce(int value) throws InterruptedException {
        lock.lock();
        try {
            while (available) {
                System.out.println("Producer waiting (buffer full)");
                notFull.await();
            }
            item = value;
            available = true;
            System.out.println("Produced: " + item);
            notEmpty.signal(); // wake ONLY consumer
        } finally {
            lock.unlock();
        }
    }

    public void consume() throws InterruptedException {
        lock.lock();
        try {
            while (!available) {
                System.out.println("Consumer waiting (buffer empty)");
                notEmpty.await();
            }
            System.out.println("Consumed: " + item);
            available = false;
            notFull.signal(); // wake ONLY producer
        } finally {
            lock.unlock();
        }
    }
}

class ProducerLock implements Runnable {
    private final BufferLock buffer;

    ProducerLock(BufferLock buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.produce(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {}
    }
}

class ConsumerLock implements Runnable {
    private final BufferLock buffer;

    ConsumerLock(BufferLock buffer) {
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                buffer.consume();
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {}
    }
}

public class LockConditionDemo {
    public static void main(String[] args) {
        BufferLock buffer = new BufferLock();

        new Thread(new ProducerLock(buffer)).start();
        new Thread(new ConsumerLock(buffer)).start();
    }
}
