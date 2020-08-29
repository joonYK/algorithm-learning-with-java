package doIt.ch04.practice;

import java.util.Scanner;

/**
 * 임의의 객체형 데이터를 쌓아 놓을 수 있는 제네릭 큐 클래스 Gqueue<E>를 작성.
 */
public class Q_04_06 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Gqueue<String> s = new Gqueue<>(10);  //최대 10개를 인큐할 수 있는 큐

        while (true) {
            System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());
            System.out.print("(1)인큐 (2)디큐 (3)피크 (4)덤프 (0)종료 : ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            String x;
            switch (menu) {
                case 1: // 인큐
                    System.out.print("데이터：");
                    x = stdIn.next();
                    try {
                        s.enque(x);
                    } catch (OverflowGqueueException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;

                case 2: // 디큐
                    try {
                        x = s.deque();
                        System.out.println("디큐한 데이터는 " + x + "입니다.");
                    } catch (EmptyGqueueException e) {
                        System.out.println("큐가 비었습니다.");
                    }
                    break;

                case 3: // 피크
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (EmptyGqueueException e) {
                        System.out.println("큐가 비었습니다.");
                    }
                    break;

                case 4: // 덤프
                    s.dump();
                    break;
            }
        }
    }
}

//실행 시 예외 : 큐가 비어 있음
class EmptyGqueueException extends RuntimeException {
    public EmptyGqueueException() {}
}

//실행 시 예외 : 큐가 가득 참
class OverflowGqueueException extends RuntimeException {
    public OverflowGqueueException() {}
}

class Gqueue<E> {
    private int max;    //큐의 용량
    private int num;    //현재 데이터 수
    private int front;  //프런트 요소 커서
    private int rear;   //리어 요소 커서
    private E[] que;    //큐의 본체

    public Gqueue(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            que = (E[]) new Object[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    //큐에 데이터 삽입
    public void enque(E x) throws OverflowGqueueException {
        if(num >= max)
            throw new OverflowGqueueException();

        que[rear++] = x;
        num++;
        if (rear == max)
            rear = 0;
    }

    //큐에서 front의 데이터 꺼냄
    public E deque() throws EmptyGqueueException {
        if(num <= 0)
            throw new EmptyGqueueException();

        E x = que[front++];
        num--;

        if(front == max)
            front = 0;

        return x;
    }


    //큐에서 데이터를 피크 (프런트 데이터를 들여다봄)
    public E peek() throws EmptyGqueueException {
        if (num <= 0)
            throw new EmptyGqueueException();
        return que[front];
    }

    //큐에서 x를 검색하여 인덱스(찾지 못하면 -1)를 반환
    public int indexOf(E x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % max;
            if (que[idx] == x || que[idx].equals(x))
                return idx;
        }
        return -1;
    }

    // 큐를 비움
    public void clear() {
        num = front = rear = 0;
    }

    // 큐의 용량을 반환
    public int capacity() {
        return max;
    }

    // 큐에 쌓인 데이터 수를 반환
    public int size() {
        return num;
    }

    // 큐가 비어 있는가?
    public boolean isEmpty() {
        return num <= 0;
    }

    // 큐가 가득 찼는가?
    public boolean isFull() {
        return num >= max;
    }

    // 큐 안의 데이터를 머리→꼬리의 차례로 출력함
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
