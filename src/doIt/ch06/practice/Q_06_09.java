package doIt.ch06.practice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 셸 정렬 버전 1과 버전 2를 요소의 이동 횟수를 계산할 수 있도록 수정.
 */
public class Q_06_09 {

    static void shellSort1(int[] a, int n) {
        int count = 0;
        for (int h = n / 2; h > 0 ; h /= 2) {
            for (int i = h; i < n; i++) {
                int j;
                int tmp = a[i];
                for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
                    a[j + h] = a[j];
                    count++;
                }
                a[j + h] = tmp;
                count++;
            }
        }
        System.out.println("버전 1 이동 횟수 : " + count);
    }

    static void shellSort2(int[] a, int n) {
        int count = 0;
        int h;

        for (h = 1; h < n / 9; h = h * 3 + 1) 
            ;

        for (; h > 0 ; h /= 3) {
            for (int i = h; i < n; i++) {
                int j;
                int tmp = a[i];
                for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
                    a[j + h] = a[j];
                    count++;
                }
                a[j + h] = tmp;
                count++;
            }
        }
        System.out.println("버전 2 이동 횟수 : " + count);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];
        int[] a = new int[nx];

        for (int i = 0; i < nx; i++) {
            int num = (int) (Math.random() * 1000) + 1;
            x[i] = a[i] = num;
        }
        System.out.println(Arrays.toString(a));

        shellSort1(x, nx);  //셸 정렬 버전1로 정렬
        shellSort2(a, nx);  //셸 정렬 버전2로 정렬

        System.out.println("오름차순으로 정렬했습니다.");
        System.out.println("버전 1");
        System.out.println(Arrays.toString(x));
        System.out.println("버전 2");
        System.out.println(Arrays.toString(a));
    }
}
