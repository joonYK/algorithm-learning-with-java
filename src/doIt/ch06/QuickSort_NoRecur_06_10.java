package doIt.ch06;

import doIt.ch04.IntStack;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 퀵 정렬(비재귀 버전)
 */
public class QuickSort_NoRecur_06_10 {
    // a[idx1]와 a[idx2]의 값을 바꾼다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void quickSort(int[] a, int left, int right) {
        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        rstack.push(right);

        while (!lstack.isEmpty()) {
            int pl = left = lstack.pop();   //왼쪽 커서
            int pr = right = rstack.pop();  //오른쪽 커서
            int x = a[(left + right) / 2];  //피벗

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
            }

            //오른쪽 그룹 범위의 인덱스를 푸시
            if (pl < right) {
                lstack.push(pl);
                rstack.push(right);
            }
        }
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

        quickSort(x, 0, nx - 1);

        System.out.println("오름차순으로 정렬했습니다.");
        System.out.println(Arrays.toString(x));

    }
}
