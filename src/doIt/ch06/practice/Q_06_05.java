package doIt.ch06.practice;

import java.util.Scanner;

/**
 * 양방향 버블 정렬
 * 홀수번째 패스에는 제일 작은 요소를 앞으로, 짝수번째 패스는 제일 큰 요소를 뒤로
 */
public class Q_06_05 {

    // a[idx1]와 a[idx2]의 값을 바꾼다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    //버블정렬 (버전 3)
    static void bubbleSort(int[] a, int n) {
        int f = 0;  //a[f]보다 앞쪽은 정렬을 마친 상태
        int r = n - 1;  //a[r]보다 뒤쪽은 정렬을 마친 상태
        boolean pathOrderOdd = true;  //패스 순서가 짝수번째 인지

        while(f < r) {
            int last = pathOrderOdd ? r : f; //마지막으로 요소를 교환한 위치

            //홀수번째 패스 (왼쪽부터 정렬)
            if(pathOrderOdd) {
                for (int j = r; j > f; j--) {
                    if (a[j - 1] > a[j]) {
                        swap(a, j - 1, j);
                        last = j;
                    }
                }
                f = last;
            //짝수번째 패스 (오른쪽부터 정렬)
            } else {
                for (int j = f; j < r; j++) {
                    if (a[j] > a[j + 1]) {
                        swap(a, j, j + 1);
                        last = j + 1;
                    }
                }
                r = last;
            }
            pathOrderOdd = !pathOrderOdd;
        }
    }

    // 답안지의 답
    static void shakerSort(int[] a, int n) {
        int left = 0;
        int right = n - 1;
        int last = right;

        while (left < right) {
            for (int j = right; j > left; j--) {
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    last = j;
                }
            }
            left = last;

            for (int j = left; j < right; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    last = j;
                }
            }
            right = last;
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
