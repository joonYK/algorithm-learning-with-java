package doIt.ch06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 도수 정렬
 */
public class Fsort_06_17 {
    //도수 정렬(0 이상 max 이하의 값을 입력합니다)
    static void fSort(int[] a, int n, int max) {
        //누적 도수
        int[] f = new int[max + 1];
        //작업용 목적 배열
        int[] b = new int[n];

        //1단계 도수분포표 만들기
        for (int i = 0; i < n; i++)
            f[a[i]]++;

        //2단계 누적도수분포표 만들기
        for (int i = 1; i <= max; i++)
            f[i] += f[i - 1];

        //3단계 목적 배열 만들기
        for (int i = n - 1; i >= 0; i--)
            b[--f[a[i]]] = a[i];

        //4단계 배열 복사하기
        for (int i = 0; i < n; i++)
            a[i] = b[i];
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
