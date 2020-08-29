package doIt.ch04.practice;

import java.util.Scanner;

/**
 * 일반적으로 덱(deck)이라는 양방향 대기열(deque/double ended queue)은 아래처럼 시작과 끝 지점에서
 * 양쪽으로 데이터를 인큐하거나 디큐하는 자료구조. 양방향 대기열을 수현하는 클래스 IntDeque를 작성.
 *
 *      인큐                  인큐
 *      [][][][][][][][][][][][][]
 * 맨앞 <-                      -> 맨끝
 *      디큐                  디큐
 *
 */
public class Q_04_07 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntDequeue s = new IntDequeue(10);  //최대 10개를 인큐할 수 있는 덱

        while (true) {
            System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());
            System.out.print("(1)인큐_앞 (2)디큐_앞 (3)인큐_끝 (4)디큐_끝 (5)피크_앞 (6)피크_끝 (7)덤프 (0)종료 : ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1: // 인큐_앞
                    System.out.print("데이터：");
                    x = stdIn.nextInt();
                    try {
                        s.enqueFront(x);
                    } catch (OverflowDequeException e) {
                        System.out.println("덱이 가득 찼습니다.");
                    }
                    break;

                case 2: // 디큐_앞
                    try {
                        x = s.dequeFront();
                        System.out.println("디큐한 데이터는 " + x + "입니다.");
                    } catch (EmptyDequeException e) {
                        System.out.println("덱이 비었습니다.");
                    }
                    break;

                case 3: // 인큐_끝
                    System.out.print("데이터：");
                    x = stdIn.nextInt();
                    try {
                        s.enqueRear(x);
                    } catch (OverflowDequeException e) {
                        System.out.println("덱이 가득 찼습니다.");
                    }
                    break;

                case 4: // 디큐_끝
                    try {
                        x = s.dequeRear();
                        System.out.println("디큐한 데이터는 " + x + "입니다.");
                    } catch (EmptyDequeException e) {
                        System.out.println("덱이 비었습니다.");
                    }
                    break;

                case 5: // 피크_앞
                    try {
                        x = s.peekFront();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (EmptyGqueueException e) {
                        System.out.println("덱이 비었습니다.");
                    }
                    break;

                case 6: // 피크_뒤
                    try {
                        x = s.peekRear();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (EmptyGqueueException e) {
                        System.out.println("덱이 비었습니다.");
                    }
                    break;

                case 7: // 덤프
                    s.dump();
                    break;
            }
        }
    }
}

class EmptyDequeException extends RuntimeException {
    public EmptyDequeException() {}
}

//실행 시 예외 : 큐가 가득 참
class OverflowDequeException extends RuntimeException {
    public OverflowDequeException() {}
}

class IntDequeue {
    private int max;
    private int num;
    private int front;
    private int rear;
    private int[] que;

    public IntDequeue(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    public void enqueFront(int x) throws OverflowDequeException {
        if(num >= max)
            throw new OverflowDequeException();

        if(--front < 0)
            front = max - 1;

        que[front] = x;
        num++;
    }

    public int dequeFront() throws EmptyDequeException {
        if(num <= 0)
            throw new EmptyDequeException();

        int x = que[front++];
        num--;

        if(front == max)
            front = 0;

        return x;
    }

    public void enqueRear(int x) throws OverflowDequeException {
        if(num >= max)
            throw new OverflowDequeException();

        que[rear++] = x;
        num++;

        if(rear == max)
            rear = 0;
    }

    public int dequeRear() throws EmptyDequeException {
        if(num <= 0)
            throw new EmptyDequeException();

        if(--rear < 0)
            rear = max - 1;

        int x = que[rear];
        num--;

        return x;
    }

    public int peekFront() throws EmptyDequeException {
        if (num <= 0)
            throw new EmptyDequeException();

        return que[front];
    }

    public int peekRear() throws EmptyDequeException {
        if (num <= 0)
            throw new EmptyDequeException();

        return que[rear == 0 ? max - 1 : rear - 1];
    }

    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % max;
            if (que[idx] == x)
                return idx;
        }
        return -1;
    }

    public void clear() {
        num = front = rear = 0;
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= max;
    }

    public void dump() {
        if (num <= 0)

            System.out.println("큐가 비었습니다.");
        else {
            for (int i = 0; i < num; i++)
                System.out.print(que[(i + front) % max] + " ");
            System.out.println();
        }
    }


}
