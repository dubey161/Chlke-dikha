package Threads.waitAndNotify;

public class correctDemo {
    public static void main(String[] args) {
        correctShared s = new correctShared();

        new Thread(() -> {
            try {
                s.waitForWork();
            } catch (Exception e) {}
        }).start();
        new Thread(s::doWork).start();
    }
}


/*
/
wait() is mandatory because it suspends the thread and releases the lock.
 notify() only wakes threads that are already waiting.
 Without wait(), notify() does nothing and thread coordination fails.
 */