package coursera.stack;

public class ResizingArrayStack<T> implements Stack<T> {

    private T[] s;
    private int N = 0;

    public ResizingArrayStack() {
        s = (T[]) new Object[1];
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public void push(T item) {
        if (N == s.length)
            resize(2 * s.length);
        s[N++] = item;
    }

    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];
        for (int i = 0; i < N; i++)
            copy[i] = s[i];
        s = copy;
    }

    @Override
    public T pop() {
        T item = s[--N];
        s[N] = null;
        if (N > 0 && N == s.length/4)
            resize(s.length/2);
        return item;
    }


}
