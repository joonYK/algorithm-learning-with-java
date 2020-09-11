package doIt.ch06.practice;

import java.util.Scanner;

/**
 * 비교, 교환 과정을 자세히 출력하면서 버블정렬하는 프로그램을 작성.
 * 비교하는 두 요소 사이에 교환을 수행하면 '+', 수행하지 않으면 '-'를 출력.
 * 정렬을 마치면 비교 횟수와 교환 횟수를 출력
 *
 * 패스1:
 *  6   4   3   7   1   9 + 8
 *  6   4   3   7   1 - 9   8
 *  6   4   3   7 + 1   9   8
 *  6   4   3 + 1   7   9   8
 *  6   4 + 1 + 3   7   9   8
 *  6 + 1   4   3   7   9   8
 *  1   6   4   3   7   9   8
 *
 *  패스2:
 *  1   6   4   3   7   8 - 9
 *  '''중략'''
 *  비교를 21회 했습니다.
 *  교환을 8회 했습니다.
 */
public class Q_06_02 {
    // a[idx1]와 a[idx2]의 값을 바꾼다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 버블 정렬
    static void bubbleSort(int[] a, int n) {
        int comparisonCnt = 0;
        int exchangeCnt = 0;

        for (int i = 0; i < n - 1; i++) {
            System.out.printf("\n패스%d:\n", i+1);

            for (int j = n - 1; j > i; j--) {
                comparisonCnt++;
                if (a[j - 1] > a[j]) {
                    print(a, j - 1, '+');
                    swap(a, j - 1, j);
                    exchangeCnt++;
                } else
                    print(a, j - 1, '-');
            }

            for (int k : a)
                System.out.printf("%-4d", k);
        }

        System.out.println("비교를 " + comparisonCnt + "회 했습니다.");
        System.out.println("교환을 " + exchangeCnt + "회 했습니다.");
    }

    static void print(int[] a, int index, char c) {
        for (int i = 0; i < a.length; i++) {
            if(i == index)
                System.out.printf("%d %c ", a[i], c);
            else
                System.out.printf("%-4d", a[i]);
        }
        System.out.println();
    }

    // 답안지의 답
    static void bubbleSort2(int[] a, int n) {
        int ccnt = 0; // 비교횟수
        int scnt = 0; // 교환횟수

        for (int i = 0; i < n - 1; i++) {
            System.out.printf("패스%d：\n", i + 1);
            for (int j = n - 1; j > i; j--) {
                for (int m = 0; m < n - 1; m++)
                    System.out.printf("%3d %c", a[m], (m != j - 1) ? ' ' : (a[j - 1] > a[j]) ? '+' : '-');
                System.out.printf("%3d\n", a[n - 1]);

                ccnt++;
                if (a[j - 1] > a[j]) {
                    scnt++;
                    swap(a, j - 1, j);
                }
            }
            for (int m = 0; m < n; m++)
                System.out.printf("%3d  ", a[m]);
            System.out.println();
        }
        System.out.println("비교를 " + ccnt + "회 했습니다.");
        System.out.println("교환를 " + scnt + "회 했습니다.");
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬(버전 1)");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("X[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        bubbleSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("X[" + i + "]=" + x[i]);
        }
    }
}
