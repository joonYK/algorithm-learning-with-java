package doIt.ch06.practice;

import java.util.Scanner;

/**
 * 단순 선택 정렬 요소의 교환 과정을 자세하게 출력할 수 있도록 SelectionSort_06_04를 수정.
 * 아래처럼 정렬하지 않은 부분의 첫 번째 요소 위에는 기호 * 를, 정렬하지 않은 부분의 가장
 * 작은 값의 요소 위에는 기호 +를 출력.
 *
 * *           +
 * 6  4  8  3  1  9  7
 *    *     +
 * 1  4  8  3  6  9  7
 *       *  +
 * 1  3  8  4  6  9  7
 * ...생략...
 *
 */
public class Q_06_06 {

    // a[idx1]와 a[idx2]의 값을 바꾼다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    //단순 선택 정렬
    static void selectionSort(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = i;    //아직 정렬되지 않은 부분에서 가장 작은 요소의 인덱스를 기록.

            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min])
                    min = j;
            }

            //정렬되지 않은 요소 위치 '*', 제일 작은 값 위치 '+' 출력 
            for (int k = 0; k < n - 1; k++)
                System.out.printf("%3c", k == i ? '*' : k == min ? '+' : ' ');
            System.out.println();

            //배열 요소 출력
            for (int k : a)
                System.out.printf("%3d", k);
            System.out.println();

            swap(a, i, min);    //아직 정렬되지 않은 부분의 첫 요소와 가장 작은 요소를 교환.
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순 선택 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("X[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        selectionSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++) {
            System.out.println("X[" + i + "]=" + x[i]);
        }
    }
}
