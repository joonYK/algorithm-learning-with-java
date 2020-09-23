package doIt.ch06.practice;

import doIt.ch04.IntStack;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 비재귀적 퀵 정렬 (실습 6-10)을 수정해서 푸시, 팝, 분할 과정을 출력
 */
public class Q_06_11 {
    // a[idx1]와 a[idx2]의 값을 바꾼다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void quickSort(int[] a, int left, int right) {
        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        System.out.println("분할할 범위 PUSH");
        lstack.push(left);
        rstack.push(right);

        print(lstack, rstack, left, right);

        while (!lstack.isEmpty()) {
            int pl = left = lstack.pop();   //왼쪽 커서
            int pr = right = rstack.pop();  //오른쪽 커서
            int x = a[(left + right) / 2];  //피벗

            System.out.println("분할하기 위해 POP");
            print(lstack, rstack, left, right);

            System.out.printf("a[%d] ~ a[%d] 분할 시작.\n\n", left, right);

            do {
                while (a[pl] < x) pl++;
                while (a[pr] > x) pr--;
                if (pl <= pr)
                    swap(a, pl++, pr--);
            } while (pl <= pr);

            //왼쪽 그룹 범위의 인덱스를 푸시
            if (left < pr) {
                lstack.push(left);
                rstack.push(pr);
                System.out.println("분할할 범위 PUSH");
                print(lstack, rstack, left, pr);
            }

            //오른쪽 그룹 범위의 인덱스를 푸시
            if (pl < right) {
                lstack.push(pl);
                rstack.push(right);
                System.out.println("분할할 범위 PUSH");
                print(lstack, rstack, pl, right);
            }

            System.out.printf("a[%d] ~ a[%d] 분할 완료.\n\n", left, right);
        }
    }

    static void print(IntStack lstack, IntStack rstack, int left, int right) {
        System.out.printf("left : %d, right : %d\n", left, right);
        System.out.print("lstack : ");
        lstack.dump();
        System.out.print("rstack : ");
        rstack.dump();
        System.out.println();
    }


    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++)
            x[i] = (int) (Math.random() * nx) + 1;

        System.out.println("정렬 전");
        System.out.println(Arrays.toString(x));
        System.out.println();

        quickSort(x, 0, nx - 1);

        System.out.println("오름차순으로 정렬했습니다.");
        System.out.println(Arrays.toString(x));

    }
}
