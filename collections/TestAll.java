package collections;

public class TestAll {
    public static void main(String[] args) {

        // My custom list
        MyList<Integer> myList = new MyArrayList<>();
        myList.add(10);
        myList.add(20);
        System.out.println("MyList get(1): " + myList.get(1));

        // My custom queue
        MyQueue<String> myQueue = new MyLinkedListQueue<>();
        myQueue.offer("A");
        myQueue.offer("B");
        System.out.println("MyQueue poll(): " + myQueue.poll());

        // Real Java ArrayList
        java.util.List<Integer> list = new java.util.ArrayList<>();
        list.add(5);
        list.add(6);

        // Real Java LinkedList used as Queue
        java.util.Queue<String> q = new java.util.LinkedList<>();
        q.offer("X");
        q.offer("Y");
        System.out.println("Queue poll(): " + q.poll());
    }
}
