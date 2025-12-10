package collections;

// SIMPLE LINKEDLIST QUEUE
public class MyLinkedListQueue<T> implements MyQueue<T> {

    // Node
    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    private Node<T> head = null, tail = null;
    private int size = 0;

    @Override
    public void offer(T element) {
        Node<T> node = new Node<>(element);
        if (tail == null) head = tail = node;
        else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    @Override
    public T poll() {
        if (head == null) return null;
        T val = head.data;
        head = head.next;
        if (head == null) tail = null;
        size--;
        return val;
    }

    @Override
    public T peek() {
        return (head == null) ? null : head.data;
    }

    @Override
    public boolean add(T element) {
        offer(element);
        return true;
    }

    @Override
    public int size() { return size; }

    @Override
    public MyIterator<T> iterator() {
        return new MyIterator<T>() {
            Node<T> curr = head;
            public boolean hasNext() { return curr != null; }
            public T next() { T v = curr.data; curr = curr.next; return v; }
        };
    }
}
