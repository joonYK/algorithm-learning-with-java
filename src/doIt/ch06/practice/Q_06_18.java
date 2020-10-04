package doIt.ch06.practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 도수 정렬의 각 단계(for문)에서 배열 a,b,f의 요솟값의 변화를 출력하는 프로그램을 작성.
 */
public class Q_06_18 {
    //도수 정렬(0 이상 max 이하의 값을 입력합니다)
    static void fSort(int[] a, int n, int max) {
        //누적 도수
        int[] f = new int[max + 1];
        //작업용 목적 배열
        int[] b = new int[n];

        System.out.println("\n1단계 도수 분포표 만들기\n");
        for (int i = 0; i < n; i++) {
            f[a[i]]++;
            System.out.printf("a[%d] = %d\n", i, a[i]);
            System.out.printf("f[%d]++\n", a[i]);
            System.out.println("f = " + Arrays.toString(f) + "\n");
        }

        System.out.println("\n2단계 누적도수분포표 만들기\n");
        for (int i = 1; i <= max; i++) {
            f[i] += f[i - 1];
            System.out.printf("f[%d] += f[%d - 1]\n", i, i);
            System.out.println("f = " + Arrays.toString(f) + "\n");
        }

        System.out.println("\n3단계 목적 배열 만들기\n");
        for (int i = n - 1; i >= 0; i--) {
            System.out.println("f = " + Arrays.toString(f));
            b[--f[a[i]]] = a[i];
            System.out.printf("b[--f[a[i]]] = a[i]   =>   b[%d] = %d\n", f[a[i]], a[i]);
            System.out.println("f = " + Arrays.toString(f));
            System.out.println("b = " + Arrays.toString(b) + "\n");
        }

        System.out.println("\n4단계 배열 복사하기\n");
        for (int i = 0; i < n; i++) {
            a[i] = b[i];
            System.out.printf("a[%d] = b[%d]   =>   a[%d] = %d\n", i, i, i, b[i]);
            System.out.println("b = " + Arrays.toString(b));
            System.out.println("a = " + Arrays.toString(a) + "\n");
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("힙 정렬");
        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        for (int i = 0; i < num; i++)
            x[i] = (int)(Math.random() * num) + 1;

        System.out.println("정렬 전 : " + Arrays.toString(x));

        int max = x[0];
        for (int i = 1; i < num; i++)
            if (x[i] > max) max = x[i];

        fSort(x, num, max);

        System.out.println("오름차순으로 정렬했습니다.");
        System.out.println(Arrays.toString(x));
    }
}
