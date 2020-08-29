package doIt.ch04.practice;

import java.util.Scanner;

/**
 * IntQueue에 임의의 데이터를 검색하는 int search(int x)의 메서드를 작성.
 * 메서드를 indexOf처럼 찾은 위치의 배열 인덱스를 반환하는 것이 아니라 큐 안에서 몇 번쨰에 있
 * 는가를 양수(큐의 프런트에 있는 경우는 1로 함)로 반환. 검색에 실패시, 0 반환.
 */
public class Q_04_05 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntQueueS q = new IntQueueS(10); // 최대 10개를 인큐할 수 있는 큐

        while (true) {
            System.out.println("현재 데이터 수 : " + q.size() + " / " + q.capacity());
            System.out.print("(1)인큐 (2)디큐 (3)피크 " + "(4)덤프 (5)인덱스 검색 (6)순서 검색 (7)비움 " + "(8)정보표시 (0)종료：");

            int menu = stdIn.nextInt();
            if (menu == 0)
                break;

            int x;
            switch (menu) {
                case 1: // 인큐
                    System.out.print("데이터：");
                    x = stdIn.nextInt();
                    try {
                        q.enque(x);
                    } catch (IntAryQueue.OverflowIntAryQueueException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;

                case 2: // 디큐
                    try {
                        x = q.deque();
                        System.out.println("디큐한 데이터는 " + x + "입니다.");
                    } catch (IntAryQueue.EmptyIntAryQueueException e) {
                        System.out.println("큐가 비었습니다.");
                    }
                    break;

                case 3: // 피크
                    try {
                        x = q.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntAryQueue.EmptyIntAryQueueException e) {
                        System.out.println("큐가 비었습니다.");
                    }
                    break;

                case 4: // 덤프
                    q.dump();
                    break;

                case 5: // 인덱스검색
                    System.out.print("찾는 데이터：");
                    x = stdIn.nextInt();
                    int index = q.indexOf(x);

                    if (index >= 0)
                        System.out.println(index + "번 째에 있습니다.");
                    else
                        System.out.println("그 데이터가 없습니다.");
                    break;

                case 6: // 순서검색
                    System.out.print("찾는 데이터：");
                    x = stdIn.nextInt();
                    int order = q.search(x);

                    if (order >= 0)
                        System.out.println(order + "번 째에 있습니다.");
                    else
                        System.out.println("그 데이터가 없습니다.");
                    break;

                case 7: // 비움
                    q.clear();
                    break;

                case 8: // 정보표시
                    System.out.println("용량：" + q.capacity());
                    System.out.println("데이터 수：" + q.size());
                    System.out.println("비어 " + (q.isEmpty() ? "있습니다." : "있지 않습니다."));
                    System.out.println("가득 " + (q.isFull() ? "찼습니다." : "차지 않았습니다."));
                    break;
            }
        }
    }
}

class IntQueueS {
    private int max;    //큐의 용량
    private int front;  //첫 번째 요소 커서
    private int rear;   //마지막 요소 커서
    private int num;    //현재 데이터 수
    private int[] que;  //큐 본체

    //실행 시 예외 : 큐가 비어 있음
    public class EmptyIntQueueSException extends RuntimeException {
        public EmptyIntQueueSException() {}
    }

    //실행 시 예외 : 큐가 가득 참
    public class OverflowIntQueueSException extends RuntimeException {
        public OverflowIntQueueSException() {}
    }

    public IntQueueS(int capacity) {
        num = front = rear = 0;
        max = capacity;
        try {
            que = new int[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }


    //큐에 데이터를 인큐
    public int enque(int x) throws OverflowIntQueueSException {
        if (num >= max)
            throw new OverflowIntQueueSException();
        que[rear++] = x;
        num++;
        if(rear == max)
            rear = 0;
        return x;
    }

    //큐에서 데이터를 디큐
    public int deque() throws EmptyIntQueueSException {
        if (num <= 0)
            throw new EmptyIntQueueSException();
        int x = que[front++];
        num--;
        if(front == max)
            front = 0;
        return x;
    }

    //큐에서 데이터를 피크 (프런트 데이터를 들여다봄)
    public int peek() throws EmptyIntQueueSException {
        if (num <= 0)
            throw new EmptyIntQueueSException();
        return que[front];
    }

    //큐에서 x를 검색하여 인덱스(찾지 못하면 -1)를 반환
    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            int idx = (i + front) % max;
            if (que[idx] == x)
                return idx;
        }
        return -1;
    }

    //데이터가 큐의 front부터 번째에 위치하는지 검색.
    public int search(int x) {
        for (int i = 0; i < num; i++)
            if(que[(i + front) % max] == x)
                return i + 1;

        return 0;
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
