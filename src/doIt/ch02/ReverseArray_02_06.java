package doIt.ch02;

import java.util.Scanner;

public class ReverseArray_02_06 {

    //배열 요소 a[idx1]과 a[idx2]의 값을 바꿈
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    //배열 a의 요소를 역순으로 정렬
    static void reverse(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            swap(a, i, a.length - i - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = scanner.nextInt();

        int[] x = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("X[" + i + "] : ");
            x[i] = scanner.nextInt();
        }

        reverse(x); //역순 정렬

        System.out.println("요소를 역순으로 정렬했습니다.");
        for (int i = 0; i < num; i++) {
            System.out.println("X[" + i + "] = " + x[i]);
        }
    }

}
