package collections;

// QUEUE
public interface MyQueue<T> extends MyCollection<T> {
    void offer(T element);   // insert
    T poll();                // remove
    T peek();                // front
}
