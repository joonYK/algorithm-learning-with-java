package doIt.ch04.practice;

import java.util.Scanner;

/**
 * 하나의 배열을 공유하여 2개의 스택을 구현하는 int형 데이터용 스택 클래스 작성.
 * 스택에 저장하는 데이터는 int형 값으로 배열의 처음과 끝을 사용.
 *
 * [][][][][][][][][][][][][][][][][][][][]
 * ------스택A-----      -------스택B------
 * <-바닥   꼭대기->     <-꼭대기      바닥->
 */
public class Q_04_03 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntDoubleStack s = new IntDoubleStack(10); // 최대 10개를 푸시할 수 있는 스택

        while (true) {
            System.out.println("현재 A스택 데이터 수 : " + s.size(IntDoubleStack.StackType.A) + " / " + (s.capacity() - s.size(IntDoubleStack.StackType.B)));
            System.out.println("현재 B스택 데이터 수 : " + s.size(IntDoubleStack.StackType.B) + " / " + (s.capacity() - s.size(IntDoubleStack.StackType.A)));
            System.out.print("(1)푸시 (2)팝 (3)피크 " + "(4)덤프 (5)검색 (6)비움  " + "(7)정보표시 (0)종료：");

            int menu = stdIn.nextInt();
            if (menu == 0)
                break;

            System.out.print("(1)스택A (2)스택B : ");
            byte type = stdIn.nextByte();
            IntDoubleStack.StackType stackType = type == 1 ? IntDoubleStack.StackType.A : IntDoubleStack.StackType.B;

            int x;
            switch (menu) {
                case 1: // 푸시
                    System.out.print("데이터：");
                    x = stdIn.nextInt();
                    try {
                        s.push(stackType, x);
                    } catch (IntDoubleStack.OverflowIntDoubleStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2: // 팝
                    try {
                        x = s.pop(stackType);
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (IntDoubleStack.EmptyIntDoubleStackException e) {
                        System.out.println("스택이 비었습니다.");
                    }
                    break;

                case 3: // 피크
                    try {
                        x = s.peek(stackType);
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntDoubleStack.EmptyIntDoubleStackException e) {
                        System.out.println("스택이 비었습니다.");
                    }
                    break;

                case 4: // 덤프
                    s.dump(stackType);
                    break;

                case 5: // 검색
                    System.out.print("찾는 데이터：");
                    x = stdIn.nextInt();
                    int n = s.indexOf(stackType, x);

                    if (n >= 0)
                        System.out.println(n + "번 째에 있습니다.");
                    else
                        System.out.println("그 데이터가 없습니다.");
                    break;

                case 6: // 비움
                    s.clear(stackType);
                    break;

                case 7: // 정보표시
                    System.out.println("용량：" + s.capacity());
                    System.out.println("데이터 수：" + s.size(stackType));
                    System.out.println("비어 " + (s.isEmpty(stackType) ? "있습니다." : "있지 않습니다."));
                    System.out.println("가득 " + (s.isFull() ? "찼습니다." : "차지 않았습니다."));
                    break;
            }
        }
    }
}

class IntDoubleStack {
    private int max;
    private int ptrA;
    private int ptrB;
    private int[] stk;

    public IntDoubleStack(int capacity) {
        max = capacity;
        ptrA = 0;
        ptrB = max-1;
        stk = new int[max];
    }

    enum StackType {
        A, B
    }

    //실행 시 예외 : 스택이 비어 있음
    public class EmptyIntDoubleStackException extends RuntimeException {
        public EmptyIntDoubleStackException() {}
    }

    //실행 시 예외 : 스택이 가득 참
    public class OverflowIntDoubleStackException extends RuntimeException {
        public OverflowIntDoubleStackException() {}
    }

    public int push(StackType type, int x) {
        if(ptrA > ptrB)
            throw new OverflowIntDoubleStackException();

        if(type == StackType.A)
            return stk[ptrA++] = x;
        else
            return stk[ptrB--] = x;
    }

    public int pop(StackType type) {
        if(type == StackType.A) {
            if(ptrA <= 0)
                throw new EmptyIntDoubleStackException();
            return stk[--ptrA];
        } else {
            if(ptrB >= max)
                throw new EmptyIntDoubleStackException();
            return stk[++ptrB];
        }
    }

    //스택에서 데이터를 피크(정상에 있는 데이터를 들여다봄)
    public int peek(StackType type) throws EmptyIntDoubleStackException {
        if(type == StackType.A) {
            if(ptrA <= 0)
                throw new EmptyIntDoubleStackException();
            return stk[ptrA - 1];
        } else {
            if(ptrB >= max)
                throw new EmptyIntDoubleStackException();
            return stk[ptrB + 1];
        }
    }

    //스택에서 x를 찾아 인덱스 반환 (없으면 -1)
    public int indexOf(StackType type, int x) {
        if(type == StackType.A) {
            for (int i = ptrA-1; i >= 0; i--)
                if (stk[i] == x)
                    return i;
        } else {
            for (int i = ptrB+1; i <= max-1; i++)
                if (stk[i] == x)
                    return i;
        }

        return -1;
    }


    //스택을 비움
    public void clear(StackType type) {
        if(type == StackType.A)
            ptrA = 0;
        else
            ptrB = max-1;
    }

    //스택의 용량을 반환
    public int capacity() {
        return max;
    }

    //스택에 쌓여 있는 데이터 수를 반환
    public int size(StackType type) {
        return type == StackType.A ? ptrA : (max - 1) - ptrB;
    }

    //스택이 비어있는지
    public boolean isEmpty(StackType type) {
        return type == StackType.A ? ptrA <= 0 : ptrB >= max-1;
    }

    //스택이 가득 찼는지
    public boolean isFull() {
        return ptrA > ptrB;
    }

    //스택 안의 모든 데이터를 바닥 -> 꼭대기 순서로 출력
    public void dump(StackType type) {
        if(type == StackType.A) {
            if (ptrA <= 0)
                System.out.println("스택이 비어 있습니다.");
            else {
                for (int i = 0; i < ptrA; i++)
                    System.out.print(stk[i] + " ");
                System.out.println();
            }
        } else {
            if (ptrB >= max-1)
                System.out.println("스택이 비어 있습니다.");
            else {
                for (int i = max-1; i > ptrB; i--)
                    System.out.print(stk[i] + " ");
                System.out.println();
            }
        }


    }


}
