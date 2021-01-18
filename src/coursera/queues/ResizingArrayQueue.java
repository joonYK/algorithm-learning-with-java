package coursera.queues;

public class ResizingArrayQueue<T> implements Queue<T> {

    private T[] q = (T[]) new Object[10];
    private int head = 0;
    private int tail = 0;

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public void enqueue(T item) {
        q[tail++] = item;
        if (tail == q.length) {
            if (tail - head > q.length / 2)
                resize(q.length * 2);
            else
                resize(q.length);
        }

    }

    private void resize(int capacity) {
        T[] copy = (T[]) new Object[capacity];

        for (int i = head; i < tail; i++)
            copy[i - head] = q[i];

        q = copy;
        tail = tail - head;
        head = 0;
    }

    @Override
    public T dequeue() {
        if (isEmpty())
            return null;

        T item = q[head];
        q[head++] = null;

        if (tail - head < q.length / 4)
            resize(q.length/2);

        return item;
    }
}
