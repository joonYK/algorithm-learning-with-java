package coursera.queues;

public class LinkedQueue<T> implements Queue<T> {

    private Node first;
    private Node last;

    private class Node {
        T item;
        Node next;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
    }

    @Override
    public T dequeue() {
        T item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        return item;
    }
}
