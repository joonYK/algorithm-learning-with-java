package doIt.ch06.practice;

import java.util.Scanner;

/**
 * 단순 삽입 정렬은 배열의 요솟수가 많아지면 많아질수록 요소 삽입에 필요한 비교, 대입
 * 비용이 무시할 수 없을 정도로 커진다. 이때 배열에서 이미 정렬된 부분은 이진 검색을 사용할
 * 수 있기 때문에 삽입할 위치를 더 빨리 찾을 수 있다. 이진 검색을 사용하여 프로그램을 수정하자.
 */
public class Q_06_08 {

    static void insertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {

            int searchIndex = binarySearch(a, i, a[i]);
            int t = a[i];

            for (int j = i; j > searchIndex; j--)
                a[j] = a[j - 1];

            a[searchIndex] = t;
        }
    }

    /**
     * 삽입할 위치 이진 검색
     * @param a 배열
     * @param on 정렬된 개수
     * @param key 삽입할 수
     * @return 삽입할 위치
     */
    static int binarySearch(int[] a, int on, int key) {
        int pl = 0; //처음
        int pr = on - 1; //마지막
        int pc = 0; //중간

        while (pr >= pl) {
            pc = (pl + pr) / 2;

            if(a[pc] > key)
                pr = pc - 1;
            else if(a[pc] < key)
                pl = pc + 1;
            else
                break;
        }

        if(pl > pr) pc = pr + 1;

        return pc;
    }

    //답안지의 답
    static void binInsertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int key = a[i];
            int pl = 0; // 검색범위 맨 앞의 인덱스
            int pr = i - 1; // 검색범위 맨 뒤의 인덱스
            int pc; // 〃 중앙의 인덱스
            int pd; // 삽입하는 위치의 인덱스

            do {
                pc = (pl + pr) / 2;
                if (a[pc] == key) // 검색성공
                    break;
                else if (a[pc] < key)
                    pl = pc + 1;
                else
                    pr = pc - 1;
            } while (pl <= pr);
            pd = (pl <= pr) ? pc + 1 : pr + 1;

            for (int j = i; j > pd; j--)
                a[j] = a[j - 1];
            a[pd] = key;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순 삽입 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("X[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        insertionSort(x, nx);   //배열 x를 단순 삽입 정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("X[" + i + "] = " + x[i]);
    }
}
