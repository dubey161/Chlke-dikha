package Threads.ThreadExecutor;

public class ThreadExtendsExample {

    public static void main(String[] args) {
        MyThread t1 = new MyThread("TVed");
        MyThread t2 = new MyThread("T2Rohit");

        t1.start();
        t2.start();

//        Thread t1 = new Thread(() -> {
//            System.out.println("Running thread: TVed");
//        }, "TVed");
//
//        Thread t2 = new Thread(() -> {
//            System.out.println("Running thread: T2Rohit");
//        }, "T2Rohit");
//
//        t1.start();
//        t2.start();
    }
}

class MyThread extends Thread {

    MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(
            "Running thread: " +
            Thread.currentThread().getName()
        );

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
