package doIt.ch04.practice;

import doIt.ch04.IntStack;

import java.util.Scanner;

/**
 * 클래스 IntStack의 모든 메서드를 사용하는 프로그램을 작성.
 */
public class Q_04_01 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        IntStack s = new IntStack(64);

        while (true) {
            System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());
            System.out.print("(1)푸시 (2)팝 (3)피크 (4)덤프 (5)초기화 (6)위치찾기 (0)종료 : ");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1:
                    System.out.print("데이터 : ");
                    x = stdIn.nextInt();
                    try {
                        s.push(x);
                        System.out.println(x + " 푸시 되었습니다.");
                        if(s.isFull())
                            System.out.println("스택이 가득 찼습니다.");
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        x = s.pop();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                        if(s.isEmpty())
                            System.out.println("스택의 모든 데이터를 팝 했습니다.");
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

                case 5:
                    s.clear();
                    System.out.println("스택이 초기화 되었습니다.");
                    break;

                case 6:
                    System.out.print("위치를 찾을 데이터 : ");
                    x = stdIn.nextInt();
                    int index = s.indexOf(x);
                    if(index == -1)
                        System.out.println("존재하지 않는 데이터입니다.");
                    else
                        System.out.println(x + "는 " + index + "번지에 있습니다.");
                    break;

            }
        }
    }

}
