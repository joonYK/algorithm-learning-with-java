package coursera.queues;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueueOfStringsTest {

    @Test
    @DisplayName("연결 리스트 String Queue 테스트")
    public void linkedQueueOfStringsTest() {
        //given
        QueueOfStrings queue = new LinkedQueueOfStrings();
        check(queue);
    }

    @Test
    @DisplayName("동적 사이즈 배열 String Queue 테스트")
    public void resizingArrayQueueOfStringsTest() {
        //given
        QueueOfStrings queue = new ResizingArrayQueueOfStrings();
        check(queue);
    }

    private void check(QueueOfStrings queue) {
        //when
        for (int i = 0; i < 15; i++)
            queue.enqueue(String.valueOf(i));

        //then
        for (int i = 0; i < 15; i++)
            assertEquals(queue.dequeue(), String.valueOf(i));
        assertTrue(queue.isEmpty());
    }
}
