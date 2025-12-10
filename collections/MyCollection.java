package collections;

// COLLECTION
public interface MyCollection<T> extends MyIterable<T> {
    boolean add(T element);
    int size();
}
