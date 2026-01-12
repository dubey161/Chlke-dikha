package Threads.waitAndNotify;

public class Demo {
    public static void main(String[] args) {
        Shared s = new Shared();

        new Thread(s::waitForWork).start();
        new Thread(s::doWork).start();
    }
}
/*

/🔴 What happens?
Thread A enters waitForWork()
done = false
notify() → useless
LOOP FOREVER holding lock
Thread B can NEVER enter doWork()


❌ Program hangs
❌ notify does nothing
❌ Thread B is BLOCKED
 */