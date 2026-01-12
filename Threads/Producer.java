package Threads;

class Producer implements Runnable {
    Buffer buffer;

    Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        int i = 0;
        while (Control.running) {
            try {
                buffer.produce(i++);
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}

