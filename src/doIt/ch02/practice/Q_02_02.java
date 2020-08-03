package doIt.ch02.practice;

import java.util.Scanner;

/**
 * 아래처럼 배열 요소를 역순으로 정렬하는 과정을 하나하나 나타내는 프로그램을 작성.
 *
 * 5 10 73 2 -5 42
 * a[0]과(와) a[5]를 교환합니다.
 * 42 10 73 2 -5 5
 * a[1]과(와) a[4]를 교환합니다.
 * 42 -5 73 2 10 5
 * a[2]과(와) a[3]을 교환합니다.
 * 42 -5 2 73 10 5
 * 역순 정렬을 마쳤습니다.
 */
public class Q_02_02 {
    //배열 요소 a[idx1]과 a[idx2]의 값을 바꿈
    static void swap(int[] a, int idx1, int idx2) {
        System.out.printf("a[%d]과(와) a[%d]를 교환합니다.\n", idx1, idx2);
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    //배열 a의 요소를 역순으로 정렬
    static void reverse(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            printArray(a);
            swap(a, i, a.length - i - 1);
        }

        printArray(a);
    }

    static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
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

        System.out.println("역순 정렬을 마쳤습니다.");
    }


    /**
     * 답안지 정답
     */
    /*// 배열의 요소 a[idx1]와 a[idx2]를 교환
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 배열 a의 요소 값을 나타냄
    static void print(int[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    // 배열 a의 요소를 역순으로 정렬
    static void reverse(int[] a) {
        print(a);
        for (int i = 0; i < a.length / 2; i++) {
            System.out.println("a[" + i + "]와 a[" + (a.length - i - 1) + "]를 교환합니다.");
            swap(a, i, a.length - i - 1);
            print(a);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수는 ：");
        int num = stdIn.nextInt(); // 요솟수

        int[] x = new int[num]; // 요솟수 num인 배열

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        reverse(x); // 배열 a의 요소를 역순으로 정렬

        System.out.println("역순 정렬을 마쳤습니다.");
//		for (int i = 0; i < num; i++)
//			System.out.println("x[" + i + "] = " + x[i]);
    }*/
}
