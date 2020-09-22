package doIt.ch06.practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 아래 형식으로 동작하는 quickSort 메서드를 구현. 두 번째 매개변수인 n은 요소의 개수.
 *
 * static void quickSort(int[] a, int n);
 */
public class Q_06_10 {
    // a[idx1]와 a[idx2]의 값을 바꾼다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void quickSort(int[] a, int left, int right) {
        int pl = left;
        int pr = right;
        int x = a[(pl + pr) / 2];

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;

            if(pl <= pr)
                swap(a, pl++, pr--);
        } while (pl <= pr);

        if (left < pr)
            quickSort(a, left, pr);

        if (pl < right)
            quickSort(a, pl, right);
    }

    static void quickSort(int[] a, int n) {
        quickSort(a, 0, n - 1);
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

        quickSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        System.out.println(Arrays.toString(x));

    }
}
