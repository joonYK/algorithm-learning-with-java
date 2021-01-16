package coursera.queues;

public interface QueueOfStrings {

    boolean isEmpty();

    void enqueue(String item);

    String dequeue();
}
