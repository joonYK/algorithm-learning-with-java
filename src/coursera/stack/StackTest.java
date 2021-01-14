package coursera.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    @Test
    @DisplayName("연결 리스트 스택 테스트")
    public void LinkedStackTest() {
        LinkedStackOfStrings stack = new LinkedStackOfStrings();
        stackTest(stack);
    }

    @Test
    @DisplayName("배열 스택 테스트")
    public void arrayStackTest() {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(5);
        stackTest(stack);
    }

    private void stackTest(Stack stack) {

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
