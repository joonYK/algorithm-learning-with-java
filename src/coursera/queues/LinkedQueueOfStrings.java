package coursera.queues;

public class LinkedQueueOfStrings implements QueueOfStrings {

    private Node first;
    private Node last;

    private class Node {
        String item;
        Node next;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void enqueue(String item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
    }

    @Override
    public String dequeue() {
        String item = first.item;
        first = first.next;
        if (isEmpty())
            last = null;
        return item;
    }
}
