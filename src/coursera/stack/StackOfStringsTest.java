package coursera.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackOfStringsTest {

    @Test
    @DisplayName("연결 리스트 스택 테스트")
    public void LinkedStackTest() {
        StackOfStrings stack = new LinkedStackOfStrings();
        stackTest(stack);
    }

    @Test
    @DisplayName("고정된 크기의 배열 스택 테스트")
    public void arrayStackTest() {
        StackOfStrings stack = new FixedCapacityStackOfStrings(5);
        stackTest(stack);
    }

    @Test
    @DisplayName("동적으로 크기를 조절하는 배열 스택 테스트")
    public void resizingArrayStackTest() {
        StackOfStrings stack = new ResizingArrayStackOfStrings();
        stackTest(stack);
    }

    private void stackTest(StackOfStrings stack) {

        assertTrue(stack.isEmpty());

        stack.push("a");
        stack.push("b");
        stack.push("c");

        assertFalse(stack.isEmpty());
        assertEquals(stack.pop(), "c");
        assertEquals(stack.pop(), "b");
        assertEquals(stack.pop(), "a");
        assertTrue(stack.isEmpty());
    }
}
