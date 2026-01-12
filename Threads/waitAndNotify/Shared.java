package Threads.waitAndNotify;

class Shared {
    boolean done = false;

    synchronized void waitForWork() {
        while (!done) {
            notify();   // ❌ DOES NOTHING
        }
        System.out.println("Work completed");
    }

    synchronized void doWork() {
        done = true;
        notify();       // ❌ nobody is waiting
    }
}
