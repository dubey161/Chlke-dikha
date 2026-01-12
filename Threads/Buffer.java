package Threads;

import java.util.LinkedList;
import java.util.Queue;

class Buffer {
    private Queue<Integer> queue = new LinkedList<>();
    private int capacity = 5;

     synchronized void produce(int item) throws InterruptedException {
        if (queue.size() == capacity) {
            System.out.println("Buffer full ho gya.........., stopping system");
            Control.running = false;
            notifyAll();
            return;
        }
        queue.add(item);
         System.out.println("Producer : "+ item);
        notifyAll();
    }


    synchronized int consume() throws InterruptedException {
        while (queue.isEmpty() && Control.running) {
            wait();
        }
        int item = queue.poll();
        System.out.println("Consumed: " + item);
        notifyAll();
        return item;
    }
}
/*\
I’ll assume:

capacity = 5

Producer is faster than consumer

Consumer sleeps (1500ms)

Producer sleeps (1000ms)

Producer stops when buffer becomes full

Consumer drains remaining items and then stops

Prints are exactly the ones you showed

🔢 EXECUTION FLOW (ASSUMED ORDER)
Producer produces first: 0,1,2,3

Then consumer consumes 0
Then producer produces 4,5
Then producer detects FULL → stops
Then consumer drains remaining items

🖥️ FINAL CONSOLE OUTPUT (IN ORDER)
Producer : 0
Producer : 1
Producer : 2
Producer : 3
Consumed: 0
Producer : 4
Producer : 5
Buffer full ho gya.........., stopping system
Consumed: 1
Consumed: 2
Consumed: 3
Consumed: 4
Consumed: 5

🧠 WHY THIS ORDER MAKES SENSE
✔ Why producer prints first

Producer is faster

Consumer is sleeping

notifyAll() does nothing initially

✔ Why Consumed: 0 appears in between

Consumer wakes after sleep

Polls one item

Producer continues again

✔ Why producer stops after 5

Queue reaches capacity

Control.running = false

Producer returns → thread terminates

✔ Why consumer continues printing

Queue still has items

Consumer drains remaining items

Prints each Consumed:x

✔ Why nothing prints after Consumed: 5

Queue empty

running = false

Consumer exits cleanly

/
 */