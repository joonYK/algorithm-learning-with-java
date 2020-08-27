package doIt.ch04.practice;

import doIt.ch04.IntStack;

import java.util.Scanner;

public class Q_04_02 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Gstack<Character> s = new Gstack<>(64);

        while (true) {
            System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());
            System.out.print("(1)푸시 (2)팝 (3)피크 (4)덤프 (0)종료 : ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            char x;
            switch (menu) {
                case 1:
                    System.out.print("데이터 : ");
                    x = stdIn.next().charAt(0);
                    try {
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        x = s.pop();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 3:
                    try {
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 4:
                    s.dump();
                    break;
            }
        }
    }
}

//실행 시 예외 : 스택이 비어 있음
class EmptyIntStackException extends RuntimeException {
    public EmptyIntStackException() {}
}

//실행 시 예외 : 스택이 가득 참
class OverflowIntStackException extends RuntimeException {
    public OverflowIntStackException() {}
}

class Gstack<E> {
    private int max;
    private int ptr;
    private E [] stk;

    //생성자
    public Gstack(int capacity) {
        ptr = 0;
        max = capacity;
        try {
            stk = (E[]) new Object[max];
        } catch (OutOfMemoryError e) {
            max = 0;
        }
    }

    //스택에 x를 푸시
    public E push(E x) throws OverflowIntStackException {
        if (ptr >= max)
            throw new OverflowIntStackException();
        return stk[ptr++] = x;
    }

    //스택에서 데이터를 팝
    public E pop() throws EmptyIntStackException {
        if (ptr <= 0)
            throw new EmptyIntStackException();
        return stk[--ptr];
    }

    //스택에서 데이터를 피크(정상에 있는 데이터를 들여다봄)
    public E peek() throws EmptyIntStackException {
        if (ptr <= 0)
            throw new EmptyIntStackException();
        return stk[ptr - 1];
    }

    //스택에서 x를 찾아 인덱스 반환 (없으면 -1)
    public int indexOf(E x) {
        for (int i = ptr-1; i >= 0; i--)
            if (stk[i] == x || stk[i].equals(x))
                return i;

        return -1;
    }

    //스냍ㄱ을 비움
    public void clear() {
        ptr = 0;
    }

    //스택의 용량을 반환
    public int capacity() {
        return max;
    }

    //스택에 쌓여 있는 데이터 수를 반환
    public int size() {
        return ptr;
    }

    //스택이 비어있는지
    public boolean isEmpty() {
        return ptr <= 0;
    }

    //스택이 가득 찼는지
    public boolean isFull() {
        return ptr >= max;
    }

    //스택 안의 모든 데이터를 바닥 -> 꼭대기 순서르 출력
    public void dump() {
        if (ptr <= 0)
            System.out.println("스택이 비어 있습니다.");
        else {
            for (int i = 0; i < ptr; i++)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }
}
