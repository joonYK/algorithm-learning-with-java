package coursera.queues;

public class ResizingArrayQueueOfStrings implements QueueOfStrings {

    private String[] q = new String[10];
    private int head = 0;
    private int tail = 0;

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public void enqueue(String item) {
        q[tail++] = item;
        if (tail == q.length) {
            if (tail - head > q.length / 2)
                resize(q.length * 2);
            else
                resize(q.length);
        }

    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];

        for (int i = head; i < tail; i++)
            copy[i - head] = q[i];

        q = copy;
        tail = tail - head;
        head = 0;
    }

    @Override
    public String dequeue() {
        if (isEmpty())
            return null;

        String item = q[head];
        q[head++] = null;

        if (tail - head < q.length / 4)
            resize(q.length/2);

        return item;
    }
}
