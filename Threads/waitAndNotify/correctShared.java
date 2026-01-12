package Threads.waitAndNotify;

class correctShared {
    boolean done = false;

    synchronized void waitForWork() throws InterruptedException {
        while (!done) {
            wait();      // 🔥 RELEASES LOCK & SLEEPS
        }
        System.out.println("Work completed");
    }

    synchronized void doWork() {
        done = true;
        notify();
        System.out.println("Notifying done to do his work");
        // 🔔 WAKES waiting thread
    }
}
