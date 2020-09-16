package doIt.ch06.practice;

import java.util.Scanner;

/**
 * 단순 삽입 정렬에서 배열의 첫 번째 요소 (a[0])부터 데이터를 저장하지 않고 a[1]부터 데
 * 이터를 저장하면 a[0]을 보초로 하여 삽입을 마치는 조건을 줄일 수 있다. 이 아이디어를
 * 적용한 단순 삽입 정렬 메서드를 수정.
 */
public class Q_06_07 {
    static void insertionSort(int[] a, int n) {
        for (int i = 2; i < n; i++) {

            //0번지는 보초로 사용
            int t = a[0] = a[i];
            int j;
            
            // j > 0 검사는 필요가 없음. 0번지에 보초로 세워둔 값은 t랑 같은 값이기 때문에.
            for (j = i; a[j - 1] > t ; j--)
                a[j] = a[j - 1];
            a[j] = t;
        }
    }

    // 답안지의 답
    static void insertionSort2(int[] a, int n) {
        for (int i = 2; i < n; i++) {
            int tmp = a[0] = a[i];
            int j = i;
            for (; a[j - 1] > tmp; j--)
                a[j] = a[j - 1];
            if (j > 0)
                a[j] = tmp;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순 삽입 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx + 1];

        for (int i = 1; i < nx + 1; i++) {
            System.out.print("X[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        insertionSort2(x, nx + 1);   //배열 x를 단순 삽입 정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 1; i < nx + 1; i++)
            System.out.println("X[" + i + "] = " + x[i]);
    }
}
