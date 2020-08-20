package doIt.ch03.practice;

import java.util.Scanner;

/**
 * 아래처럼 선형 검색의 스캐닝 과정을 상세하게 출력하는 프로그램을 작성.
 * 이때 각 행의 맨 왼쪽에 현재 검색하는 요소의 인덱스를 출력하고, 현재 검색하고 있는 요소 위에 별표 기호 *를 출력.
 *
 *      | 0 1 2 3 4 5 6
 *   ---+-----------------
 *      | *
 *    0 | 6 4 3 2 1 9 8
 *      |   *
 *    1 | 6 4 3 2 1 9 8
 *      |     *
 *    2 | 6 4 3 2 1 9 8
 *    3은 x[2]에 있습니다.
 */
public class Q_03_02 {
    //요솟수가 n인 배열 a에서 key와 같은 요소를 선형 검색
    static int seqSearch(int[] a, int n, int key) {
        System.out.printf("%4c", '|');
        for (int i = 0; i < n; i++)
            System.out.printf("%4d", i);

        System.out.print("\n---+");
        for (int i = 0; i < n; i++)
            System.out.print("----");

        System.out.println();

        for (int i = 0; i < n; i++) {
            printScanning(a, i);
            if (a[i] == key)
                return i;   //검색 성공으로 인덱스 반환
        }
        return -1;  //검색 실패로 -1 반환
    }

    static void printScanning(int[] a, int index) {
        System.out.printf("%4c", '|');
        for (int i = 0; i <= index-1; i++)
            System.out.printf("%4c", ' ');
        System.out.printf("%4c", '*');

        System.out.printf("\n%2d |", index);
        for (int i = 0; i < a.length; i++)
            System.out.printf("%4d", a[i]);

        System.out.println();
    }
/*
    //답안지의 답
    // 배열 a의 앞쪽 n개 요소에서 key와 같은 요소를 선형 검색 (보초법)
    static int seqSearchEx(int[] a, int n, int key) {
        System.out.print("   |");
        for (int k = 0; k < n; k++)
            System.out.printf("%4d", k);
        System.out.println();

        System.out.print("---+");
        for (int k = 0; k < 4 * n + 2; k++)
            System.out.print("-");
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print("   |");
            System.out.printf(String.format("%%%ds*\n", (i * 4) + 3), "");
            System.out.printf("%3d|", i);
            for (int k = 0; k < n; k++)
                System.out.printf("%4d", a[k]);
            System.out.println("\n   |");
            if (a[i] == key)
                return i; // 검색성공
        }
        return -1; // 검색실패
    }*/

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("X[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값 : ");
        int ky = stdIn.nextInt();

        int idx = seqSearch(x, num, ky);    //배열 x에서 키 값이 ky인 요소를 검색

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println(ky+"은(는) X[" + idx + "]에 있습니다.");
    }

}
