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
