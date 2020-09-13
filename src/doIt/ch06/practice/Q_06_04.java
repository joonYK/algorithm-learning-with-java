package doIt.ch06.practice;

import java.util.Scanner;

/**
 * 실습 6-3의 버블 정렬(버전 3)을 연습문제 Q_06_02와 마찬가지로 비교, 교환과정을 자세히 출력.
 */
public class Q_06_04 {

    // a[idx1]와 a[idx2]의 값을 바꾼다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    //버블정렬 (버전 3)
    static void bubbleSort(int[] a, int n) {
        int totalComparisonCnt = 0;
        int totalExchangeCnt = 0;
        int pathOrder = 1;
        int k = 0;  //a[k]보다 앞쪽은 정렬을 마친 상태
        while(k < n - 1) {
            System.out.printf("\n패스%d:\n", pathOrder++);
            int last = n - 1;   //마지막으로 요소를 교환한 위치
            totalComparisonCnt++;

            for (int j = n - 1; j > k; j--) {
                if (a[j - 1] > a[j]) {
                    totalExchangeCnt++;
                    print(a, j - 1, '+');
                    swap(a, j - 1, j);
                    last = j;
                } else
                    print(a, j-1, '-');
            }
            k = last;

            for (int i : a)
                System.out.printf("%-4d", i);
            System.out.println();
        }

        System.out.println("비교를 " + totalComparisonCnt + "회 했습니다.");
        System.out.println("교환을 " + totalExchangeCnt + "회 했습니다.");
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
