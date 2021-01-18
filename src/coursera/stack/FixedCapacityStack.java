package coursera.stack;

import java.util.Iterator;

public class FixedCapacityStack<T> implements Stack<T> {

    private T[] s;
    private int N = 0;

    public FixedCapacityStack(int capacity) {
        s = (T[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void push(T item) {
        s[N++] = item;
    }

    public T pop() {
        T item = s[--N];
        s[N] = null;
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
