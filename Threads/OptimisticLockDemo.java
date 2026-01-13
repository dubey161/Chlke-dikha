package Threads;

import java.util.concurrent.locks.StampedLock;

class BankAccount {
    private int balance = 100;
    private final StampedLock lock = new StampedLock();

    // Optimistic Read
    void optimisticRead() {
        long stamp = lock.tryOptimisticRead();   // NO LOCK
        int readBalance = balance;
        System.out.println("Reader read balance = " + readBalance);

        try {
            Thread.sleep(2000); // simulate work
        } catch (InterruptedException e) {}

        // Validate after work
        if (!lock.validate(stamp)) {
            System.out.println("Reader detected WRITE happened → retry");

            // fallback to real read lock
            stamp = lock.readLock();
            try {
                readBalance = balance;
                System.out.println("Reader re-read balance = " + readBalance);
            } finally {
                lock.unlockRead(stamp);
            }
        } else {
            System.out.println("Reader validation SUCCESS");
        }
    }

    // Write
    void write() {
        try {
            Thread.sleep(500); // ensure write happens during read
        } catch (InterruptedException e) {}

        long stamp = lock.writeLock();
        try {
            balance += 50;
            System.out.println("Writer updated balance to " + balance);
        } finally {
            lock.unlockWrite(stamp);
        }
    }
}

public class OptimisticLockDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Thread reader = new Thread(account::optimisticRead);
        Thread writer = new Thread(account::write);

        reader.start();
        writer.start();
    }
}


/*

/🖥️ OUTPUT (EXPECTED)
Reader read balance = 100
Writer updated balance to 150
Reader detected WRITE happened → retry
Reader re-read balance = 150
 */