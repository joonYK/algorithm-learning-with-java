package doIt.ch05.practice;

import java.util.Scanner;
import java.util.Stack;

/**
 * 실습 5-6의 move 메서드를 비재귀적으로 수정.
 */
public class Q_05_07 {
    //no개의 원반을 x번 기둥에서 y번 기둥으로 옮김
    static void move(int no, int x, int y) {
        if (no > 1)
            move(no - 1, x, 6 - x - y);

        System.out.println("원반[" + no + "]을 " + x + "기둥에서 " + y + "기둥으로 옮김");

        if (no > 1)
            move(no - 1, 6 - x - y, y);
    }

    static class MoveInfo {
        int no, x, y, sw;
        public MoveInfo(int no, int x, int y) {
            this.no = no;
            this.x = x;
            this.y = y;
        }
    }

    //no개의 원반을 x번 기둥에서 y번 기둥으로 옮김
    static void norecur_move(int no, int x, int y) {
        Stack<MoveInfo> stack = new Stack<>();

        while (true) {
            while (true) {
                stack.push(new MoveInfo(no, x, y));
                if(no > 1) {
                    no = no - 1;
                    y = 6 - x - y;

                } else {
                    break;
                }
            }

            while (true) {
                MoveInfo moveInfo = stack.pop();

                System.out.println("원반[" + moveInfo.no + "]을 " + moveInfo.x + "기둥에서 " + moveInfo.y + "기둥으로 옮김");

                if (moveInfo.no > 1) {
                    no = moveInfo.no - 1;
                    x = 6 - moveInfo.x - moveInfo.y;
                    y = moveInfo.y;
                    break;
                }

                if (stack.isEmpty())
                    return;
            }
        }
    }

    //답안지의 답
    static void norecur_move_answer(int no, int x, int y) {
        int[] xstk = new int[100];
        int[] ystk = new int[100];
        int[] sstk = new int[100]; // 스택
        int ptr = 0; // 스택 포인터
        int sw = 0;

        while (true) {
            if (sw == 0 && no > 1) {
                xstk[ptr] = x; // x의 값을 푸시
                ystk[ptr] = y; // y의 값을 푸시
                sstk[ptr] = sw; // sw의 값을 푸시
                ptr++;
                no = no - 1;
                y = 6 - x - y;
                continue;
            }

            System.out.printf("[%d]를 %d기둥에서 %d기둥으로 옮김\n", no, x, y);

            if (sw == 1 && no > 1) {
                xstk[ptr] = x; // x의 값을 푸시
                ystk[ptr] = y; // y의 값을 푸시
                sstk[ptr] = sw; // sw의 값을 푸시
                ptr++;
                no = no - 1;
                x = 6 - x - y;
                if (++sw == 2)
                    sw = 0;
                continue;
            }
            do {
                if (ptr-- == 0) // 스택이 텅 빔
                    return;
                x = xstk[ptr]; // 값을 저장하고 있는 x를 팝
                y = ystk[ptr]; // 값을 저장하고 있는 y를 팝
                sw = sstk[ptr] + 1; // 값을 저장하고 있는 sw를 팝
                no++;
            } while (sw == 2);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반 개수 : ");
        int n = stdIn.nextInt();

        System.out.println("재귀");
        move(n, 1, 3);

        System.out.println("---------------");
        System.out.println();

        System.out.println("비재귀");
        norecur_move(n, 1, 3);
    }
}
