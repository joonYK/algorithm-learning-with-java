package doIt.ch06;

import java.util.Scanner;

/**
 * 버블 정렬 알고리즘 개선(2)
 * 각 패스에서 어떤 시점 이후에 교환이 수행되지 않으면 그보다 앞쪽의 요소는 이미 정렬이 끝난것으로 간주.
 */
public class BubbleSort_06_03 {

    // a[idx1]와 a[idx2]의 값을 바꾼다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    //버블정렬 (버전 3)
    static void bubbleSort(int[] a, int n) {
        int k = 0;  //a[k]보다 앞쪽은 정렬을 마친 상태
        while(k < n - 1) {
            int last = n - 1;   //마지막으로 요소를 교환한 위치
            for (int j = n - 1; j > k; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    last = j;
                }
            }
            k = last;
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
