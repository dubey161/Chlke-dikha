package collections;

// ITERABLE
public interface MyIterable<T> {
    MyIterator<T> iterator();
}

// Iterator used by Iterable
interface MyIterator<T> {
    boolean hasNext();
    T next();
}
