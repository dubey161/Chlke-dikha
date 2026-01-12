package Threads;

class Consumer implements Runnable {
    Buffer buffer;

    Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (Control.running) {
            try {
                buffer.consume();
                Thread.sleep(1500);
            } catch (InterruptedException e) {}
        }
    }
}

