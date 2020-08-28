package doIt.ch04.practice;

import java.util.Scanner;

/**
 * 배열로 큐 만들기. (디큐하면 1번지부터 차례로 앞으로 옮겨야함)
 * 큐를 구현하는 클래스 IntAryQueue를 작성.
 * 실습 4-3의 메서드에 대응하는 메서드를 모두 작성,
 *
 */
public class Q_04_04 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntAryQueue q = new IntAryQueue(10); // 최대 10개를 인큐할 수 있는 큐

        while (true) {
            System.out.println("현재 데이터 수 : " + q.size() + " / " + q.capacity());
            System.out.print("(1)인큐 (2)디큐 (3)피크 " + "(4)덤프 (5)검색 (6)비움  " + "(7)정보표시 (0)종료：");

            int menu = stdIn.nextInt();
            if (menu == 0)
                break;

            int x;
            switch (menu) {
                case 1: // 인큐
                    System.out.print("데이터：");
                    x = stdIn.nextInt();
                    try {
                        q.enqueue(x);
                    } catch (IntAryQueue.OverflowIntAryQueueException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;

                case 2: // 디큐
                    try {
                        x = q.dequeue();
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

                case 5: // 검색
                    System.out.print("찾는 데이터：");
                    x = stdIn.nextInt();
                    int n = q.indexOf(x);

                    if (n >= 0)
                        System.out.println(n + "번 째에 있습니다.");
                    else
                        System.out.println("그 데이터가 없습니다.");
                    break;

                case 6: // 비움
                    q.clear();
                    break;

                case 7: // 정보표시
                    System.out.println("용량：" + q.capacity());
                    System.out.println("데이터 수：" + q.size());
                    System.out.println("비어 " + (q.isEmpty() ? "있습니다." : "있지 않습니다."));
                    System.out.println("가득 " + (q.isFull() ? "찼습니다." : "차지 않았습니다."));
                    break;
            }
        }
    }
}

class IntAryQueue {
    private int max;    //큐 용량
    private int num;    //현재 데이터 수
    private int[] que;  //큐 본체

    public IntAryQueue(int capacity) {
        max = capacity;
        num = 0;
        que = new int[max];
    }


    //실행 시 예외 : 큐가 비어 있음
    public class EmptyIntAryQueueException extends RuntimeException {
        public EmptyIntAryQueueException() {}
    }

    //실행 시 예외 : 큐가 가득 참
    public class OverflowIntAryQueueException extends RuntimeException {
        public OverflowIntAryQueueException() {}
    }

    //큐에 데이터 삽입
    public int enqueue(int x) {
        if(num >= max)
            throw new OverflowIntAryQueueException();
        return que[num++] = x;
    }

    //큐에서 데이터를 꺼냄
    public int dequeue() {
        if(num <= 0)
            throw new EmptyIntAryQueueException();

        int x = que[0];

        for (int i = 1; i < num; i++)
            que[i-1] = que[i];

        num--;
        return x;
    }

    //큐의 맨 마지막에 넣은 데이터를 peek
    public int peek() throws EmptyIntAryQueueException {
        if(num <= 0)
            throw new EmptyIntAryQueueException();
        return que[num-1];
    }

    //큐에서 x를 찾아 인덱스 반환 (없으면 -1)
    public int indexOf(int x) {
        for (int i = 0; i < num; i++)
                if (que[i] == x)
                    return i;
        return -1;
    }

    //큐를 비움
    public void clear() {
        num = 0;
    }

    //큐의 용량을 반환
    public int capacity() {
        return max;
    }

    //큐에 쌓여 있는 데이터 수를 반환
    public int size() {
        return num;
    }

    //큐가 비어있는지
    public boolean isEmpty() {
        return num <= 0;
    }

    //큐가 가득 찼는지
    public boolean isFull() {
        return num >= max;
    }

    //큐 안의 모든 데이터를 front -> rear 순서로 출력
    public void dump() {
        if (num <= 0)
            System.out.println("큐가 비어 있습니다.");
        else {
            for (int i = 0; i < num; i++)
                System.out.print(que[i] + " ");
            System.out.println();
        }
    }


}
