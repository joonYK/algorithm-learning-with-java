package doIt.ch06.practice;

import doIt.ch04.IntStack;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 실습 6-9(퀵정렬 재귀), 6-10(퀵 정렬 비재귀) quickSort 메서드를 요소의 개수가 적은 그룹을 먼저 나누는 메서드로 수정.
 */
public class Q_06_12 {

    // a[idx1]와 a[idx2]의 값을 바꾼다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    //퀵 정렬
    static void quickSort(int[] a, int left, int right) {
        int pl = left;  //왼쪽 커서
        int pr = right; //오른쪽 커서
        int x = a[(pl + pr) / 2];   //피벗

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr)
                swap(a, pl++, pr--);
        } while (pl <= pr);

        //왼쪽 그룹 요인 수
        int leftFactors = pr - left;
        //오른쪽 그룹 요인 수
        int rightFactors = right - pl;

        if(rightFactors > leftFactors) {
            //왼쪽 그룹부터 분할
            if (leftFactors > 0) quickSort(a, left, pr);
            if (rightFactors > 0) quickSort(a, pl, right);
        } else {
            //오른쪽 그룹부터 분할
            if (rightFactors > 0) quickSort(a, pl, right);
            if (leftFactors > 0) quickSort(a, left, pr);
        }

        //답안지의 답
        /*if (pr - left < right - pl) {
            int temp;
            temp = left;
            left = pl;
            pl = temp;
            temp = right;
            right = pr;
            pr = temp;
        }
        if (left < pr)
            quickSort(a, left, pr);
        if (pl < right)
            quickSort(a, pl, right);*/

    }


    static void quickSortNoRecur(int[] a, int left, int right) {
        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        rstack.push(right);

        while (!lstack.isEmpty()) {
            int pl = left = lstack.pop();   //왼쪽 커서
            int pr = right = rstack.pop();  //오른쪽 커서
            int x = a[(left + right) / 2];  //피벗

            do {
                while (a[pl] < x) pl++;
                while (a[pr] > x) pr--;
                if (pl <= pr)
                    swap(a, pl++, pr--);
            } while (pl <= pr);

            //왼쪽 그룹 요인 수
            int leftFactors = pr - left;
            //오른쪽 그룹 요인 수
            int rightFactors = right - pl;

            if(rightFactors > leftFactors) {
                //왼쪽 그룹 범위의 인덱스부터 푸시
                if (leftFactors > 0) {
                    lstack.push(left);
                    rstack.push(pr);
                }

                if (rightFactors > 0) {
                    lstack.push(pl);
                    rstack.push(right);
                }
            } else {
                //오른쪽 그룹 범위의 인덱스부터 푸시
                if (rightFactors > 0) {
                    lstack.push(pl);
                    rstack.push(right);
                }

                if (leftFactors > 0) {
                    lstack.push(left);
                    rstack.push(pr);
                }
            }

            //답안지의 답
            /*if (pr - left < right - pl) {
                int temp;
                temp = left;
                left = pl;
                pl = temp;
                temp = right;
                right = pr;
                pr = temp;
            }
            if (left < pr) {
                lstack.push(left);
                rstack.push(pr);
            }
            if (pl < right) {
                lstack.push(pl);
                rstack.push(right);
            }*/
        }
    }


    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];
        int[] a = new int[nx];

        for (int i = 0; i < nx; i++)
            x[i] = a[i] = (int) (Math.random() * nx) + 1;

        System.out.println("정렬 전");
        System.out.println("x : " + Arrays.toString(x));
        System.out.println("a : " + Arrays.toString(a));

        quickSort(x, 0, nx - 1);
        quickSortNoRecur(a, 0, nx - 1);

        System.out.println("오름차순으로 정렬했습니다.");
        System.out.println("x : " + Arrays.toString(x));
        System.out.println("a : " + Arrays.toString(a));

    }
}
