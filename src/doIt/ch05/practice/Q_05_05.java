package doIt.ch05.practice;

import doIt.ch04.IntStack;

import java.util.Scanner;

/**
 * recur3 메서드를 비재귀적으로 구현.
 *
 * static void recur3(int n)
 *
 */
public class Q_05_05 {
    static void recur3(int n) {
        if (n > 0) {
            recur3(n - 1);
            recur3(n - 2);
            System.out.println(n);
        }
    }

    static void norecur3(int n) {
        IntStack stack1 = new IntStack(100);
        IntStack stack2 = new IntStack(100);
        int sw = 1;

        while (true) {
            if (n > 0) {
                stack1.push(n);
                stack2.push(sw);

                if(sw == 1) {
                    n = n - 1;
                } else {
                    n = n - 2;
                    sw = 1;
                }

                continue;
            }

            do {
                n = stack1.pop();
                sw = stack2.pop();

                if(sw == 2) {
                    System.out.println(n);
                    if (stack1.isEmpty())
                        return;
                }
            } while (sw == 2);

            sw = 2;
        }

    }
    
    // 답안지의 답
    static void norecur3_answer(int n) {
        int[] nstk = new int[100];
        int[] sstk = new int[100];
        int ptr = -1;
        int sw = 0;

        while (true) {
            if (n > 0) {
                ptr++;
                nstk[ptr] = n;
                sstk[ptr] = sw;

                if (sw == 0)
                    n = n - 1;
                else if (sw == 1) {
                    n = n - 2;
                    sw = 0;
                }
                continue;
            }
            do {
                n = nstk[ptr];
                sw = sstk[ptr--] + 1;

                if (sw == 2) {
                    System.out.println(n);
                    if (ptr < 0)
                        return;
                }
            } while (sw == 2);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = stdIn.nextInt();

        System.out.println("recur3");
        recur3(x);
        System.out.println("---------------");

        System.out.println("norecur3");
        norecur3(x);
        System.out.println("---------------");
    }
}
