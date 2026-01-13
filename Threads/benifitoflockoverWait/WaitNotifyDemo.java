package Threads.benifitoflockoverWait;

class BufferWaitNotify {
    private int item;
    private boolean available = false;

    public synchronized void produce(int value) throws InterruptedException {
        while (available) {
            System.out.println("Producer waiting (buffer full)");
            wait();
        }
        item = value;
        available = true;
        System.out.println("Produced: " + item);
        notifyAll(); // wakes ALL threads
    }

    public synchronized void consume() throws InterruptedException {
        while (!available) {
            System.out.println("Consumer waiting (buffer empty)");
            wait();
        }
        System.out.println("Consumed: " + item);
        available = false;
        notifyAll(); // wakes ALL threads
    }
}

class ProducerWN implements Runnable {
    private final BufferWaitNotify buffer;

    ProducerWN(BufferWaitNotify buffer) {
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

class ConsumerWN implements Runnable {
    private final BufferWaitNotify buffer;

    ConsumerWN(BufferWaitNotify buffer) {
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

public class WaitNotifyDemo {
    public static void main(String[] args) {
        BufferWaitNotify buffer = new BufferWaitNotify();

        new Thread(new ProducerWN(buffer)).start();
        new Thread(new ConsumerWN(buffer)).start();
    }
}
