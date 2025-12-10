package collections;

// SIMPLE ARRAYLIST IMPLEMENTATION
public class MyArrayList<T> implements MyList<T> {
    private Object[] data = new Object[10];
    private int size = 0;

    @Override
    public boolean add(T element) {
        data[size++] = element;
        return true;
    }

    @Override
    public T get(int index) {
        return (T) data[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public MyIterator<T> iterator() {
        return new MyIterator<T>() {
            int i = 0;
            @Override public boolean hasNext() { return i < size; }
            @Override public T next() { return (T) data[i++]; }
        };
    }
}
