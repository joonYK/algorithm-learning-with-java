package doIt.ch06.practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 요솟값의 범위가 min 이상 max 이하이고 요소의 개수가 n개인 배열 a를 도수 정렬하는 메서드 작성.
 * static void fSort(int[] a, int n, int min, int max)
 */
public class Q_06_19 {

    static void fSort(int[] a, int n, int min, int max) {
        //누적 도수
        int[] f = new int[max - min + 1];
        //작업용 목적 배열
        int[] b = new int[n];

        //1단계 도수분포표 만들기
        for (int i = 0; i < n; i++)
            f[a[i] - min]++;

        //2단계 누적도수분포표 만들기
        for (int i = 1; i <= max - min; i++)
            f[i] += f[i - 1];

        //3단계 목적 배열 만들기
        for (int i = n - 1; i >= 0; i--)
            b[--f[a[i] - min]] = a[i];

        //4단계 배열 복사하기
        for (int i = 0; i < n; i++)
            a[i] = b[i];

    }

    //답안지의 답
    /*static void fSort(int[] a, int n, int min, int max) {
        int[] f = new int[max - min + 2]; // 누적도수
        int[] b = new int[n]; // 작업용 목적배열

        for (int i = 0; i < n; i++)
            f[a[i] - min]++; // 1단계
        for (int i = 1; i <= max - min + 1; i++)
            f[i] += f[i - 1]; // 2단계
        for (int i = n - 1; i >= 0; i--)
            b[--f[a[i] - min]] = a[i]; // 3단계
        for (int i = 0; i < n; i++)
            a[i] = b[i]; // 4단계
    }*/

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("힙 정렬");
        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        for (int i = 0; i < num; i++)
            x[i] = (int)(Math.random() * num);

        System.out.println("정렬 전 : " + Arrays.toString(x));

        int max = x[0];
        for (int i = 1; i < num; i++)
            if (x[i] > max) max = x[i];

        int min = x[0];
        for (int i = 1; i < num; i++)
            if (x[i] < min) min = x[i];

        fSort(x, num, min, max);

        System.out.println("오름차순으로 정렬했습니다.");
        System.out.println(Arrays.toString(x));
    }
}
