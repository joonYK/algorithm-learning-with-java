package doIt.ch06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 병합 정렬
 */
public class MergeSort_06_12 {
    static int[] buff;  // 작업용 배열

    // a[left] ~ a[right]를 재귀적으로 병합 정렬
    static void __mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int i;
            int center = (left + right) / 2;
            int p = 0;
            int j = 0;
            int k = left;

            //배열의 앞부분을 병합 정렬
            __mergeSort(a, left, center);
            //배열의 뒷부분을 병합 정렬
            __mergeSort(a, center + 1, right);

            for (i = left; i <= center ; i++)
                buff[p++] = a[i];

            while (i <= right && j < p)
                a[k++] = (buff[j] < a[i]) ? buff[j++] : a[i++];

            while (j < p)
                a[k++] = buff[j++];
        }
    }

    //병합 정렬
    static void mergeSort(int[] a, int n) {
        //작업용 배열을 생성
        buff = new int[n];

        //배열 전체를 병합 정렬
        __mergeSort(a, 0, n - 1);

        // 작업용 배열을 해제
        buff = null;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("병합 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++)
            x[i] = (int) (Math.random() * nx) + 1;

        System.out.println("정렬 전 : " + Arrays.toString(x));

        mergeSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        System.out.println(Arrays.toString(x));
    }
}
