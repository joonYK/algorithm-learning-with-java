package coursera.stack;

public interface Stack<T> extends Iterable<T> {

    boolean isEmpty();

    void push(T item);

    T pop();
}
