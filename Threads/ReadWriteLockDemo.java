package Threads;

import java.util.concurrent.locks.*;

class Bank {
    private int balance = 100;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    void readBalance() {
        lock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() +
                               " reading balance: " + balance);
            Thread.sleep(2000);
        } catch (InterruptedException e) {}
        finally {
            lock.readLock().unlock();
        }
    }

    void writeBalance() {
        lock.writeLock().lock();
        try {
            balance += 50;
            System.out.println(Thread.currentThread().getName() +
                               " updated balance to: " + balance);
        } finally {
            lock.writeLock().unlock();
        }
    }
}

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        new Thread(bank::readBalance, "Reader-1").start();
        new Thread(bank::writeBalance, "Writer").start();
        new Thread(bank::readBalance, "Reader-2").start();
    }
}

/*
/
Reader-1 reading balance: 100
Reader-2 reading balance: 100
Writer updated balance to: 150
🧠 EXPLANATION (VERY IMPORTANT)

Reader-1 & Reader-2 run together

Writer waits until ALL readers finish

While writer runs → no reader allowed

READ + READ = OK
READ + WRITE = WAIT
WRITE + ANY = WAIT

 */