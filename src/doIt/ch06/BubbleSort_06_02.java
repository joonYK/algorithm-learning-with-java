package doIt.ch06;

import java.util.Scanner;

/**
 * 버블정렬 알고리즘 개선(1)
 * 패스에서 교환 횟수를 체크하여 0이면 정렬을 멈춤
 */
public class BubbleSort_06_02 {

    // a[idx1]와 a[idx2]의 값을 바꾼다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 버블 정렬(버전 2)
    static void bubbleSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int exchg = 0;  // 패스의 교환 횟수를 기록
            for (int j = n - 1; j > i; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    exchg++;
                }
            }
            if (exchg == 0) // 교환이 이루어지지 않으면 종료
                break;
        }
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
